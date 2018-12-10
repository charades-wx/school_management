<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link href="css/login.css" type="text/css" rel="stylesheet" />

</head>

<body id="userlogin_body">
<%
	String name="";
	String pass="";
	Cookie[] cookies = request.getCookies();
	if(cookies!=null){
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("name")){
                name=cookie.getValue();
            }else if(cookie.getName().equals("pass")){
                pass=cookie.getValue();
            }

        }
	}
%>
<
<form action="/login" method="post">
<div id="user_login">
	<dl>
		<dd id="user_top">
			<ul>
				<li class="user_top_l"></li>
				<li class="user_top_c"></li>
				<li class="user_top_r"></li>
			</ul>
		</dd>
		<dd id="user_main">
			<ul>
				<li class="user_main_l"></li>
				<li class="user_main_c">
					<div class="user_main_box">
						<ul>
							<li class="user_main_text">用户名： </li>
							<li class="user_main_input"><input name="userName" maxlength="20" value="<%=name%>" id="TxtUserName" class="txtusernamecssclass"> </li>
						</ul>
						<ul>
							<li class="user_main_text">密 码： </li>
							<li class="user_main_input"><input type="password" name="userPs" value="<%=pass%>" id="TxtPassword" class="txtpasswordcssclass"> </li>
						</ul>
						<ul>
							<li class="user_main_text">验证码： </li>
							<li class="user_main_input">
								<input type="text" name="yanzheng" style="height: 20px;width: 80px">

							</li>
							<li class="user_main_input">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</li>
							<li class="user_main_input">
								<img id="img" src="/getyanzheng" onclick="b()" alt=""/>
							</li>
							<script type="text/javascript">
                                function b(){
                                    document.getElementById("img").src="/getyanzheng?num="+Math.random();
                                }
							</script>
						</ul>
						<ul>
							<li class="user_main_text">记住密码： </li>
							<li class="user_main_input">
								<select name="DropExpiration" id="DropExpiration">
								<option value="None">不保存</option>
								<option selected value="Day">保存一天</option>
								<option value="Month">保存一月</option>
								<option value="Year">保存一年</option>
								</select>
							</li>
						</ul>
					</div>
				</li>
				<li class="user_main_r">
                    <img src="img/user_botton.gif" onclick="a()" class="ibtnentercssclass">
				</a>
				</li>
			</ul>
		</dd>
		<dd id="user_bottom">
			<ul>
				<li class="user_bottom_l"></li>
				<li class="user_bottom_c"></li>
				<li class="user_bottom_r"></li>
			</ul>
		</dd>
	</dl>
</div>
</form>
<script type="text/javascript">
    function a(){
        document.forms[0].submit();
    }
    document.onkeypress = function (event) {
        var ev = ev||event;
        if(ev.keyCode==13){
            document.forms[0].submit();
        }
    }

</script>
</body>
</html>