$(document).ready(function() {
	var saleChanceId = $("#saleChanceId").val();
	$('#dg').edatagrid({    
	    url: 'list?saleChanceId=' + saleChanceId, // 拉取数据    
	    saveUrl: 'add?saleChanceId=' + saleChanceId, 
	    updateUrl: 'update', 
	    destroyUrl: 'delete', 
	}); 
});

// 添加计划
function addPlan() {
	$("#dg").edatagrid('addRow');
}

// 保存计划
function save() {
	$("#dg").edatagrid('saveRow');
	$("#dg").edatagrid('reload');
}

// 删除
function deletePlan() {
	$("#dg").edatagrid('destroyRow');
}

// 撤销行
function cancelRow() {
	$("#dg").edatagrid('cancelRow');
}

// 开发成功和失败
function updateSaleChanceDevResult(devResult) {
	var saleChanceId = $("#saleChanceId").val();
	// ajax请求后台接口 修改sale_chance的dev_result
}