﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myfy" uri="http://java.sun.com/jsp/femye/fy" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
<link href="../css/mine.css" type="text/css" rel="stylesheet">
<script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="../Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="../Script/Common.js" type="text/javascript"></script>
<script src="../Script/Data.js" type="text/javascript"></script>

<script>
	function del(){
		confirm("确认删除？");
	}

</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》班级审核</span> <span
			style="float:right;margin-right: 8px;font-weight: bold"> 
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="/Educational/getclasses" method="post">
					<li>
						<label>班级编号</label>
						<input name="classnum" type="text" class="scinput1" value="${cnum}" />&nbsp;&nbsp;
                        <label>班级名称</label>
						<input name="classname" type="text" class="scinput1" value="${cname}" />&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form>
			</ul>
            <br/>
            
		<table class="table_a" border="1" width="100%">
                <tbody><tr style="font-weight: bold;">
                		<td align="center">序号</td>
                        <td >院系</td>
						<td width="">班级编号</td>
						<td width="">班级名称</td>
                        <td width="15%">班主任老师</td>						
                        <td width="15%">人数</td>
						<td width="15%">班级状态</td>
						<td width="15%">操作</td>  
                    </tr>
				<c:forEach items="${p.list}" var="cla" varStatus="vs">
					<tr id="product1">
                        <td align="center">${vs.count}</td>
						<td align="center">${cla.department.departname}</td>
						<td align="center">${cla.classnum}</td>
						<td align="center">${cla.classname}</td>
						<td align="center">${cla.classteacher}</td>
						<td align="center">${cla.peoplecount}</td>
						<td align="center">
                            <c:if test="${cla.takenum==1}">
                                ${cla.classstate}
                            </c:if>
                            <c:if test="${cla.takenum>1}">
                                复审
                            </c:if>
                        </td>
						<td align="center">
							<a href="/Educational/information?classid=${cla.classid}">详情</a>
                            <a href="/Educational/chuli?classid=${cla.classid}&classstate=审核通过">通过</a>
                            <a href="/Educational/chuli?classid=${cla.classid}&classstate=审核未通过">驳回</a>
						</td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="20" style="text-align: center;">
						<a style="text-decoration: none;" href="#">
							<myfy:fy url="/Educational/getclasses?classname=${cname}&classnum=${cnum}" pageInfo="${p}"></myfy:fy>
							共${p.total}条
							每页显示
							<select name="num">
								<option value="5" <c:if test="${size==5}">selected</c:if>>5</option>
								<option value="10" <c:if test="${size==10}">selected</c:if>>10</option>
								<option value="15" <c:if test="${size==15}">selected</c:if>>15</option>
							</select>
						</a></td>
				</tr>
                </tbody>
            </table>
	</div>

	</div>
	</div>

	</div>
</body>
</html>
