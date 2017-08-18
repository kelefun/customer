package com.funstill.customer.base.handler;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.funstill.customer.base.exception.WebException;
import com.funstill.customer.base.model.ResultModel;
import com.funstill.customer.base.result.DefaultResultCode;

/**
 * HandleExceptionJsonResolver 默认返回json格式异常信息
 * 
 * @author liukaiyang 2017年3月7日
 */

public class HandleExceptionResolver extends SimpleMappingExceptionResolver {

	private Logger logger = LogManager.getLogger(getClass());
	private String annotationErrorView;

	private Class<Annotation>[] classes;

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// Expose ModelAndView for chosen error view.
		ResultModel resultModel = new ResultModel<>();
		if (ex instanceof WebException) {
			WebException webException = (WebException) ex;
			if (webException.getResultModel() != null) {
				resultModel = webException.getResultModel();
				logger.error(resultModel.getErrMsg());
			} else {
				resultModel.putError(DefaultResultCode.ERROR_UNKNOWN_REASON, webException.getMessage());
			}
		} else if (ex instanceof DataAccessException) {
			resultModel.putError(DefaultResultCode.DAO_ERROR);
		} else if (ex instanceof RuntimeException) {
			resultModel.putError(DefaultResultCode.SYSTEM_ERROR);
		} else if (ex instanceof MissingServletRequestParameterException) {
			resultModel.putError(DefaultResultCode.ILLEGAL_ARGUMENT, "参数缺失");
		} else if (ex instanceof HttpRequestMethodNotSupportedException) {
			resultModel.putError(DefaultResultCode.REQUEST_ERROR_METHOD);
		} else if (ex instanceof BindException) { // spring接收参数异常
			resultModel.putError(DefaultResultCode.ILLEGAL_ARGUMENT, "参数格式不正确");
		} else {
			resultModel.putError(DefaultResultCode.ERROR_UNKNOWN_REASON);
		}
		logger.error(ex);
		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);
		if (viewName != null) {
			// Apply HTTP status code for error views, if specified.
			// Only apply it if we're processing a top-level request.
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			ModelAndView mv = null;
			if (handler instanceof HandlerMethod && hasAnnotation((HandlerMethod) handler, classes)) {
				mv = getModelAndView(annotationErrorView, ex, request);
				mv.addObject("result", resultModel);
			} else {
				mv = getModelAndView(viewName, ex, request);
				mv.addObject("result", resultModel);
			}
			return mv;
		} else {
			return null;
		}

	}

	@SafeVarargs
	private final boolean hasAnnotation(HandlerMethod handlerMethod, Class<? extends Annotation>... annotations) {
		for (Class<? extends Annotation> annotation : annotations) {
			if (AnnotationUtils.findAnnotation(handlerMethod.getMethod(), annotation) != null
					|| AnnotationUtils.findAnnotation(handlerMethod.getBean().getClass(), annotation) != null) {
				return true;
			}
		}

		return false;
	}

	public Class<Annotation>[] getClasses() {
		return classes;
	}

	public void setClasses(Class<Annotation>[] classes) {
		this.classes = classes;
	}

	public String getAnnotationErrorView() {
		return annotationErrorView;
	}

	public void setAnnotationErrorView(String annotationErrorView) {
		this.annotationErrorView = annotationErrorView;
	}
}
