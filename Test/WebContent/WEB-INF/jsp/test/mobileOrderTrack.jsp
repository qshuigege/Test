<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="author" content="m.jd.com" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="format-detection" content="telephone=no" />
    <!-- JS AND JQUERY ,CSS -->
    <script type="text/javascript" src="js/public/jquery3.js"></script>
    <script type="text/javascript" src="js/public/jquery1.8.3.min.js"></script>
	<script type="text/javascript" src="js/mobile/mobile-logistics.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css"></link>
	<link rel="stylesheet" type="text/css" href="css/mobile/mobile-logistics.css"></link>
</head>
<body>
	 <div class="wap-mid" >
	 <c:if test="${empty ERPUSEROID}">
	 		<div class='wap-mid-s'>
				暂时还没有数据
	 		</div>
	 </c:if>
	 <c:if test="${!empty ERPUSEROID}">
	 	<c:forEach var="oid" items="${ERPUSEROID}" varStatus="status">
	 		<div class='wap-mid-s'>
	 			<a href="javascript:void(0);" onclick='goFlowOrder(${status.index}, "${oid.ORDA001OID}")'>
	 			<div class="dd-top">
	 			<c:if test="${oid.CUSTORDERNO == null}">
	 				<span class="order-info g-info"><p>&nbsp;</p></span>
	 			</c:if>
	 			<c:if test="${oid.CUSTORDERNO != null}">
	 				<span class="order-info g-info"><p>${oid.CUSTORDERNO}</p></span>
	 			</c:if>
		 			<span class='state-info g-info'>${oid.FSNO}</span>
		 			<span class='time-info g-info'>${oid.ORDERSTATUS}</span>
		 			<span style="display:none;">${oid.ORDA001OID}</span>
	 			</div>
	 			</a>
	 			<div class="logistics-flow" style="display:none;" id="flow-n${status.index}"></div>
	 			</div>
	 	</c:forEach>
	 </c:if>
	 </div>
      <div class="wap-header">
           <a href="javascript:void(0);" id="goBack" >
                <span class="header-arrow-left">
                    <img src="http://www.iconpng.com/png/font_awesome/f053.png" width="20px" height="45px" />
                 </span>
           </a>
           <span class="header-font">订单状态</span>
           <a href="javascript:void(0);" id="goInState">
            <span  class="header-font-s">筛选</span>
            <span class="header-arrow-bottom">
            </span>
           </a>
           <div id="status-right"> 
           </div>
           <div id="hidebg"></div>
      </div>
     <div class="wap-bottom">
     	<div class="search-top" id="search-top">
        </div>
     	<div class="search-bottom">
     		<a href="javascript:void(0);" id="search-dd">
            	<span class="order-search search-css">订单号</span>
            </a>
            <a href="javascript:void(0);" id="search-wtd">
            	<span class="wtd-search search-css">委托单号</span>
            </a>
        </div>
     </div>
</body>
</html>