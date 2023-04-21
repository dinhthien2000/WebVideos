
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1>${error }</h1>
<h1>${fail }</h1>
<div class="col-8 offset-2 mt-3 mb-3">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">
				<b>Registration</b>
			</div>
			<div class="card-body">
				<jsp:include page="/common/alert.jsp"/>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" name="username" id="username"
								aria-describedby="username" placeholder="Username" 
								value="${user.username }"> <small id="username"
								class="form-text text-muted">Username is required!</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname"
								aria-describedby="fullname" placeholder="Fullname" 
								value="${user.fullname }"> <small id="fullname"
								class="form-text text-muted">Fullname is required!</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								aria-describedby="password" placeholder="Password" 
								value="${user }"> <small id="password"
								class="form-text text-muted">Password is required!</small>
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								class="form-control" name="email" id="email"
								aria-describedby="email" placeholder="Email"
								value="${user.email }"> <small id="email"
								class="form-text text-muted">Email is required!</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-right">
				<button class="btn btn-success">Sign up</button>
			</div>
		</div>
	</form>
</div>