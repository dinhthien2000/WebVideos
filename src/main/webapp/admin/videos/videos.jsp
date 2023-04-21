<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4 mb-2">
	<jsp:include page="/common/alert.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">Video Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Video list</a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="Admin/VideosMangement" method="post"
				enctype="multipart/form-data">
				<div class="card">

					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img src="/WebVideos/${Video.poster !=null ? video.poster : 'images/desktop.png' }" alt=""
										class="img-fluid">
									<div class="input-group mb-3 mt-3">
										<div class="input-group-prepend">
											<span class="input-group-text">Upload</span>
										</div>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="cover"
												name="cover" /> <label for="cover">Choose file</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtubeid">Youtube ID</label> <input type="text" value="${video.videoid }"
										class="form-control" name="videoid" id="youtubeid"
										aria-describedby="youtibeid" placeholder="" required>
									<small id="youtibeid" class="form-text text-muted">Youtube
										ID is required!</small>
								</div>
								<div class="form-group">
									<label for="videotitle">Video Title</label> <input type="text" value="${video.title }"
										class="form-control" name="title" id="videotitle"
										aria-describedby="videotitle" placeholder="" required>
									<small id="videotitle" class="form-text text-muted">Video
										title is required!</small>
								</div>
								<div class="form-group">
									<label for="viewcount">View count</label> <input type="number" value="${video.views }"
										class="form-control" name="views" id="viewcount"
										aria-describedby="viewcount" placeholder="" required>
									<small id="viewcount" class="form-text text-muted">View
										count is required!</small>
								</div>
								<div class="form-check form-check-inline">

									<!-- <label> <input type="radio" class="form-check-input "
										value="true" name="active" id="status">Active
									</label> <label> <input type="radio"
										class="form-check-input ml-3" value="false" name="active"
										id="status">Inactive
									</label> -->
									<input type="radio" name="active" value="true" ${video.active? 'checked' : '' } />Active 
									&nbsp;
									<input type="radio" name="active" value="false" ${!video.active? 'checked' : '' } />Inactive

								</div>

							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="description">Description</label>
								<textarea name="description" id="description" cols="30" rows="5"  
									class="form-control" required>${video.description }</textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-right">
						<button class="btn btn-success"
							formaction="Admin/VideosMangement/create">Create</button>
						<button class="btn btn-warning"
							formaction="Admin/VideosMangement/update">Update</button>
						<button class="btn btn-danger"
							formaction="Admin/VideosMangement/delete">Delete</button>
						<button class="btn btn-primary" formaction="Admin/VideosMangement/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-stripe">
				<tr>
					<th>Youtube ID</th>
					<th>Video Title</th>
					<th>View count</th>
					<th>Status</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="item" items="${videos }">
				<tr>
					<td>${item.videoid }</td>
					<td>${item.title } </td>
					<td>${item.views }</td>
					<td>${item.active ? 'Active' : 'Inactive' }</td>
					<td>
					<a class="ml-3" href="Admin/VideosMangement/edit?id=${item.videoid }"><i class="fa fa-edit"
							aria-hidden="true"></i>Edit</a> 
					<a class="ml-3" href="Admin/VideosMangement/delete?id=${item.videoid }"><i
							class="fa fa-trash" aria-hidden="true"></i>Delete</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</div>