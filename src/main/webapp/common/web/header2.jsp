<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
	<%@ page import="com.baitaplon.securiry.SecurityUtils" %>

<header class="header">
            <div class="grid">
                <nav class="header__navbar">
                    <ul class="header__navbar-list-left ">
                        <li class="header__navbar-item">
                            <a href="/baitaplon/trang-chu" class="header__navbar-item-link">Home</a>
                        </li>
                        <li class="header__navbar-item">
                            <a href="" class="header__navbar-item-link">Sản Phẩm Mới </a>
            
                        </li>
                        <li class="header__navbar-item header__navbar-item-has-notifyy">
                            <a href="" class="header__navbar-item-link">
                                Bộ Sưu Tập
                             </a>   
                             
                             <div class="header__notifyy">
                                <ul class="header__notifyy-list">
                                	<c:forEach var="category" items="${lstCategory}">
							<li class="header__notify-item"><a href="/baitaplon/trang-chu/san-pham?category=${category.code}"
								class="header__notify-item-link"> ${category.name} </a></li>
							</c:forEach>
                                    

                                    
                                </ul>
                            </div>
                           
            
                        </li>   
                        <li class="header__navbar-item">
                            <a href="" class="header__navbar-item-link">
                                Sale 
                            </a>
                        </li>

                        <li class="header__navbar-item ">
                            <a href="" class="header__navbar-item-link">
                                Về Chúng Tôi 
                            </a>
                        </li>
                    </ul>

                    <ul class="header__navbar-list-right">
                        <li class="header__navbar-item">
                            <div class="header__search">                 
                                <input type="text" class="header__search-input" id="search" id="search" placeholder="Tìm kiếm sản  phẩm ">  
                   
                                
                            </div>
                                         <a href="<c:url value='/trang-chu/gio-hang'/>" class="header__navbar-item-link"> <i class="fa fa-search" aria-hidden="true"></i>
				</a>
                        </li>
                        <a href="<c:url value='/trang-chu/gio-hang'/>" onclick="TestFunction()" class="header__navbar-item-link"> <i
					class="fas header__navbar-icon-cart fa-shopping-cart"></i>
				</a>
                    
                     
                      

                       		<security:authorize access = "isAnonymous()">
					<li class="header__navbar-item"><a
					href="<c:url value='/dang-nhap'/>"
					class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
						Đăng Nhập </a></li>
						<li class="header__navbar-item"><a
					href="<c:url value='/dang-ki'/>"
					class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
						Đăng ký </a></li>
				</security:authorize>
				
			<%-- 	<security:authorize access = "isAuthenticated()">
				
						<li class="header__navbar-item">
                         
                            <label  class="label-takhoan  header__navbar-item--strong ">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></label>
                        </li>
						
				<li class="header__navbar-item"><a
					href="<c:url value="/j_spring_security_logout"/>"
					class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
						Thoát</a></li>
					
				</security:authorize> --%>
				<security:authorize access = "isAuthenticated()">
					<li class="header__navbar-item"><a
					href="<c:url value='/dang-nhap'/>"
					class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
						Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
				<li class="header__navbar-item"><a
					href="<c:url value="/j_spring_security_logout"/>"
					class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
						Thoát</a></li>
					
				</security:authorize>

                      
                    </ul>

                    <!-- <input type="checkbox"  hidden name="" class="nav__input" id="check-input">
                    <label for="check-input" class="over__play"> </label>

                    <nav class="list__form">
                    <img src="//bizweb.dktcdn.net/100/358/122/themes/788488/assets/logo.png?1623808175701" alt="A M A N D" class="amand__img">
                    <div class="form__information">
                        <p class="heading-form">Thông Tin Nhận Hàng </p>

                        <div class="text-box">
                            <label for="" class="label__name">Email</label><br/>
                            <input type="text" placeholder="Địa Chỉ Email" name="" id="" >
                        </div>  
                        <div class="text-box">
                            <label for="" class="label__name">Họ Tên </label><br/>
                            <input type="text" placeholder="Họ Tên Của Bạn" name="" id="" >
                        </div>
                        <div class="text-box">
                            <label for="" class="label__name">Số Điện Thoại</label><br/>
                            <input type="text" placeholder="Số Phone" name="" id="" >
                        </div>
                        <div class="text-box">
                            <label for="" class="label__name">Địa Chỉ</label><br/>
                            <input type="text" placeholder="Địa chỉ  Cư Trú" name="" id="" >
                        </div>
                      
                        <input type="checkbox"  hidden class="input__thinh" name="" id="check-nav">
                        <div class="abc">
                            <label for="check-nav" class="label__dmk"> Đổi Mật Khẩu</label>
                        </div>

                        <labele for="check-nav" class="form-pass">
                            <input type="text" name="" placeholder="Mật Khẩu Mới" id="" ><br/>
                            <input type="text" name="" placeholder="Nhập lại Mật khẩu Mói  " id="" >
                        </label>
                        </div>
                    <div class="button">
                        <button type="button" class="btnn" value="Cập Nhật"> Cập Nhật </button>
                    </div> -->
                </nav>
            </div>
        </header>