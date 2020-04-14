<%@ page import="com.hpe.util.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/calendar.js"></script>
<script type="text/javascript" src='<c:url value="/js/jquery-1.8.3.min.js" />'></script>
<script type="text/javascript" src='<c:url value="/js/list.js" />'></script>
<title>列车车次管理</title>
<script type="text/javascript">
//删除
		
function delTrain(){
	var nums = $("form").find("input[name='delTrain']:checked")
	var del = new Array();
	for(var i = 0;i <nums.length;i ++){
		del[i] = nums[i].value;
	}
	if(del.length == 0){
		alert("请选择车次！");
	}else{
		var falg = window.confirm("是否删除？");
		if(falg){
			//执行删除动作
			document.form1.action="<%=request.getContextPath()%>/trainListServlet?method=deltrain&del="+del;
			document.form1.submit();
		}

	}
}
</script>
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<%@include file="/common/head.jsp"%>
			<div id="content">
				<h1>列车车次</h1>
				<form name="form1" method="post">
				<table class="table">
					<tr class="table_header">
						<td><a href="javascript:delTrain();">删除</a></td>
						<td>始发站</td>
						<td>终点站</td>
						<td>出发时间</td>
						<td>到达时间</td>
						<td>车次类型</td>
						<td>运行时间</td>
					</tr>
				<c:forEach items="${trainList }" var="trainInfo" varStatus="num">
					<tr class="row${num.index % 2 +1}">
						<td><input name="delTrain" type="checkbox" value="${trainInfo.train_no}" /></td>
						<td><a href="<%=request.getContextPath()%>/trainListServlet?method=findtrain&trainInfo=${trainInfo.train_no}">${trainInfo.train_no}</a></td>
						<td>${trainInfo.arrival_station  }</td>
						<td>${trainInfo.start_time  }</td>
						<td>${trainInfo.arrival_time  }</td>
						<td>${trainInfo.type  }</td>
						<td>${trainInfo.runtime  }</td>
					</tr>
				</c:forEach>
				</table>
				</form>
				<!-- <p>
					<c:if test="${page.curPage == 1}">首页</c:if>
					<c:if test="${page.curPage > 1}">
						<a href="javascript:jump(1)">首页</a>
					</c:if>
					<c:if test="${page.curPage == 1 }">上一页</c:if>
					<c:if test="${page.curPage > 1 }">
						<a href="javascript:jump(${page.curPage-1 })">上一页</a>
					</c:if>
					<c:if test="${page.curPage == page.totalPage }">下一页</c:if>
					<c:if test="${page.curPage < page.totalPage }">
						<a href="javascript:jump(${page.curPage+1 })">下一页</a>
					</c:if>
					<c:if test="${page.curPage == page.totalPage }">末页</c:if>
					<c:if test="${page.curPage < page.totalPage }">
						<a href="javascript:jump(${page.totalPage })">末页</a>
					</c:if>
					共${page.totalPage }页 当前页${page.curPage } 总共${page.rows }条数据
				</p>
				 -->
			</div>
		</div>
		<%@include file="/common/footer.jsp"%>
	</div>

</body>
</html>