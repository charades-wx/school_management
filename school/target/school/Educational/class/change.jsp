<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    $(function(){
        $("[name=deptid]").change(function(){
            var did=$(this).val();
            if(did==-1){

                $("[name=majorid]")[0].length=0;
                $("[name=majorid]")[0].add(new Option("请选择",-1));
            }else{
                $.ajax({
                    url:"/Educational/class/getmajorbydid",
                    data:"did="+did,
                    type:"post",
                    dataType:"json",
                    success:function(rs){
                        //将专业添加到元素中
                        $("[name=majorid]")[0].length=0;
                        $("[name=classteacher]")[0].length=0;
                        $("[name=classteacher]")[0].add(new Option("请选择专业"));
                        $("[name=majorid]")[0].add(new Option("请选择",-1));
                        for(var i=0;i<rs.length;i++){
                            //alert(rs[i].majorname);
                            $("[name=majorid]")[0].add(new Option(rs[i].majorname,rs[i].majorid));
                        }
                    }

                });
            }

        });




        $("[name=majorid]").change(function(){
            var did=$("[name=deptid]").val();
            var mid=$(this).val();
            if(mid==-1){
                $("[name=classteacher]")[0].length=0;
                $("[name=classteacher]")[0].add(new Option("请选择专业"));
            }else{
                $.ajax({
                    url:"/Educational/class/getteacher",
                    data:"did="+did+"&mid="+mid,
                    type:"post",
                    dataType:"json",
                    success:function(rs){
                        $("[name=classteacher]")[0].length=0;
                        for(var i=0;i<rs.length;i++){
                            $("[name=classteacher]")[0].add(new Option(rs[i].userName,rs[i].userName));
                        }
                    }
                });
            }
        });








    })
</script>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》班级管理-》修改</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/Educational/class/updatecla" method="post">
        <input type="hidden" name="classid" value="${c.classid}"/>
	<table border="1" width="100%" class="table_a">
                
                <tr>
                    <td  width="120px;">班级编号：<span style="color:red">*</span>：</td>
                    <td>
                       <input type="text" name="classnum" value="${c.classnum}" />
                    </td>
                </tr>
               
               <tr>
                    <td>学院<span style="color:red">*</span>：</td>
                    <td>
                        <select name="deptid">
                                <option value="1" <c:if test="${c.deptid==1}">selected</c:if>>矿冶工程学院</option>
                                <option value="2" <c:if test="${c.deptid==2}">selected</c:if>>政治学院</option>
                                <option value="3" <c:if test="${c.deptid==3}">selected</c:if>>计算机学院</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>专业<span style="color:red">*</span>：</td>
                    <td>
                        <select name="majorid">
                            <c:if test="${c.deptid==1}">
                                <option value="1" <c:if test="${c.deptid==1}">selected</c:if>>矿产分析</option>
                                <option value="2" <c:if test="${c.deptid==2}">selected</c:if>>矿产挖掘</option>
                                <option value="3" <c:if test="${c.deptid==3}">selected</c:if>>矿产冶炼</option>
                            </c:if>
                            <c:if test="${c.deptid==2}">
                                <option value="4" <c:if test="${c.deptid==4}">selected</c:if>>毛泽东思想</option>
                                <option value="5" <c:if test="${c.deptid==5}">selected</c:if>>邓小平理论</option>
                                <option value="6" <c:if test="${c.deptid==6}">selected</c:if>>习近平治国</option>
                            </c:if>
                            <c:if test="${c.deptid==3}">
                                <option value="7" <c:if test="${c.deptid==7}">selected</c:if>>java</option>
                                <option value="8" <c:if test="${c.deptid==8}">selected</c:if>>h5</option>
                                <option value="9" <c:if test="${c.deptid==9}">selected</c:if>>c</option>
                            </c:if>
                        </select>
                    </td>
                </tr>
               
				<tr>
                    <td>班主任：<span style="color:red">*</span>：</td>
                    <td>
						<select name="classteacher">
						   <option value="${c.classteacher}">${c.classteacher}</option>
						</select>
					</td>
                </tr>
                <tr>
                    <td>班级名称：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="classname" value="${c.classname}"/></td>
                </tr>
				<tr>
                    <td>人数：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="peoplecount" value="${c.peoplecount}"/></td>
                </tr>
				 <tr>
                    <td>开班时间：<span style="color:red">*</span>：</td>
                    <td>

						<input type="text" name="classbegin" value="<fmt:formatDate value="${c.classbegin}" pattern="yyyy/MM/dd"></fmt:formatDate>" /></td>
                </tr>
                <tr>
                    <td>毕业时间：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="classend" value="<fmt:formatDate value="${c.classend}" pattern="yyyy/MM/dd"></fmt:formatDate>"/></td>
                </tr>
				<tr>
                    <td>QQ：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="classqq" value="${c.classqq}" /></td>
                </tr>
					<tr>
                    <td>宣传语：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" name="tagline" value="${c.tagline}" /></td>
                </tr>
			
			


                <tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="classcontent">${c.classcontent}</textarea>
                    </td>
                </tr>
				

				
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="保存">
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
