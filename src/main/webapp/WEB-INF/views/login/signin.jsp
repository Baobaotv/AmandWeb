<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">



</head>


<body>

    <div class="login__box">
            <h2>LOGIN FORM</h2>
            <form action="<c:url value='/j_spring_security_login'/>" id="login" method="post">
            <div class="textbox">
                <i class="far fa-user"></i>
                <input type="text" placeholder="UserName" name="username" id="username">
            </div>

            <div class="textbox">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Password" name="password" id="password">
            </div>
            <div class="button">
          
					<button type="submit" class="btn">Login</button>
            
            <span class="btn-re">
                <a href="" class="entypo-user-add register">Sign up</a>
              </span>
            </div>
            </form>
            </div>
        </div>

</body>
</html>