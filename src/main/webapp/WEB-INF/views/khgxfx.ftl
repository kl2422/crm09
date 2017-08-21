<!doctype html>
<html>
<head>
    <#include "common/common.header.ftl" >
</head>
<body style="margin: 1px">
	<table id="dg" title="客户贡献分析" class="easyui-datagrid"
	       fitColumns="true" pagination="true" rownumbers="true"
	       url="${ctx}/report/khgxfx" fit="true" toolbar="#tb">
	    <thead>
	    <tr>
	        <th field="cb" checkbox="true" align="center"></th>
	        <th field="customerName" width="200" align="center" >客户名称</th>
	        <th field="totalAmount" width="200" align="center" >订单总金额</th>
	    </tr>
	    </thead>
	</table>
	<#--工具栏-->
	<div id="tb">
	    <div>
	        &nbsp;客户名称：&nbsp;<input type="text" id="s_customerName" size="20" onkeydown="if(event.keyCode==13) searchKhgxfx()"/>
	    </select>
	        <a href="javascript:searchKhgxfx()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
	    </div>
	</div>
	
	<script src="${ctx}/js/report.js" ></script>
</body>
</html>