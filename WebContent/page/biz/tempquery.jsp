<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery/demo/demo.css">
<script type="text/javascript" src="<%=basePath%>jquery/jquery.min.js"></script>
<script type="text/javascript"src="<%=basePath%>jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery/locale/easyui-lang-zh_CN.js"></script>
<title>临时救助查询</title>
</head>
<body>
	<div style="padding: 1px 1px 1px 1px">
			<table cellpadding="1" width="100%">
			<tr>
				<td>家庭编号：<input id="familyno" size="20"
					class="easyui-textbox" type="text" name="familyno"
					data-options=""></input></td>
				<td>姓名：<input id="mastername" size="20"
					class="easyui-textbox" type="text" name="mastername"
					data-options=""></input></td>
				<td>身份证号：<input id="paperid" size="25"
					class="easyui-textbox" type="text" name="paperid"
					data-options=""></input></td>
				<td>来源:<input id="ds" size="20" class="easyui-textbox" name="ds" type="text" ></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="submitForm()" icon="icon-search">查询</a> <a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="clearForm()" icon="icon-redo">导出</a></td>
			</tr>
		</table>
		<table id="list_data" style="width: 100%; padding: 20px 20px 20px 20px;">
		</table>
	</div>
	<script>
	//datagrid初始化 
	$('#list_data').datagrid({
	    title:'查询结果',
	    iconCls:'icon-search',//图标  
	    url:'<%=request.getContextPath()%>/tempquery',
		remoteSort : false,
		singleSelect : true,//是否单选  
		pagination : true,//分页控件  
		rownumbers : true,
		pageNumber:1,
		pageSize:15,
		pageList:[ 5, 10, 15 ,20,25,30],
		columns:[[  
				 {field:'mastername',title:'户主姓名',width:'5%'},
				 {field:'paperid',title:'身份证号码',width:'12%'},
				 {field:'familyno',title:'家庭编号',width:'10%'},
				 {field:'operstate',title:'救助状态',width:'5%'},
				 {field:'percount',title:'家庭人口数',width:'5%'},
				 {field:'salcount',title:'受助人口数',width:'5%'},
				 {field:'onallname',title:'地址'},
				 {field:'opt',title:'操作',align:'center', width:'5%',
	                   formatter:function(value,rec,index){
	                       var d = '<a href="javascript:void(0)" onclick="view(\''+ rec.paperid +'\')">查看</a> ';
	                       return d;
	                   }
	                 }
				 
        ]],
		loadFilter: function(data){
			if (data.d){
				return data.d;
			} else {
				for (var i = 0; i < data.rows.length; i++) {
					for (var att in data.rows[i]) {
						if(data.rows[i][att]=="null"){
							data.rows[i][att]="";
						}
		               }
				}
				return data;
			}
		}
	});
	</script>
	<script>
	function submitForm(){
    	$('#list_data').datagrid({
    		queryParams: {
    			'familyno': $('#familyno')[0].value,
    			'mastername': $('#mastername')[0].value,
    			'paperid': $('#paperid')[0].value,
    			'ds':$('#ds')[0].value,
    			'onno':'2202010102'
    		},
    		pageNumber:1,
    		pageSize:15,
    		pageList:[ 5, 10, 15 ,20,25,30]
    	});
    };
    function view(p){
    	alert(p);
    }
	</script>
</body>
</html>