<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>电桩信息</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/static/css/electric/electricList.css"/>
	</head>
	<body>
		<div id="container1">
			<div class="box">
				<!--<div id="" class="AssetStatistics">
				</div>-->
				<div class="formList">
					<form id="electricForm">
					<input type="text" name="elpiElectricpilecode" class="160width" placeholder="电桩编号/电桩名称">
					<input type="text" name="" class="160width" placeholder="商户名称">
					<select name="elpiPowersize" id="elpiPowersize">
						<option disabled selected>功率</option>
					</select>
					<select name="elpiState" id="elpiState">
						<option disabled selected>电桩状态</option>
					</select>
					
					<span class="check" onclick="electricSearch()">查询</span>
					</form>
				</div>
				<div class="btnGroup">
						<span style="margin-left: 0;" id="insertBtn">导入</span>
						<a target="selectedTodo" rel="ids" href="/admin/electric/electricRemove.do"  posttype="string" title="确定删除吗？"><span>删除</span></a>
						<a target="selectedTodo" rel="ids" href="/admin/electric/electricOnLine.do"  posttype="string" title="确定分享吗？"><span>分享</span></a>
						<a target="selectedTodo" rel="ids" href="/admin/electric/electricOffLine.do"  posttype="string" title="确定专属吗？"><span>专属</span></a>
						<span class="superLink fileExport" rel="electricForm" href="/admin/electric/electricExport.do">导出EXCEL</span>
					</div>
			</div>
			<div class="box2 col-md-10 col-sm-8">
				<div class="padding30">
						<table class="myTable">
							<thead>
								<tr class="active">
									<th class="smallWidth"><input type="checkbox" name="" class="selAll" value=""/></th>
									<th class="smallWidth">序号</th>
									<th>桩体编码</th>
									<th>电桩名称</th>
									<th>充电方式</th>
									<th>功率</th>
									<th>电桩状态</th>
									<th>商家名称</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="electricTbody">
							</tbody>
						</table>
						<div id="" class="" style="height: 40px; width: auto;">
							&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
				</div>
			</div>
			<div id="electricPage" class="pagination col-md-10 col-sm-10">
			</div>

		</div>
		<div id="fileInputContainer" class="fileInputContainer" style="display: none;">
			<form id="electricImportForm" method="post" action="${ctx}/admin/electric/electricImport.do" 
				enctype="multipart/form-data" callback="refreshCurrent()" >
				<input type="file" name="file" id="fileInput" hidden="hidden" class="fileInput"/>
				<span id="fileText" class="fileInputValue">请选择文件</span>
				<a id="downloadXlsx" href="${ctx}/resource/electric/demo.xlsx"><span class="downFile">下载导入模板</span></a>
			</form>
		</div>
	</body>
<script src="${ctx}/static/js/electric/electricList.js" type="text/javascript" charset="utf-8"></script>
</html>