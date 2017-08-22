layui.config({
  base: '/static/' //扩展组件目录
}).extend({ //设定组件别名
	navtab: 'js/define/navtab',
});
layui.use(['element', 'layer', 'util'], function() {
  var $ = layui.jquery,
    layer = layui.layer,
    element = layui.element,
    util = layui.util;
});
