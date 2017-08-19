<!doctype html>
<html>
<head>
	<#include "common/common.header.ftl" >
</head>
<body style="margin: 15px">
    <input type="hidden" id="lossId" value="${customerLoss.id?c}" />
	<div id="p" class="easyui-panel" title="客户流失基本信息" style="width: 800px;height: 130px;padding: 10px">
	    <table cellspacing="8px">
	        <tr>
	            <td>客户编号：</td>
	            <td><input type="text" id="cusNo" name="cusNo" readonly="readonly" value="${customerLoss.cusNo?if_exists}"/></td>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td>客户名称</td>
	            <td><input type="text" id="cusName" name="cusName" readonly="readonly" value="${customerLoss.cusName?if_exists}" /></td>
	        </tr>
	        <tr>
	            <td>客户经理：</td>
	            <td><input type="text" id="cusManager" name="cusManager" readonly="readonly" value="${customerLoss.cusManager?if_exists}"/></td>
	            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td>上次下单时间：</td>
	            <td><input type="text" id="lastOrderTime" name="lastOrderTime" readonly="readonly" <#if customerLoss.lastOrderTime?exists >value="${customerLoss.lastOrderTime?string('yyyy-MM-dd HH:mm:ss')}" </#if>/></td>
	        </tr>
	    </table>
	</div>
	
	<br/>
	<table id="dg" title="客户流失暂缓措施管理" style="width:800px;height:350px"
	       toolbar="#toolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
	    <thead>
	    <tr>
	        <th field="id" width="50">编号</th>
	        <th field="measure" width="300" editor="{type:'validatebox',options:{required:true}}">暂缓措施</th>
	    </tr>
	    </thead>
	</table>
	
	<div id="toolbar">
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#dg').edatagrid('addRow')">添加</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="$('#dg').edatagrid('destroyRow')">删除</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="$('#dg').edatagrid('cancelRow')">撤销行</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-confirm" plain="true" onclick="confirmLoss()">确认流失</a>
	</div>
	<script type="text/javascript" src="${ctx}/js/customer.reprieve.js"></script>
</body>
</html>