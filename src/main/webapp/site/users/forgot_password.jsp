<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6">
	<form action="ForgotPassword" method="post">
		
		<div class="card mt-5">
		
			<div class="card-header">
				<b>Forgot password</b>
			</div>
			
			<div class="card-body">
			<jsp:include page="/common/alert.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">				
					<label for="username">Username</label> <input type="text"
						class="form-control" name="username" id="username"
						aria-describedby="username" placeholder="Username" required>
					<small id="username" class="form-text text-muted">Username
						is required!</small>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email"
						class="form-control" name="email" id="email"
						aria-describedby="email" placeholder="Email" required> <small
						id="email" class="form-text text-muted">Email is required!</small>
				</div>
					</div>
				</div>
				
			</div>
			<div class="card-footer text-right">
				<button class="btn btn-success">Retrieve</button>
			</div>
		</div>
	</form>
</div>