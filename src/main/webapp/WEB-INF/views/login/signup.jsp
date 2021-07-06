<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng kí</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
  <style>
		label.error{
			color: red;
		}
	    </style>
</head>
<body>
 <header class="main-header">
    <h1  > A M A N D</h1>
</header>
<form enctype="multipart/form-data"  id="formSignup">
      <div class="form__submit">
        <h1>Create Your Account</h1>
      <div class="container">
        <div class="text-box" >
          <label for="" class="label-name">Full Name</label><br>
          <i class="far fa-user"></i>
          <input type="text"  name="fullName" placeholder="" id="fullName" required="required">
        </div>

        <div class="text-box">
          <label for="" class="label-name">Email Adress</label><br>
          <i class="fas fa-location-arrow"></i>
          <input type="text" name="userName" placeholder="userName" id="userName" required="required">
        </div>

        <div class="text-box">
          <label for="" class="label-name">Phone Number</label><br>
          <i class="fas fa-phone"></i>
          <input type="text" name="phoneNumber" placeholder="phoneNumber" id="phoneNumber" required="required">
        </div>
        
        <div class="text-box">
          <label for="" class="label-name">Địa chỉ</label><br>
          <i class="fas fa-phone"></i>
          <input type="text" name="address" placeholder="phoneNumber" id="address" required="required">
        </div>

        <div class="text-box">
          <label for="" class="label-name">Password</label><br>
          <i class="fas fa-lock"></i>
          <input type="password" name="password" placeholder="" id="password" required="required">
        </div>

        <div class="text-box">
          <label for="" class="label-name">Confirm PassWord</label><br>
          <i class="fas fa-lock"></i>
          <input type="password" name="confirmPassword" placeholder="" id="confirmPassword" required="required">
        </div>
        <input type="hidden" value="3" name="roleId" id="roleId"> 

        <input type="submit" value="Đăng kí" class="btn"onclick="theFunction()"> 
										
      </div>
    </div>
    </form>
    
    <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
    
</body>
</html>