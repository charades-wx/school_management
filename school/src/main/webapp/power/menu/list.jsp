<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myfy" uri="http://java.sun.com/jsp/femye/fy" %>
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
    <script>
	function del(mid){
        var rs=confirm("确认删除？");
        if(rs==true){
            location.href="/power/menu/deletemenu?menuid="+mid;
        }
	}

</script>
</head>
<body>

   

<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》菜单管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
			<a style="text-decoration: none;" href="javascript:alert('操作成功！');">【导出excel】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="javascript:alert('操作成功！');">【批量删除】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="/power/menu/firstmenu">【新增菜单】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>





 <div class="cztable">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                	<th><input type="checkbox"/></th>
                    <th scope="col">
                        序号
                    </th>
                    
                    <th scope="col">
                        菜单名称
                    </th>
                    <th scope="col">
                        UTL
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col">
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${p.list}" var="m" varStatus="vs">
                <tr align="center">
                    <th><input type="checkbox"/></th>
                    <td>
                        ${vs.count}
                    </td>
                    <td>
                       ${m.menuname}
                    </td>
                    <td>
                       <a href="${m.menupath}">${m.menupath}</a>
                    </td>
                    
                    <td>&nbsp;
                        ${m.menustate==1?'启用':'禁止'}
                    </td>
                    
                    <td>&nbsp;
                        <a href="info.jsp">详情</a>
                        <a href="edit.jsp">修改</a>
						<a href="javascript:void(0)" onclick="del(${m.menuid});return false" class="tablelink"> 删除</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
          <div class='MainStyle'>
                <myfy:fy url="/power/menu/menulist?1=1" pageInfo="${p}"></myfy:fy>
          </div>
        </div>
    </div>

    </div>
</body>
</html>