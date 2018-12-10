<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
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
<script type="text/javascript">
    $(function () {
        $("[name=deptid]").change(function () {
            var did = $(this).val();
           $.ajax({
               url:"/Educational/student/getmajorbydid",
               data:"did="+did,
               type:"post",
               datatype:"json",
               success:function (rs) {
                   $("[name=majorid]")[0].length=0;
                   $("[name=classid]")[0].length=0;
                   $("[name=majorid]")[0].add(new Option("请选择", -1));
                   $("[name=classid]")[0].add(new Option("请选择", -1));
                   for(var i=0;i<rs.length;i++){
                       $("[name=majorid]")[0].add(new Option(rs[i].majorname, rs[i].majorid));
                   }
               }
           })
        });
        $("[name=majorid]").change(function () {
            var did = $("[name=deptid]").val();
            var mid = $(this).val();
            if(mid==-1){
                alert("请先选择学院");
            }else{
                $.ajax({
                    url:"/Educational/student/getcla",
                    data:"did="+did+"&mid="+mid,
                    type:"post",
                    dataType:"json",
                    success:function (rs) {
                        $("[name=classid]")[0].length=0;
                        for(var i=0;i<rs.length;i++){
                            $("[name=classid]")[0].add(new Option(rs[i].classname,rs[i].classid));
                        }
                    }
                });
            }
        })
    })
</script>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》学生管理-》修改</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/Educational/student/updatestudent" method="post">
        <input type="hidden" name="studentid" value="${stu.studentid}"/>
	<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="10%">学号：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="studentno" value="${stu.studentno}" />
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuname" value="${stu.stuname}" />
					</td>
                </tr>
                 <tr>
                    <td>学院<span style="color:red">*</span>：</td>
                    <td>
                        <select name="deptid">
                            <c:forEach items="${des}" var="d">
                                <option value="${d.departid}" <c:if test="${stu.deptid==d.departid}">selected</c:if>>${d.departname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>专业<span style="color:red">*</span>：</td>
                    <td>
                        <select name="majorid">
                            <c:forEach items="${mas}" var="m">
                                <option value="${m.majorid}" <c:if test="${stu.majorid==m.majorid}">selected</c:if>>${m.majorname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>班级<span style="color:red">*</span>：</td>
                    <td>
                        <select name="classid">
                            <c:forEach items="${clas}" var="c">
                                <option value="${c.classid}" <c:if test="${stu.classid==c.classid}">selected</c:if>>${c.classname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="stusex" <c:if test="${stu.stusex==0}">checked</c:if> value="0" />男
                        <input type="radio" name="stusex" <c:if test="${stu.stusex==1}">checked</c:if> value="1"/>女
                    </td>
                </tr>


				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="email" value="${stu.email}" />
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="${stu.phone}" />
                    </td>                
                </tr>

				<tr>
                    <td>户口所在地：</td>
                    <td>
                        <input type="text" name="registered" value="${stu.registered}"  />
                    </td>                
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="address" value="${stu.address}" />
                    </td>                
                </tr>
				<tr>
                    <td>政治面貌：</td>
                    <td>
                        <input type="text" name="politics" value="${stu.politics}" />
                    </td>                
                </tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="cardid" value="${stu.cardid}" />
                    </td>                
                </tr>
				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="stucontent">${stu.stucontent}</textarea>
                    </td>
                </tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="修改" />
                        <input type="button" value="返回" onclick="history.back();">
					</td>
				</tr>
			</table>
	</form>
</div>

            </div>
        </div>
    </div>
</body>
</html>
