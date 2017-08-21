<!doctype html>
<html>
<head>
<#include "common/common.header.ftl" >
    <script type="text/javascript">

        function searchProduct(){
            $("#dg").datagrid('load',{
                "productName":$("#s_productName").val()
            });
        }

    </script>
</head>
<body style="margin: 1px">
<table id="dg" title="产品信息查询" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/product/list" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="productName" width="200" align="center">产品名称</th>
        <th field="model" width="100" align="center">型号</th>
        <th field="unit" width="50" align="center">单位</th>
        <th field="price" width="80" align="center">价格</th>
        <th field="store" width="80" align="center">库存</th>
        <th field="remark" width="200" align="center">备注</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        &nbsp;产品名称：&nbsp;<input type="text" id="s_productName" size="20" onkeydown="if(event.keyCode==13) searchProduct()"/>
        <a href="javascript:searchProduct()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

</body>
</html>