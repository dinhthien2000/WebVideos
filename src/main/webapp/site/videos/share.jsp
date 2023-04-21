<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- offset : bắt đầu cột 3 -->
<div class="offset-3 col-6">
	<form action="" method="post">
		<div class="card ">
			<div class="card-header">Send Video to your friends</div>
			<div class="card-body">
				<div class="form-group">
					<label for="eamil">Your friends email</label> <input type="text"
						name="email" id="email" class="form-control" placeholder=""
						aria-describedby="email"> <small id="email"
						class="text-muted">Email is required!!</small>
				</div>
			</div>
			<div class="card-footer">
				<button class="btn btn-success">Send</button>
			</div>
		</div>
	</form>
</div>