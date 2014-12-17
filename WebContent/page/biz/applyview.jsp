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
<div style="padding: 50px 50px 50px 50px;">
<table id="list_querydata" style="width: 100%; padding: 150px 150px 150px 150px;">
</table>
</div>
<div id="win_app" class="easyui-window" closed="true"  style="width:910px;height:380px;padding:5px;">
	<div class="easyui-layout" data-options="fit:true">
		<form id="app" method="post" action="<%=request.getContextPath()%>/tempapprove">
           <div data-options="region:'north',split:true" style="width:910px ;height:250px;padding:5px;">
               <div style="padding:5px 5px">
	            <table cellpadding="4">
	                <tr>
	                    <td>家庭编号:</td>
	                    <td><input name="familyno" class="easyui-textbox" type="text" readonly="readonly"></input></td>
	                    <td>户主姓名：</td>
	                	<td><input name="mastername" class="easyui-textbox" type="text" readonly="readonly"></input></td>
	                	<td>身份证号码：</td>
	                	<td><input name="paperid" class="easyui-textbox" type="text" readonly="readonly"></input></td>
	                	<td>救助状态：</td>
	                	<td><input name="operstate" class="easyui-textbox" type="text" readonly="readonly" size="13px"></input></td>
	                </tr>
	                <tr>
	                	<td>地址：</td>
	                    <td colspan="7"><input name="onallname" class="easyui-textbox" type="text" readonly="readonly" size="150px"></input></td>
	                </tr>
	            </table>
           		<table cellpadding="0" border="1" width="100%">
           			<tr>
           				<td width="25%">
							<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel1" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy1" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy1" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res1" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body1" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
							</table>
           				</td>
           				<td width="25%">
           					<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel2" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy2" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy2" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res2" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body2" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
							</table>
           				</td>
           				<td width="25%">
							<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel3" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy3" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy3" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res3" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body3" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
							</table>
           				</td>
           				<td width="25%">
           					<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel4" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy4" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy4" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res4" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body4" class="easyui-textbox" type="text" readonly="readonly"></input></td>
								</tr>
							</table>
           				</td>
           			</tr>
  					
           		</table>
	            </div>
	        </div>
            <div data-options="region:'center',split:true" style="width:910px;padding:8px;">
	            <table cellpadding="4">
	                <tr>
		                <td style="font-size:5;font-weight:bold;color:#006699">审批人：</td>
		                <td><input name="approveperson" class="easyui-textbox" type="text" ></input></td>
		                <td style="font-size:5;font-weight:bold;color:#006699">审批结果：</td>
		                <td><input type="radio" name="approveresult" value="1" checked="checked">同意
		                	<input type="radio" name="approveresult" value="0">不同意
		                </td>
	                </tr>
	            </table>
            </div>
            <div data-options="region:'south',border:false" style="text-align:center;padding:5px 0 0;">
            	<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:saveWin_app()" style="width:80px">保存</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:closeWin_app()" style="width:80px">关闭</a>
            </div>
            <input id="familyid" type="hidden" name="familyid" />
        </form>
    </div>
<script>
//datagrid初始化 
$('#list_querydata').datagrid({
	    title:'查询结果',
	    iconCls:'icon-search',//图标  
	    url:'<%=request.getContextPath()%>/tempapply',
		remoteSort : false,
		singleSelect : true,//是否单选    
		rownumbers : true,
		queryParams: {
			'p': '<%=request.getAttribute("p")%>',
		},
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
	                       var d = '<a href="javascript:void(0)" onclick="apply(\''+ rec.familyid +'\')">申请</a> ';
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
	function apply(fid){
    	var win;
    	win = $('#win_app').window({
    		title:"审批",
    		modal:true
        });
    	$('#app').form('load','<%=basePath%>tempapproveinfo?familyid='+fid);	
    	win.window('open');
    }
    function closeWin_app(){
    	$('#win_app').window('close');
    };
    function saveWin_app(){
    	
    	$.ajax({
            type: "POST",
            url: '<%=request.getContextPath()%>/tempapprove',
            dataType: "json",
            async: false,
            success: function(data){
            	alert("111");
            }
    	});
    	
    }
	</script>
</body>
</html>