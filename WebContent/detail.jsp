<%@ page import="com.hpe.util.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar.js"></script>
<title>列车车次信息</title>
<script type="text/javascript">
</script>
</head>
<body>
<div id="wrap">
	<div id="top_content">
		<%@include file="/common/head.jsp" %>
		<div id="content">
			<h1>车次详细信息</h1>
			<table class="table">
				<tr class="table_header">
					<td>车次</td>
					<td>始发站</td>
					<td>终点站</td>
					<td>出发时间</td>
					<td>到达时间</td>
					<td>车次类型</td>
					<td>运行时间（H）</td>
					<td>运行里程（KM）</td>
				</tr>
				<tr>
					<td>${findtrain.train_no }</td>
					<td>${findtrain.start_station  }</td>
					<td>${findtrain.arrival_station  }</td>
					<td>${findtrain.start_time  }</td>
					<td>${findtrain.arrival_time  }</td>
					<td>${findtrain.type  }</td>
					<td>${findtrain.runtime  }</td>
					<td>${findtrain.mile }</td>
				</tr>		
			</table>
		</div>
	</div>
	<%@include file="/common/footer.jsp" %>
</div>

</body>
</html>