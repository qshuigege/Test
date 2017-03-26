<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="author" content="m.jd.com" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="format-detection" content="telephone=no" />
    <script src="http://www.5imoban.net/download/jquery/jquery-1.8.3.min.js"></script>
<title>查询首页</title>
<style>
		A:link{text-decoration:none;}
		#body{
			text-align:center;
			min-width: 320px;
			font-family: 'microsoft yahei',Verdana,Arial,Helvetica,sans-serif;
		    margin: 0;
    		padding: 0;
		}
    	._outlayer{
			left:1%;position:absolute; width:98%; height:100%; z-index:-1;
    	}
    	.font_describe{
    		color:#e47615;
    		text-align:center;
    		font-size:22px;
    		font-family:;
    		position:relative;
    		top:20px;
    	}
    	.inlet{
    		text-align:center;
    		width:98%;
    		height:100%;
    		margin-top:20%;
    	}
    	.inlet_{float:left;width:40%;height:40%;left:10%;position:relative;}
    	#tesu img{margin-top:-18px;}
    	.img-text{position:absolute;margin-top:-20%;margin-left:10%;width:20%;}
    	.img-text img{margin-top:-5px;}
    	.intro{font-size:12px;color:white;top:16px;position:relative;font-weight:600;}
    	.tatger_b{
    		text-align:center;
    		position:fixed;
    		top:8%;
    		width:100%;
    		heihgt:100%;
    		
    	}
    	.img-text{position:fixed;}
    	.bottom_s{
    		position:fixed;
    		width:98%;
    		bottom:0px;
    		z-index:100;
    		
    	}
    	._blank{width:23%;max-height:65px;height:10%;}
    </style> 
<script type="text/javascript">
   		$(function(){
   			var MINONO,MAXONO;
   			//查询sid和erpoid
   			var  ERPUSERID = '${erpoid}';
   			var  sid =  '${sid}';
   			
   			//查询在途订单MINONO<9
   			$("#on_passage").click(function(){
   				MINONO=9;MAXONO=0;
   				var outernet =  window.location.host;
   				window.open("http://"+outernet+"/portal/r/w?sid="+sid+"&cmd=com.actionsoft.apps.fs_b2b.ckwl.CheckLogistcs.GetOrderMobileWeb&ERPUSERID="+ERPUSERID+"&MINONO="+MINONO+"&MAXONO="+MAXONO);
   			});
   			//查询已完成订单MAXONO>9
   			$("#off_the_stocks").click(function(){
   				MINONO=0;MAXONO=9;
   				var outernet =  window.location.host;
   				window.open("http://"+outernet+"/portal/r/w?sid="+sid+"&cmd=com.actionsoft.apps.fs_b2b.ckwl.CheckLogistcs.GetOrderMobileWeb&ERPUSERID="+ERPUSERID+"&MINONO="+MINONO+"&MAXONO="+MAXONO);
   			}); 
   		});
    </script>   
</head>
<%-- 		<h1>订单查询首页</h1>
		您的erpoid是：<%=request.getAttribute("erpoid") %> --%>
<body id="body">
	<div class="_outlayer">
		<img src="../../images/bgpt.png"  height="100%" width="100%"/>
		<div class="tatger_b">
			<img src="../../images/fslogo.png" height="auto"/>
			<div class="font_describe">掌握最新动态<br/>时时了解进程</div>
			<div class="inlet">
				<div id="on_passage" class="inlet_">
					<img src="../../images/ditu.png" width="80%" height="80%" />
					<div class="img-text">
						<img src="../../images/car_left.png" width="100%" height="100%" />
						<br/>
						<span class="intro">在途订单</span>
					</div>
				</div>
				<div id="off_the_stocks" class="inlet_">
					<img src="../../images/ditu.png"  width="80%" height="80%" />
					<div class="img-text" id="tesu">
						<img src="../../images/wancheng.png" width="75%" height="75%" />
						<br/>			
						<span class="intro">已完成订单</span>
					</div>
				</div>
			</div>
		</div>
		<div class="bottom_s">
			<img src="../../images/bottom1.png"  class="_blank"/>
			<img src="../../images/bottom2.png"  class="_blank"/>
			<img src="../../images/bottom3.png"  class="_blank"/>
			<img src="../../images/bottom4.png"  class="_blank"/>
		</div>
	</div>
</body>
</html>