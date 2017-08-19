<html>
	<head>
		<#include "common/common.header.ftl" >
	</head>
	<body style="margin: 15px;">
		<#--客户信息展示-->
		<div class="easyui-panel" title="客户基本信息" style="width:700px;height: 100px;padding: 10px">
		    <table cellspacing="8px">
		        <input type="hidden" id="cusId" name="cusId" value="${customer.id?c}"/>
		        <tr>
		        	<td>客户编号：</td>
		            <td><input type="text" id="khno" name="khno" readonly="readonly" value="${customer.khno?if_exists}"/></td>
		            <td>客户名称：</td>
		            <td><input type="text" id="name" name="name" readonly="readonly" value="${customer.name?default('')}" /></td>
		            <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		        </tr>
		        
		    </table>
		</div>
		
		<#--联系人信息管理-->
		<br/>
		<table id="dg" title="联系人信息管理" style="width:700px;height:250px"
		       toolbar="#toolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
		    <thead>
		    <tr>
		        <th field="id" width="20">编号</th>
		        <th field="cusId" hidden="true"></th>
		        <th field="linkName" width="60" editor="{type:'validatebox',options:{required:true}}">客户联系人</th>
		        <th field="sex" width="50" editor="{type:'combobox',
		   			options:{
		   				valueField:'id',
		   				textField:'name',
		   				data:[{id:'男',name:'男'},{id:'女',name:'女'}],
		   				required:true,
		   				editable:false,
		   				panelHeight:'auto'
		   		    }}">性别</th>
		        <th field="zhiwei" width="100" editor="{type:'validatebox',options:{required:true}}">职位</th>
		        <th field="officePhone" width="100" editor="{type:'validatebox',options:{required:true}}">办公室电话</th>
		        <th field="phone" width="100" editor="{type:'validatebox',options:{required:true}}">手机号码</th>
		    </tr>
		    </thead>
		</table>
		<div id="toolbar">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add();">添加</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteLinkman();">删除</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save();">保存</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="cancelRow();">撤销行</a>
		</div>
		<script src="${ctx}/js/linkman.js" ></script>
	</body>
</html>