<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myfy" uri="http://java.sun.com/jsp/femye/fy" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>

</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》班级管理</span> <span
			style="float: right; margin-right: 8px; font-weight: lighter">
             <span onclick="todaochu()" style="color:#35cd2f;cursor:pointer">【导出excel】</span>&nbsp;&nbsp;
             <a style="text-decoration: blink" href="/Educational/class/addclass">【新增班级】&emsp;&emsp;&emsp;&emsp;</a>
		</span>
		</span>
	</div>
    <script type="text/javascript">
        function todaochu(){
            var singles = $("[name=single]");
            var j = -1;
            for (var i = 0;i<singles.length;i++){
                if(singles[i].checked==true){
                    j=2;
                    document.forms[1].submit();
                    break;
                }
            }
            if(j==-1){
                alert("请选择导出的班级")
            }
        }
    </script>
	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="/Educational/class/getclasslist" method="post">
					<li>
						<label>班级名称:</label>
						<input name="classname" type="text" class="scinput1" value="${cname}"/>&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form><br>
    <form action="/Educational/class/daochu" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody><tr style="font-weight: bold;">
                		<th  width="8%">
						<input name="all" type="checkbox"/>
						</th>
                        <th >院系</th>
						<th width="">班级编号</th>
						<th width="">班级名称</th>
                        <th width="15%">班主任老师</th>						
                        <th width="15%">人数</th>
						<th width="15%">班级状态</th>
						<th width="20%">操作</th>  
                    </tr>

                <c:forEach items="${p.list}" var="cla">
                    <tr id="product1">
                    	<td  width="8%" align="center">
						<input name="single" value="${cla.classid}" type="checkbox"/>
						</td>
                        <td align="center">${cla.department.departname}</td>
						<td align="center">${cla.classnum}</td>
                        <td align="center">${cla.classname}</td>
						<td align="center">${cla.classteacher}</td>
                        <td align="center">${cla.peoplecount}</td>
						<td align="center">${cla.classstate}</td>
						<td align="center">
                            <a href="/Educational/class/information?classid=${cla.classid}">详情</a>
                            <c:if test="${cla.classstate=='未审核'||cla.classstate=='审核未通过'}">
                                <a href="/Educational/class/updateclass?classid=${cla.classid}">修改</a>
                                <a href="/Educational/class/updateclassstate?classid=${cla.classid}&takenum=${cla.takenum}">提交审核</a>
                                <a href="/Educational/class/deleteclass?classid=${cla.classid}">删除</a>
                            </c:if>
                            <c:if test="${cla.classstate=='审核通过'}">
                                <a href="#">发书</a>
                            </c:if>
						</td>
                    </tr>
                </c:forEach>

                    <tr>
                        <td colspan="20" style="text-align: center;">						
						<a style="text-decoration: none;" href="#">
                            <myfy:fy url="/Educational/class/getclasslist?classname=${cname}&classnum=${cnum}" pageInfo="${p}"></myfy:fy>
                            每页显示
                            <select name="num">
                                <option value="5" <c:if test="${size==5}">selected</c:if>>5</option>
                                <option value="10" <c:if test="${size==10}">selected</c:if>>10</option>
                                <option value="15" <c:if test="${size==15}">selected</c:if>>15</option>
                            </select>  <%--${p.pageNum}/${p.pages}--%>
                        </a></td>
                    </tr>
                </tbody>
</table>
    </form>
	</div>

	</div>
	</div>

	</div>

	<script type="text/javascript">
        function del(){
            confirm("确认删除？");
        }

        $(function () {
            $("[name=num]").change(function () {
                var size = $(this).val();
                location.href="/Educational/class/getclasslist?size="+size;
            })
        })
        $(function () {
            $("[name=all]").click(function () {

                var singles = $("[name=single]");
                for(var i=0;i<singles.length;i++){
                    singles[i].checked=$(this)[0].checked;
                }
            })
        })


	</script>
</body>
</html>
