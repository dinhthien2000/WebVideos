
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-8 offset-2 mt-5">
	<form action="Profile" method="post">
		<div class="card">
			<div class="card-header">
				<b>Edit Profile</b>
			</div>
			<div class="card-body">
				<jsp:include page="/common/alert.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control disabled" name="username" id="username"
								aria-describedby="username" placeholder="" required
								value="${user.username }" aria-disabled="true"> <small
								id="username" class="form-text text-muted">Username is
								required!</small>
						</div>
						<div class="form-group">
							<label for="fullname">Full name</label> <input type="text"
								class="form-control" name="fullname" id="fullname"
								aria-describedby="fullname" placeholder="" required
								value="${user.fullname }"> <small id="fullname"
								class="form-text text-muted">Full name is required!</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control disabled" name="password" id="password"
								aria-describedby="password" placeholder="" required
								aria-disabled="true" value="${user.password }"> <small
								id="password" class="form-text text-muted">...</small>
						</div>
						<div class="form-group">
							<label for="email">Email address</label> <input type="email"
								class="form-control" name="email" id="email"
								aria-describedby="email" placeholder="" required
								value="${user.email }"> <small id="email"
								class="form-text text-muted">Email is required!</small>
						</div>
					</div>

				</div>
			</div>
			
			<ul><li style="color:red;">Note : username and password not edit in here</li></ul>

			<div class="card-footer text-right">
				<button class="btn btn-success">Update Profile</button>
			</div>
		</div>
	</form>
</div>