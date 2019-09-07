var navs = [
{
	"title": "基础信息管理",
	"icon": "fa-cogs",
	"spread": false,
	"children": [{
		"title": "供应商管理",
		"icon": "fa-table",
		"href": "page/basicInfo/dataInquiry.html"
	}, {
		"title": "产品库",
		"icon": "fa-navicon",
		"href": "page/basicInfo/forwardInquiry.html"
	}, {
		"title": "提出设置",
		"icon": "fa-navicon",
		"href": "page/basicInfo/forwardInquiry.html"
	}, {
		"title": "订单类别管理",
		"icon": "fa-navicon",
		"href": "page/basicInfo/forwardInquiry.html"
	}, {
		"title": "订单材质管理",
		"icon": "fa-navicon",
		"href": "page/basicInfo/forwardInquiry.html"
	}]
},
{
	"title": "订单管理",
	"icon": "fa-life-ring",
	"spread": true,
	"children": [{
		"title": "新增订单",
		"icon": "fa-check-square-o",
		"href": "page/orderInfo/orderAdd.html"
	},{
		"title": "接受订单",
		"icon": "fa-check-square-o",
		"href": "page/orderInfo/orderAccept.html"
	},{
		"title": "订单列表",
		"icon": "fa-check-square-o",
		"href": "page/orderInfo/order.html"
	},{
		"title": "订单跟踪",
		"icon": "fa-check-square-o",
		"href": "page/orderInfo/orderAfter.html"
	}]
}, {
	"title": "统计查询",
	"icon": "fa-truck",
	"href": "",
	"spread": true,
	"children": [{
		"title": "订单统计",
		"icon": "&#xe609;",
		"href": "page/statistic/orderStatistic.html"
	}, {
		"title": "提成统计",
		"icon": "&#xe609;",
		"href": "page/statistic/moneyStatistic.html"
	}, {
		"title": "意见投诉",
		"icon": "&#xe609;",
		"href": "page/statistic/adviceStatistic.html"
	}]
}, 
//{
//	"title": "这是一级导航",
//	"icon": "fa-stop-circle",
//	"href": "https://www.baidu.com",
//	"spread": false
//},
{
	"title": "系统管理",
	"icon": "&#x1002",
	"spread": true,
	"children": [{
		"title": "组织架构",
		"icon": "&#x1002",
		"href": "page/main/webapp/staticPage/sysManage/sysUnitInfo/index.html"
	}, {
		"title": "用户管理",
		"icon": "&#x1002",
		"href": "page/main/webapp/staticPage/sysManage/sysUserInfo/index.html"
	},{
		"title": "系统日志",
		"icon": "&#x1002",
		"href": "page/main/webapp/staticPage/sysManage/sysLogInfo/index.html"
	}]
}];