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

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：权限管理-》角色管理-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
        </div>
</div>
<div class="cztable">
	<form action="/power/role/addrole" method="post">
<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="120px">角色名：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="rolename" value="管理员" />
					</td>
                </tr>

                <tr  width="120px;">
                    <td>菜单资源<span style="color:red">*</span>：</td>
                    <td>
						<ul>
                            <c:forEach items="${menus}" var="menu1">
                        	<li><input type="checkbox" id="a${menu1.menuid}" onclick="m1(${menu1.menuid})" name="menu" value="${menu1.menuid}" />${menu1.menuname}
                            	<ul>
                                <c:forEach items="${menu1.seconde}" var="menu2">
                                	<li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" onclick="m2(${menu1.menuid})" class="b${menu1.menuid}" name="menu" value="${menu2.menuid}"  />${menu2.menuname}</li>
                                </c:forEach>
                                </ul>
                            </li>
                            </c:forEach>
                        </ul>
					</td>
                </tr>

                <tr>
                    <td>启用状态<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="rolestate" checked value="1" />启用
                        <input type="radio" name="rolestate" value="-1"/>禁用
                    </td>
                </tr>
				
				<tr width="120px">
					<td colspan="2" align="center">
                        <a href="#" onclick="sub()">添加</a>
						<%--<input type="button" onclick="sub()" value="添加" />--%>
					</td> 
				</tr>
			</table>
	</form>
</div>

            </div>
        </div>
        
    </div>
        <script type="text/javascript">
            var k = false;
            function m1(mid) {

                var a = "a"+mid;
                var b = "b"+mid;
                var menu1 = $("#"+a)[0];
                var menu2 = $("[class="+b+"]");
                for(var i=0;i<menu2.length;i++){

                    menu2[i].checked=menu1.checked;
                }
                k = menu1.checked;
            }
            function m2(mid) {
                var a = "a"+mid;
                var b = "b"+mid;
                var menu1 = $("#"+a)[0];
                var menu2 = $("[class="+b+"]");
                for(var i=0;i<menu2.length;i++){
                    if(menu2[i].checked==true){
                        menu1.checked = true;
                        k=true;
                        break;
                    }
                    menu1.checked = false;
                    k = false;
                }
            }

            function sub() {
                if(k){
                    document.forms[0].submit();
                }else{
                    alert("请选择菜单权限")
                }
            }
        </script>
</body>
</html>
