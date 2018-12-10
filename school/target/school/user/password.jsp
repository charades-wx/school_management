<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    
    <script type="text/javascript">
        var a;
        var b;
        var c;
        $(function () {
            $("#yp").blur(function () {
                if ($("#yp").val()!=${user.userPs}){
                    $("#yp").next().html("密码不正确");
                    $("#yp").next().attr("style","color:red");
                    a = false;
                }else {
                    $("#yp").next().html("");
                    a = true;
                }
            });
            $("#np").blur(function () {
                if ($("#np").val()==""){
                    $("#np").next().html("密码不可为空");
                    $("#np").next().attr("style","color:red");
                    b = false;
                }else {
                    $("#np").next().html("");
                    b = true;
                }
            });
            $("#rp").blur(function () {
                if ($("#rp").val()!=$("#np").val()){
                    $("#rp").next().html("密码请一致");
                    $("#rp").next().attr("style","color:red");
                    c = false;
                }else {
                    $("#rp").next().html("");
                    c = true;
                }
            });
            $("#button2").click(function () {
                if(a&&b&&c){
                    document.forms[0].submit();
                }
            })
        })
    </script>
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：个人中心-》密码修改</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/user/updatepassword" method="post">
    <table width="100%" cellpadding="0" cellspacing="0">
        <input type="hidden" name="userId" value="${user.userId}" >
        <tr>
            <td align="right" width="80">原密码：</td>
            <td><input type="password" id="yp" name="prepass" /><span>&nbsp;&nbsp;</span></td>
        </tr>
        <tr>
            <td align="right"  width="90">新密码：</td>
            <td><input type="password" id="np" name="userPs" /><span>&nbsp;&nbsp;</span></td>
        </tr>
        <tr>
            <td align="right" width="90">密码确认：</td>
            <td><input type="password" id="rp" name="repass" /><span>&nbsp;&nbsp;</span></td>
        </tr>
       
        <tr align="center">
            <td colspan="5" height="40">
                <div align="center">
                    
                    <input type="button" id="button2" value="确认" />
                </div>
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
