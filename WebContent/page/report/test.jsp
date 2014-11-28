<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>临时救助</title>
</head>
<body>
<form action ="<%=request.getContextPath()%>/report" target="_top" method="post">
CS:<input type="text" name="ds" value="cs"/>
FID:<input type="text" name="fid" value="50434"/>
FID:<input type="text" name="mid" value="118656"/>
FID:<input type="text" name="jpt" value="pdf"/>
</form>
<script type="text/javascript">
document.forms[0].submit();
</script>
</body>
</html>