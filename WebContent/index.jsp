<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div style="padding: 100px 1000px 1000px 20px;">
<table cellpadding="5" align="center"><tr><td>
<a href="<%=request.getContextPath()%>/page/biz/tempapply.jsp?onno=220201&ds=cs&empid=222">临时救助申请（社区）</a>
<br/>
<br/>
<a href="<%=request.getContextPath()%>/page/biz/tempapprove.jsp?onno=220201&ds=cs&empid=222">临时救助审批（街道）</a>
<br/>
<br/>
<a href="<%=request.getContextPath()%>/page/biz/tempapproveend.jsp?onno=220201&ds=cs&empid=222">临时救助审批（区县）</a>
<br/>
<br/>
<a href="<%=request.getContextPath()%>/page/biz/tempquery.jsp?onno=220201&ds=cs&empid=222">临时救助查询</a>
</td></tr>
</table>
</div>
</body>
</html>