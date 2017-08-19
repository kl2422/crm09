<!doctype html>
<html>
<head>
	<#include "common/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/order.js"></script>
</head>
<body style="margin: 15px">
<input type="hidden" id="cusId" value="${customerId?c}" />
<div id="p" class="easyui-panel" title="客户基本信息" style="width: 900px;height: 100px;padding: 10px">
    <table cellspacing="8px">
        <tr>
            <td>客户编号：</td>
            <td><input type="text" id="khno" name="khno" readonly="readonly" value="${customer.khno?if_exists}"/></td>
            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td>客户名称</td>
            <td><input type="text" id="name" name="name" readonly="readonly" value="${customer.name?if_exists}"/></td>
        </tr>
    </table>
</div>

<br/>
	<table id="dg" title="客户历史订单" class="easyui-datagrid"
	       fitColumns="true" pagination="true" rownumbers="true"
	       url="${ctx}/order/list?customerId=${customerId?c}" style="width: 900px;height: 350px"  >
	    <thead>
	    <tr>
	        <th field="id" width="50" align="center">编号</th>
	        <th field="orderNo" width="100" align="center">订单号</th>
	        <th field="orderDate" width="100" align="center">订购日期</th>
	        <th field="address" width="200" align="center">送货地址</th>
	        <th field="state" width="50" align="center" formatter="formatState">状态</th>
	        <th field="a" width="50" align="center" formatter="formatAction">操作</th>
	    </tr>
	    </thead>
	</table>

	<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>订单号：</td>
                <td><input type="text" id="orderNo" name="orderNo" readonly="readonly"/></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>订购日期</td>
                <td><input type="text" id="orderDate" name="orderDate" readonly="readonly" /></td>
            </tr>
            <tr>
                <td>送货地址：</td>
                <td><input type="text" id="address" name="address" readonly="readonly"/></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>总金额</td>
                <td><input type="text" id="totalPrice" name="totalPrice" readonly="readonly" /></td>
            </tr>
            <tr>
                <td>状态：</td>
                <td><input type="text" id="state" name="state" readonly="readonly"/></td>
                <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
        </table>
        <br/>
        <table id="dg2" title="订购详情" class="easyui-datagrid"
               fitColumns="true" pagination="true" rownumbers="true"
               url="${ctx}/order_details/list" style="width: 600px;height: 220px"  >
            <thead>
            <tr>
                <th field="id" width="50" align="center">编号</th>
                <th field="goodsName" width="150" align="center">商品名称</th>
                <th field="goodsNum" width="50" align="center">订购数量</th>
                <th field="unit" width="50" align="center">单位</th>
                <th field="price" width="50" align="center">单价(元)</th>
                <th field="sum" width="80" align="center" >金额(元)</th>
            </tr>
            </thead>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:closeOrderDetailsDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>