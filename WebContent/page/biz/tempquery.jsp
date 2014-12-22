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
<script>
function viewinfo(id){
	var win;
	win = $('#win_view').window({
		title:"查看",
		modal:true
    });
	$('#view').form('load','<%=basePath%>tempapproveinit?tjzid='+id);	
	win.window('open');

};
function closeWin_app(){
	$('#win_view').window('close');
};
function cancel(id){
	alert(id);
}
</script>
<body>
	<div style="padding: 1px 1px 1px 1px">
			<table cellpadding="1" width="100%">
			<tr>
				<td>机构:
					<input class="easyui-combobox" name="orgno" id="orgno"
			            data-options="
			                    url:'<%=request.getContextPath()%>/temporg?orgno=220201',
			                    method:'post',
			                    valueField:'on_no',
			                    textField:'on_name',
			                    panelHeight:'auto'
			            "/>
				</td>
				<td>家庭编号：<input id="familyno" size="20"
					class="easyui-textbox" type="text" name="familyno"
					data-options=""></input></td>
				<td>姓名：<input id="mastername" size="20"
					class="easyui-textbox" type="text" name="mastername"
					data-options=""></input></td>
				<td>身份证号：<input id="paperid" size="25"
					class="easyui-textbox" type="text" name="paperid"
					data-options=""></input></td>
				<td>来源： 
					<input class="easyui-combobox" name="ds" id="ds"
			            data-options="
			                    url:'page/biz/combobox_ds.json',
			                    method:'get',
			                    valueField:'value',
			                    textField:'text',
			                    panelHeight:'auto'
			            "/>
				<td>审批结果:
					<input class="easyui-combobox" name="approveend" id="approveend"
			            data-options="
			                    url:'page/biz/combobox_approveend.json',
			                    method:'get',
			                    valueField:'value',
			                    textField:'text',
			                    panelHeight:'auto'
			            "/>
				</td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="submitForm()" icon="icon-search">查询</a> <a href="<%=request.getContextPath()%>/downloadexcel"
					class="easyui-linkbutton" icon="icon-redo">导出</a></td>
			</tr>
		</table>
		<table id="list_data" style="width: 100%; padding: 20px 20px 20px 20px;">
		</table>
	</div>
	<div id="win_view" class="easyui-window" closed="true"  style="width:910px;height:500px;padding:5px;">
	<div class="easyui-layout" data-options="fit:true">
		<form id="view" name="view" method="post" action="<%=request.getContextPath()%>/tempapprove">
           <div data-options="region:'north',split:true" style="width:910px ;height:270px;padding:5px;">
               <div style="padding:5px 5px">
	            <table cellpadding="4">
	                <tr>
	                    <td>家庭编号:</td>
	                    <td><input name="familyno" class="easyui-textbox" type="text" disabled="disabled"></input></td>
	                    <td>户主姓名：</td>
	                	<td><input name="mastername" class="easyui-textbox" type="text" disabled="disabled"></input></td>
	                	<td>身份证号码：</td>
	                	<td><input name="paperid" class="easyui-textbox" type="text" disabled="disabled"></input></td>
	                	<td>救助状态：</td>
	                	<td><input name="operstate" class="easyui-textbox" type="text" disabled="disabled" size="13px"></input></td>
	                </tr>
	                <tr>
	                	<td>地址：</td>
	                    <td colspan="7"><input name="onallname" class="easyui-textbox" type="text" disabled="disabled" size="150px"></input></td>
	                </tr>
	            </table>
	            <hr noshade color="#0066cc">
           		<table cellpadding="0" border="0" width="100%" >
           			<tr>
           				<td width="25%">
							<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel1" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy1" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy1" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res1" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body1" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
							</table>
           				</td>
           				<td width="25%">
           					<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel2" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy2" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy2" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res2" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body2" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
							</table>
           				</td>
           				<td width="25%">
							<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel3" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy3" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy3" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res3" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body3" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
							</table>
           				</td>
           				<td width="25%">
           					<table cellpadding="2">
								<tr>
									<td>家庭关系：</td>
									<td><input name="rel4" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>姓名：</td>
									<td><input name="xm_jtcy4" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身份证号：</td>
									<td><input name="sfzh_jtcy4" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>户籍：</td>
									<td><input name="res4" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
								<tr>
									<td>身体状况：</td>
									<td><input name="body4" class="easyui-textbox" type="text" disabled="disabled"></input></td>
								</tr>
							</table>
           				</td>
           			</tr>
           		</table>
           		<hr noshade color="#0066cc">
	            </div>
	        </div>
            <div data-options="region:'center',split:true" style="width:910px;padding:8px;">
	            <table cellpadding="4">
	                <tr>
		                <td style="font-size:5;font-weight:bold;color:#006699">社区审批人：</td>
		                <td><input name="approveperson1" class="easyui-textbox" type="text" disabled="disabled"></input></td>
		                <td style="font-size:5;font-weight:bold;color:#006699">社区审批结果：</td>
		                <td>
		                <input name="approveresult1txt" class="easyui-textbox" type="text" disabled="disabled"></input>
		                </td>
		                <td style="font-size:5;font-weight:bold;color:#006699">社区审批时间：</td>
		                <td><input name="aprrovedate1" class="easyui-textbox" type="text" disabled="disabled" size="30px"></td>
	                </tr>
	                <tr>
		                <td style="font-size:5;font-weight:bold;color:#006699">街道审批人：</td>
		                <td><input name="approveperson2" class="easyui-textbox" type="text" disabled="disabled"></input></td>
		                <td style="font-size:5;font-weight:bold;color:#006699">街道审批结果：</td>
		                <td>
		                <input name="approveresult2txt" class="easyui-textbox" type="text" disabled="disabled"></input>
		                </td>
		                <td style="font-size:5;font-weight:bold;color:#006699">街道审批时间：</td>
		                <td><input name="aprrovedate2" class="easyui-textbox" type="text" disabled="disabled" size="30px"></td>
	                </tr>
	                <tr>
		                <td style="font-size:5;font-weight:bold;color:#006699">街道审批人：</td>
		                <td><input name="approveperson3" class="easyui-textbox" type="text" disabled="disabled"></input></td>
		                <td style="font-size:5;font-weight:bold;color:#006699">街道审批结果：</td>
		                <td>
		                <input name="approveresult3txt" class="easyui-textbox" type="text" disabled="disabled"></input>
		                </td>
		                <td style="font-size:5;font-weight:bold;color:#006699">街道审批时间：</td>
		                <td><input name="aprrovedate3" class="easyui-textbox" type="text" disabled="disabled" size="30px"></input></td>
	                </tr>
	                <tr>
	            		<td style="font-size:5;font-weight:bold;color:#006699">救助金额：</td>
	            		<td colspan="5"><input id="approvemoney" name="approvemoney" class="easyui-textbox" type="text" disabled="disabled"></input></td>
	            	</tr>
	            </table>
            </div>
            <div data-options="region:'south',border:false" style="text-align:center;padding:5px 0 0;">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:closeWin_app()" style="width:80px">关闭</a>
            </div>
            <input type="hidden" name="tjzId" id="tjzId" />
        </form>
    </div>
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
		striped: true,
		pageNumber:1,
		pageSize:15,
		pageList:[ 5, 10, 15 ,20,25,30],
		columns:[[  
				 {field:'mastername',title:'户主姓名',width:'5%'},
				 {field:'paperid',title:'身份证号码',width:'12%'},
				 {field:'familyno',title:'家庭编号',width:'10%'},
				 {field:'operstate',title:'救助状态',width:'5%'},
				 {field:'approvemoney',title:'救助金额',
					 formatter:function(value,rec,index){
						 return '<span style="color:red;">'+value+'</span>';
					 }
				 },
				 {field:'approveresult1txt',title:'社区审批意见'},
				 {field:'aprrovedate1',title:'社区审批时间'},
				 {field:'approveresult2txt',title:'街道审批意见'},
				 {field:'aprrovedate2',title:'街道审批时间'},
				 {field:'approveresult3txt',title:'区县审批意见'},
				 {field:'aprrovedate3',title:'区县审批时间'},
				 {field:'approveendtxt',title:'审批结果',
					 formatter:function(value,rec,index){
						 return '<span style="color:red;">'+value+'</span>';
					 }
				 },
				 {field:'opt',title:'操作',align:'center', width:'5%',
	                   formatter:function(value,rec,index){
	                       var d = '<a href="javascript:void(0)" onclick="viewinfo(\''+ rec.tjzId +'\')">查看</a> ';
	                       var orgno="220201";
	                       if(orgno.length==6){
	                    	   d = d+'<a href="javascript:void(0)" onclick="cancel(\''+ rec.tjzId +'\')">作废</a> ';
	                       }
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
    			'ds': $('#ds').combobox('getValue'),
    			'approveend': $('#approveend').combobox('getValue'),
    			'orgno': $('#orgno').combobox('getValue'),
    		},
    		pageNumber:1,
    		pageSize:15,
    		pageList:[ 5, 10, 15 ,20,25,30]
    	});
    };
	</script>
</body>
</html>