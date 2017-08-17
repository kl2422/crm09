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
	var param = {};
    param.saleChanceId = $("#saleChanceId").val();
    param.devResult = devResult;
    $.post("update_dev_result", param, function(result) {
        if(result.resultCode == 1) {
            $.messager.alert("系统提示", "操作成功！");
        } else {
            $.messager.alert("系统提示","操作失败！");
        }
    });
}