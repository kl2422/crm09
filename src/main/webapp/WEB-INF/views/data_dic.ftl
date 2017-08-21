<!doctype html>
<html>
<head>

<#include "common/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/data.dic.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="数据字典管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/datadic/list" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="dataDicName" width="100" align="center">数据字典名</th>
        <th field="dataDicValue" width="100" align="center">数据字典值</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openDataDicAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openDataDicModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteDataDic()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;数据字典名：&nbsp;<input class="easyui-combobox" id="s_dataDicName" data-options="panelHeight:'auto',editable:true,valueField:'dataDicName',textField:'dataDicName',url:'${ctx}/datadic/find_all'"/>
        &nbsp;数据字典值：&nbsp;<input type="text" id="s_dataDicValue" size="20" onkeydown="if(event.keyCode==13) searchDataDic()"/>
        <a href="javascript:searchDataDic()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" style="width:620px;height:150px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">
        <input id="dataDicId" type="hidden"  />
        <table cellspacing="8px">
            <tr>
                <td>字典名：</td>
                <td><input class="easyui-combobox" id="dataDicName" name="dataDicName" data-options="panelHeight:'auto', editable:'true',valueField:'dataDicName',textField:'dataDicName',url:'${ctx}/datadic/find_all'"/>&nbsp;<font color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>字典值：</td>
                <td><input type="text" id="dataDicValue" name="dataDicValue" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveDataDic()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeDataDicDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>