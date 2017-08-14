// 格式化开发状态
function formatDevResult(value) {
	if (value == null || value == 0) {
		return "未开发";
	} else if (value == 1) {
		return "开发中";
	} else if (value == 2) {
		return "开发完成";
	} else if (value == 3) {
		return "开发失败";
	}
}

// 显示操作方式
function formatOptBtn (value, row) {
	if (row.devResult < 2) {
		return "<a href='javascript:openDev(0, "+ row.id +")'>开发</a>"
	} else {
		return "<a href='javascript:openDev(1, "+ row.id +")' >查看详情</a>"
	}
}

// 开发、开发详情
function openDev(type, id) {
	// ctx是定义在common.header.ftl里面的全局变量
	window.parent.openTab("查看客户开发计划项", ctx + "cus_dev_plan/index?saleChanceId=" + id + "&type=" + type, "icon-khkfjh");
	
}

// 搜索
function searchSaleChance() {
	var customerName = $("#s_customerName").val();
	var overview = $("#s_overview").val();
	var devResult = $("#s_devresult").combobox('getValue');
	$('#dg').datagrid('reload',{
		customerName: customerName,
		overview: overview,
		devResult: devResult
	});
}
