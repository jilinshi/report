<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Object msg = request.getAttribute("msg");
	if(msg==null){
		msg="";
	}
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
<link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery/locale/easyui-lang-zh_CN.js"></script>
<title>临时救助申请</title>
</head>
<body>
<div style="padding: 100px 20px 20px 20px;">
	<form id="apply" method="post" action="TempApplyInit" target="_self">
	<table cellpadding="5" align="center">
	<tr>
        <td align="CENTER" colspan="2"><font color="#0099FF" style="font-size:25px">临&nbsp;&nbsp;时&nbsp;&nbsp;救&nbsp;&nbsp;助</font></td>
    </tr>
    <tr>
    	<td colspan="2"></td>
    </tr>
	<tr>
	<td>身份证号码：</td><td><input id="paperid" size="30" class="easyui-textbox" type="text" name="paperid" ></input></td>
	</tr>
	<tr>
	<td colspan="2">
		<div style="text-align:center;padding:5px">
			<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重置">
<!--             <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a> -->
        </div>
	</td>
	</tr>
	<tr>
		<td align="CENTER" colspan="2"><font color="red">
			<%=msg%>
		</font></td>
	</tr>
	</table>
	</form>
	<script>
        function submitForm(){
            document.getElementById('apply').submit();
        }
        function clearForm(){
            $('#apply').form('clear');
        }
    </script>
</div>
</body>
</html>