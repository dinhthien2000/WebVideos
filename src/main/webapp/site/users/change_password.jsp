<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-2 col-8 mt-4">
	<form action="ChangePassword" method="post">
		<jsp:include page="/common/alert.jsp"></jsp:include>
		<div class="card">
			<div class="card-header">Change Password</div>
			<div class="card-body">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text" value="${username }"
								class="form-control disabled" name="username" id="username"
								aria-describedby="username" placeholder="" required> <small
								id="username" class="form-text text-muted">Username not edit!</small>
						</div>
						<div class="form-group">
							<label for="password">New password</label> <input type="password"
								class="form-control" name="newpassword" id="password"
								aria-describedby="password" placeholder="" required> <small
								id="password" class="form-text text-muted">Password is
								required!</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="currentpassword">Current password</label> <input
								type="password" class="form-control" name="currentpassword"
								id="currentpassword" aria-describedby="currentpassord"
								placeholder="" required> <small id="currentpassword"
								class="form-text text-muted">Current password is
								required!</small>
						</div>
						<div class="form-group">
							<label for="confirmpassword">Confirm password</label> <input
								type="password" class="form-control" name="cofirmpassowrd"
								id="confirmpassword" aria-describedby="confirmpassword"
								placeholder="" required> <small id="confirmpassword"
								class="form-text text-muted">Comfirm password is
								required!</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-right">
				<button class="btn btn-success">Change password</button>
			</div>
		</div>
	</form>
</div>