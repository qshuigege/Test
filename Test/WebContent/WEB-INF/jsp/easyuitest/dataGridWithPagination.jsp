<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>Basic Pagination - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.1/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.1/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.1/demo.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
</head>

<script type="text/javascript">
var datagridd;
var pageSize;
var pageNumber;
var total = ${total};
var flag = false;//默认为false,当用户主动输入条件，点击查询按钮，flag需置为true
var paramsStr = "classname:classname|methodname:methodname|page:1|rows:10|total:"+total;

/* var toolbar = [
   	{
   		text:"添加",
   		style:"background-color: #5bb75b;border: 1px solid #5bb75b;padding: 3px 18px;color: #FFFFFF;margin: 5px 5px;border-radius:2px;",
		handler:function(){
			alert("添加");
		}
	}
]; */
$(function(){
	//alert("nani?");
	datagridd = $("#mydatagrid").datagrid({
	    url:'${pageContext.request.contextPath}/controller/EasyUITestController/dataGridWithPagination.action',
	    columns:[[
    	    {field:'GKW01D1OID',title:'GKW01D1OID'},
    	    {field:'PartnerShortName',title:'PartnerShortName'},
    	    {field:'GKWNo',title:'GKWNo'},
    	    {field:'GCDate',title:'GCDate'},
    	    {field:'FIName',title:'FIName'},
    	    {field:'FIProNo',title:'FIProNo'},
    	    {field:'FIOrdNo',title:'FIOrdNo'},
			{field:'FIWLNo',title:'FIWLNo'},
			{field:'MZCWLNo',title:'MZCWLNo'},
			{field:'Suplier',title:'Suplier'},
			{field:'FIBrand',title:'FIBrand'},
			{field:'GCChip',title:'GCChip'},
			{field:'GCQty',title:'GCQty'},
			{field:'YCKqty',title:'YCKqty'},
			{field:'Remains',title:'Remains'},
			{field:'GKW01_FK',title:'GKW01_FK'},
			{field:'BASB001_FK',title:'BASB001_FK'}
	    ]],
	    pagination:true,
	    pageSize:10,
	    pageList:[5,10,15,20],
	    title:'yonghuguanli',
	    rownumbers:true,
	    toolbar:'#tb',
	    queryParams:{
	    	paramsStr:paramsStr,
	    	total:total
	    },
	    onLoadSuccess:function(data){
	    	/* pageSize = datagridd.datagrid("getPager").data("pagination").options.pageSize;
	    	pageNumber = datagridd.datagrid("getPager").data("pagination").options.pageNumber;
	    	total = datagridd.datagrid("getPager").data("pagination").options.total;
	    	//alert("size-->"+pageSize+", cur-->"+pageNumber+", total-->"+total);
	    	paramsStr = "classname:classname|methodname:methodname|page:"+pageNumber+"|rows:"+pageSize+"|total:"+total;
	    	//debugger;
	    	datagridd.datagrid("options").queryParams.paramsStr = paramsStr; */
	    	//total = datagridd.datagrid("getPager").data("pagination").options.total;
	    	total = data.total;
	    	flag = false;
	    	
	    },
	    onBeforeLoad:function(param){
	    	/* debugger;
	    	alert(param);//param对象默认有page和rows两个属性，再加上queryParams里面定义的属性
	    	pageSize = datagridd.datagrid("getPager").data("pagination").options.pageSize;
	    	pageNumber = datagridd.datagrid("getPager").data("pagination").options.pageNumber;
	    	total = datagridd.datagrid("getPager").data("pagination").options.total; */
	    	//alert("size-->"+pageSize+", cur-->"+pageNumber+", total-->"+total);
	    	
	    	debugger;
	    	var paramsStr = "classname:classname|methodname:methodname|page:"+param.page+"|rows:"+param.rows+"|total:"+total+"|param_GKWNo:"+$("#search_GKWNo").val()+"|param_FIOrdNo:"+$("#search_FIOrdNo").val()+"|flag:"+flag;
	    	//datagridd.datagrid("options").queryParams.paramsStr = paramsStr;
	    	param.paramsStr = paramsStr;
	    	return true;
	    	
	    }
	});
	
	
	
	$("#btn_search_GKWNo_FIOrdNo").click(function(){
		
		//alert("hello!");
		flag = true;
		
		datagridd.datagrid("load");
		
	});
	
	
	/* var pager = $("#mydatagrid").datagrid("getPager");
	pager.pagination({
		onSelectPage:function(pageNumber, pageSize){
			alert("are you ok?"+pageNumber+"-->"+pageSize);
			datagrid.datagrid({
				url:"${pageContext.request.contextPath}/controller/EasyUITestController/dataGridWithPagination.action?page="+pageNumber+"&rows="+pageSize
				//url:"./w?sid=<#sid>&cmd=com.actionsoft.apps.controller.BOTestController.testBO&paramsStr=classname:com.actionsoft.apps.fs_b2b.diycontroller.ChengPinChuKuController|methodname:pagenationData|total:<#total>|page:"+pageNumber+"|rows:"+pageSize
			})
		}
	}); */
	//$('#mydatagrid').datagrid('load');
	//alert("are you ok?");
});

</script>
<body>

<div class="easyui-tabs" style="width:700px;height:500px;">

	<div title="采购单明细跟踪" style="padding: 10px;">
		<table id="mydatagrid"> <%-- class="easyui-datagrid" style="width:100%;height:100%;"
			url="${pageContext.request.contextPath}/controller/EasyUITestController/dataGridWithPagination.action"
			rownumbers="true" pagination="true" data-options="toolbar:'#tb'">
			<thead>
				<tr>
					<th field="uuid" width="80">UUID</th>
					<th field="aaa" width="80">Item ID</th>
					<th field="bbb" width="80">Product ID</th>
					<th field="ccc" width="80" align="right">List Price</th>
					<th field="ddd" width="80" align="right">Unit Cost</th>
					<th field="eee" width="150">Attribute</th>
					<th field="GKW01D1OID" >GKW01D1OID</th>
					<th field="PartnerShortName" >客户简称</th>
					<th field="GKWNo" >采购单号</th>
					<th field="GCDate" >采购单日期</th>
					<th field="FIName" >终端客户名称</th>
					<th field="FIProNo" >终端项目编号</th>
					<th field="FIOrdNo" >终端订单号码</th>
					<th field="FIWLNo" >终端物料编码</th>
					<th field="MZCWLNo" >模组厂物料编码</th>
					<th field="Suplier" >供应商</th>
					<th field="FIBrand" >品牌</th>
					<th field="GCChip" >摄像头芯片型号</th>
					<th field="GCQty" >项目总数</th>
					<th field="YCKqty" >模组成品发货数量</th>
					<th field="Remains" >模组成品未发货数量</th>
					<th field="GKW01_FK" >GKW01_FK</th>
					<th field="BASB001_FK" >客户外键</th>
				</tr>
			</thead> --%>
		</table>
		<div id="tb">
			<button type="button" style="background-color: #5bb75b;border: 1px solid #5bb75b;padding: 3px 18px;color: #FFFFFF;margin: 5px 5px;border-radius:2px;">生成送货单</button>
			<div class="aws-grid-toolbar ui-grid-toolbar">
			<button type="button" class="button"
				style="margin: 1px 8px 0px 0px; display: none;">刷新</button>
			<table>
				<tbody>
					<tr>
						<td>采购单号</td>
						<td class="dwSenTdR"><input
							style="width: 176px; height: 22px;" type="text"
							onblur="CustomerOrder()" id="search_GKWNo"/></td>
						<td>终端订单号</td>
						<td class="dwSenTdR"><input
							style="width: 176px; height: 22px;" type="text"
							onblur="Supplier()" id="search_FIOrdNo"/></td>
						<td class="dwSenTdL">
							<button style="background-color: #2375BE; border: 1px solid #2375BE; padding: 3px 18px; color: #FFFFFF; margin: 5px 5px; border-radius: 2px;"
								type="button" id="btn_search_GKWNo_FIOrdNo">查询</button>
						</td>
						<td class="dwSenTdL">
							<button style="background-color: #2375BE; border: 1px solid #2375BE; padding: 3px 18px; color: #FFFFFF; margin: 5px 5px; border-radius: 2px;" 
								type="button"
								id="btn_reset_GKWNo_FIOrdNo">重置</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</div>
	</div>
	
	
</div>
</body>
</html>
