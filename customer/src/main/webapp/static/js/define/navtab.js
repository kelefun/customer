layui.define(['element'], function(exports){
   var  element = layui.element,
//		layer = parent.layer === undefined ? layui.layer : parent.layer,
        $ = layui.jquery;
	var $titleBox=	$('ul.layui-tab-title');
   
   var isTabExist = function(tabTitle) {
		var  tabIndex = -1;
		$titleBox.find('li').each(function(i, e) {
			var $em = $(this).children('em');
			if ($em.text() === tabTitle) {
				tabIndex = i;
			}
		});
		return tabIndex;
	}
   var navtab = {
	   /**
	     * [tabAdd 增加选项卡，如果已存在则增加this样式]
	     * @param  data--- {title:"",url:"",icon:""}
	     */
	     tabAdd : function(data){
		    var tabIndex = isTabExist(data.title);
		    if (tabIndex === -1) {
				// 创建新tab
				element.tabAdd('page-tab', {
					title : '<em>' + data.title + '</em>',
					content : "<iframe src=\"" + data.url + "\" class=\"layui-iframe\"></iframe>"
				});
				// 切换到此tab
				element.tabChange('page-tab',  $titleBox.find('li').length - 1);
			} else {
				element.tabChange('page-tab', tabIndex);
			}
	    }
   };
   
   exports("navtab",navtab);
    
});
