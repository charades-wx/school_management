<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fy" uri="http://java.sun.com/jsp/femye/fy" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
<link href="../../css/mine.css" type="text/css" rel="stylesheet">
<script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="../../Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="../../Script/Common.js" type="text/javascript"></script>
<script src="../../Script/Data.js" type="text/javascript"></script>

<script>
	function del(){
		confirm("确认操作？");
	}

</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span>
                <span style="float: left;">当前位置是：教务中心-》学生管理</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                    <a style="text-decoration: none;" href="/Educational/student/addstu">【新增学生】</a>&emsp;&emsp;&emsp;&emsp;
                </span>
            </span>
	</div>

	<div class="cztable">
		<div>
				  <form action="/Educational/student/selectstudent" method="post">
                    学生名称: 
					<input type="text" name="stuname" value="${stu.stuname}" />
                     学生学号: 
					<input type="text" name="studentno" value="${stu.studentno}" />
					性别: 
					<select name="stusex">
							<option value="-1">--请选择--</option>
							<option <c:if test="${stusex=='0'}">selected</c:if> value="0">男</option>
							<option <c:if test="${stusex=='1'}">selected</c:if> value="1">女</option>
						</select>
					<input type="submit" value="查询" />

                </form>
            <br>



		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr style="height: 25px" align="center">
                        <th >学号</th>
						<th width="">姓名</th>
						<th width="">性别</th>
                        <th width="15%">联系电话</th>						
                        <th width="15%">专业</th>
						<th width="15%">登记时间</th>
						<th>操作</th>
                    </tr>

				<c:forEach items="${p.list}" var="s">
                    <tr id="product1">
                        <td align="center">${s.studentno}</td>
						<td align="center">${s.stuname}</td>
						<td align="center">${s.stusex==1?'女':'男'}</td>
                        <td align="center">${s.phone}</td>
						<td align="center">${s.major.majorname}</td>
                        <td align="center"><fmt:formatDate value="${s.regdate}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
						<td align="center">
							<a href="/Educational/student/changepage?studentid=${s.studentid}">修改</a>
							<a href="/Educational/student/tuixue?studentid=${s.studentid}" onclick="del();return true" class="tablelink"> 退学</a>
							<a href="/Educational/student/infopage?studentid=${s.studentid}">详细</a>
						</td> 				                    
                    </tr>
				</c:forEach>


                    <tr>
                        <td colspan="20" style="text-align: center;">
							<fy:fy url="/Educational/student/selectstudent?stuname=${stu.stuname}&studentno=${stu.studentno}" pageInfo="${p}"></fy:fy>
                        </td>
                    </tr>
                </tbody>
            </table>
	</div>

	</div>
	</div>

	</div>
</body>
</html>
