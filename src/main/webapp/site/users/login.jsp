<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-4 col-4 mt-5">
	<form action="Login" method="post">
		<div class="card">
			<div class="card-header">
				<b>Login to system</b>
			</div>
			<div class="card-body">
				<jsp:include page="/common/alert.jsp"></jsp:include>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="username" id="username"
						aria-describedby="username" placeholder=""> <small
						id="username" class="form-text text-muted">Username is
						required!</small>
				</div>

				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password"
						aria-describedby="password" placeholder=""> <small
						id="password" class="form-text text-muted">Password is
						required!</small>
				</div>

				<div class="form-check form-check-inline">
					<label><input type="checkbox" class="form-check-input" name="remember">Remember
						me</label>
				</div>

			</div>
			<div class="card-footer text-right">
				<button class="btn btn-success">Login</button>
			</div>
		</div>
	</form>
</div>