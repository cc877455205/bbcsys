/**
 * list.jsp页面 展示所用到的js
 * @param curpage
 */
function delUser(userid,url){
	//alert("1");
	// 模糊查询的数据传递到后台
	$("form").attr("action",url+"?userid="+userid);
	$("form").submit();
}

function updateUser(userid,url){
	$("form").attr("action",url + "?userid="+ userid);
	$("form").submit();
}