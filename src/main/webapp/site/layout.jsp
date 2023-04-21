<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
 <!doctype html>
<html lang="en">

<head>
    <title>${page.title }</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../fontawesome-free-6.1.1-web/css/all.css">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
     <base href="/WebVideos/" />
     <style type="text/css">
     	<%@include file="/css/disabled.css" %>
     </style>
</head>

<body>

    <main class="container">
        <header class="row mt-3 pb-2">
            <div class="col-9 ">
                <h1>Online Entertainment</h1>
            </div>
            <div class="col-3 text-right">
                <img src="../images/logo.png" alt="" class="mr-4" width="100px" height="100px">
            </div>
        </header>
        <nav class="row">
            <nav class="col navbar navbar-expand-sm navbar-light bg-light">
                <a class="navbar-brand" href="#">OnEn</a>
                <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                    data-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active">
                            <a class="nav-link" href="HomePage"><i class="fa fa-home" aria-hidden="true"></i>
                                Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> <i class="fa fa-info" aria-hidden="true"></i>
                                About us</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> <i class="fa fa-id-card" aria-hidden="true"></i>
                                Contact us</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> <i class="fa fa-comment" aria-hidden="true"></i>
                                My favorite</a>
                        </li>
                        <li class="nav-item dropdown">
                       	<c:if test="${not isLogin }">
                       	 <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-user" aria-hidden="true"></i>
                                My account</a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                                <a class="dropdown-item" href="Login">Login </a>
                                <a class="dropdown-item" href="ForgotPassword">Forgot password</a>
                                <a class="dropdown-item" href="Registration">Registration</a>
                                
                            </div>
                       	</c:if>
                       	
                       	<c:if test="${isLogin }">
                       	<%String fullname =(String) session.getAttribute("fullname"); %>
                       	 <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-user" aria-hidden="true"></i>
                               Hello <%=fullname %> </a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                                
                                <a class="dropdown-item" href="Logoff">Log out</a>
                                <a class="dropdown-item" href="ChangePassword">Change Password</a>
                                <a class="dropdown-item" href="Profile">Profile</a>
                            </div>
                       	</c:if>
                           
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </nav>
        <section class="row">
			
			<jsp:include page="${page.contentUrl }"></jsp:include>

        </section>
        <footer class="row">
                <div class="col text-center border-top mb-4 mt-3">
                    <strong>Phân hiệu Đại học Thủy Lợi 2022</strong>
                </div>
        </footer>

    </main>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        
     <c:if test="${not empty page.scriptUrl }">
     	<jsp:include page="${page.scriptUrl }"></jsp:include>
     </c:if>
</body>

</html>