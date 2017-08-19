<!doctype html>
<html>
<head>
<#include "common/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/customer.serve.feedback.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="客服服务反馈管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/customer_serve/list?state=3" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="customer" width="100" align="center">客户</th>
        <th field="overview" width="200" align="center">概要</th>
        <th field="serveType" width="100" align="center">服务类型</th>
        <th field="createPeople" width="100" align="center">创建人</th>
        <th field="createDate" width="100" align="center">创建日期</th>
        <th field="state" width="50" align="center" hidden="true">客服服务状态</th>
        <th field="assigner" width="50" align="center" >分配人</th>
        <th field="assignTime" width="100" align="center" >分配日期</th>
        <th field="serviceProce" width="100" align="center" hidden="true">服务处理</th>
        <th field="serviceProcePeople" width="100" align="center" >服务处理人</th>
        <th field="serviceProceTime" width="100" align="center" >服务处理日期</th>
        <th field="serviceProceResult" width="50" align="center" hidden="true">服务处理结果</th>
        <th field="myd" width="50" align="center" hidden="true">客户满意度</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openCustomerServiceFeedbackDialog()" class="easyui-linkbutton" iconCls="icon-fwfk" plain="true">客户服务反馈</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" style="width:750px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <input type="hidden" id="id" name="id"  />
        <table cellspacing="8px">
            <table cellspacing="8px">
                <tr>
                    <td>服务类型：</td>
                    <td>
                        <input type="text" id="serveType" name="serveType" readonly="readonly"/>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>客户</td>
                    <td><input type="text" id="customer" name="customer" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>概要：</td>
                    <td colspan="4">
                        <input type="text" id="overview" name="overview" style="width: 419px" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td>服务请求：</td>
                    <td colspan="4">
                        <textarea id="serviceRequest" name="serviceRequest" rows="5" cols="49" readonly="readonly"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>创建人：</td>
                    <td>
                        <input type="text" readonly="readonly" id="createPeople" name="createPeople" />
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>创建时间：</td>
                    <td><input type="text" id="createDate" name="createDate" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>分配给：</td>
                    <td>
                        <input  id="assigner" name="assigner" readonly="readonly"/>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>分配时间：</td>
                    <td>
                        <input type="text" id="assignTime" name="assignTime" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td>服务处理：</td>
                    <td colspan="4">
                        <textarea id="serviceProce" name="serviceProce" rows="5" cols="49" ></textarea>
                    </td>
                </tr>
                <tr>
                    <td>处理人：</td>
                    <td>
                        <input  id="serviceProcePeople" name="serviceProcePeople" readonly="readonly"/>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>处理时间：</td>
                    <td>
                        <input type="text" id="serviceProceTime" name="serviceProceTime" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td>处理结果：</td>
                    <td>
                        <input type="hidden" id="state" name="state" />
                        <input  id="serviceProceResult" name="serviceProceResult" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font>
                    </td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>客户满意度：</td>
                    <td>
                        <select class="easyui-combobox" style="width: 154px" id="myd" name="myd" editable="false" panelHeight="auto" >
                            <option value="">请选择...</option>
                            <option value="☆">☆</option>
                            <option value="☆☆">☆☆</option>
                            <option value="☆☆☆">☆☆☆</option>
                            <option value="☆☆☆☆">☆☆☆☆</option>
                            <option value="☆☆☆☆☆">☆☆☆☆☆</option>
                        </select>&nbsp;<font color="red">*</font>
                    </td>
                </tr>
            </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveCustomerServiceFeedback()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeCustomerFeedbackDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>