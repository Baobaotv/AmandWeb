<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.baitaplon.securiry.SecurityUtils"%>
<c:forEach var="product" items="${lstProduct}">
</c:forEach>
<header class="header">
	<div class="grid">
		<nav class="header__navbar">
			<ul class="header__navbar-list-left ">
				<li class="header__navbar-item"><a href="/baitaplon/trang-chu"
					class="header__navbar-item-link">Home</a></li>
			<!-- 	<li class="header__navbar-item"><a href=""
					class="header__navbar-item-link">Sản Phẩm Mới </a></li> -->
				<li class="header__navbar-item header__navbar-item-has-notifyy">
					<a href="" class="header__navbar-item-link"> Bộ Sưu Tập </a>

					<div class="header__notifyy">
						<ul class="header__notifyy-list">

							<c:forEach var="category" items="${lstCategory}">
								<li class="header__notify-item"><a
									href="/baitaplon/trang-chu/san-pham?category=${category.code}"
									class="header__notify-item-link"> ${category.name} </a></li>
							</c:forEach>




						</ul>
					</div>


				</li>
<!-- 				<li class="header__navbar-item"><a href=""
					class="header__navbar-item-link"> Sale </a></li>

				<li class="header__navbar-item "><a href=""
					class="header__navbar-item-link"> Về Chúng Tôi </a></li> -->
			</ul>

			<ul class="header__navbar-list-right">
			<form enctype="multipart/form-data" id="formSearch">
				<li class="header__navbar-item">
					<div class="header__search">
						<input name="search" id="search" type="text" class="header__search-input"
							placeholder="Tìm kiếm sản  phẩm ">


					</div>
				</li>

				<a href=""
					class="header__navbar-item-link" onclick="searchFunction()"> <i class="fa fa-search"
					aria-hidden="true"></i>
				</a>
				</form>
				<a href="<c:url value='/trang-chu/gio-hang'/>"
					onclick="TestFunction()" class="header__navbar-item-link"> <i
					class="fas header__navbar-icon-cart fa-shopping-cart"></i>
				</a>




				<security:authorize access="isAnonymous()">
					<li class="header__navbar-item"><a
						href="<c:url value='/dang-nhap'/>"
						class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
							Đăng Nhập </a></li>
					<li class="header__navbar-item"><a
						href="<c:url value='/dang-ki'/>"
						class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
							Đăng ký </a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li class="header__navbar-item"><a href="<c:url value=''/>"
						class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
							Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
					<li class="header__navbar-item"><a
						href="<c:url value="/j_spring_security_logout"/>"
						class="header__navbar-item-link header__navbar-item--separate  header__navbar-item--strong">
							Thoát</a></li>

				</security:authorize>


			</ul>
		</nav>
	</div>
</header>