<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4 mb-2">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">User list</a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post">
				<div class="card">

					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username">Username</label> <input type="text"
										class="form-control" name="username" id="username"
										aria-describedby="username" placeholder="" required> <small
										id="username" class="form-text text-muted">Username is
										required!</small>
								</div>
								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text"
										class="form-control" name="fullname" id="fullname"
										aria-describedby="fullname" placeholder="" required> <small
										id="fullname" class="form-text text-muted">Fullname is
										required!</small>
								</div>

							</div>
							<div class="col">
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" name="password" id="password"
										aria-describedby="password" placeholder="" required> <small
										id="password" class="form-text text-muted">Password is
										required!</small>
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" name="email" id="email"
										aria-describedby="email" placeholder="" required> <small
										id="email" class="form-text text-muted">Email is
										required!</small>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-right">
						<button class="btn btn-success">Create</button>
						<button class="btn btn-warning">Update</button>
						<button class="btn btn-danger">Delete</button>
						<button class="btn btn-primary" type="reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-stripe">
				<tr>
					<th>Username</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Role</th>
					<th>&nbsp;</th>
				</tr>
				<tr>
					<td>DThien</td>
					<td>Dinh thien</td>
					<td>thien@gmail.com</td>
					<td>Admin</td>
					<td><a class="ml-3" href=""><i class="fa fa-edit"
							aria-hidden="true"></i>Edit</a> <a class="ml-3" href=""><i
							class="fa fa-trash" aria-hidden="true"></i>Delete</a></td>
				</tr>
			</table>
		</div>

	</div>
</div>