<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4 mb-2">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="videoEditing-tab" data-toggle="tab" href="#videoEditing"
                            role="tab" aria-controls="videoEditing" aria-selected="true">Favorites</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
                            aria-controls="videoList" aria-selected="false">Favorite User</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" id="shareFriend-tab" data-toggle="tab" href="#shareFriend" role="tab"
                            aria-controls="shareFriend" aria-selected="false">Share friend</a>
                    </li>

                </ul>
                <jsp:include page="/common/alert.jsp"></jsp:include>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="videoEditing" role="tabpanel"
                        aria-labelledby="videoEditing-tab">
                        <table class="table table-stripe mt-3">
                            <tr>
                                <th>Video title</th>
                                <th>Favorites count</th>
                                <th>Lasted Date</th>
                                <th>Oldest Date</th>
                            </tr>
                            
                            <c:forEach var="item" items="${favreport }">
                            <tr>
                                <td>${item.videotitle }</td>
                                <td>${item.count }</td>
                                <td>${item.newsestdate }</td>
                                <td>${item.oldestdate }</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="tab-pane fade" id="videoList" role="tabpanel" aria-labelledby="videoList-tab">
                        <form action="Admin/ReportsManagement" method="get">
                            <div class="row mt-3">
                                <div class="col">
                                    <div class="form-inline">
                                        <div class="form-group">
                                            <label>Video Title
                                                <select name="videoid" id="videoid" class="form-control ml-3">
                                                    <c:forEach var="item" items="${videoList }">
                                                    	<option value="${item.videoid }" ${vid==item.videoid? 'selected' : '' }>${item.title }</option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                            <button class="btn btn-info ml-3">Report</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col mt-3">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>Username</th>
                                            <th>Fullname</th>
                                            <th>Email</th>
                                            <th>Favorite Date</th>
                                        </tr>
                                        <c:forEach var="item" items="${ufReport }">
                                        <tr>
                                            <td>${item.username }</td>
                                            <td>${item.fullname }</td>
                                            <td>${item.email }</td>
                                            <td>${item.favoritedate }</td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="tab-pane fade" id="shareFriend" role="tabpanel" aria-labelledby="shareFriend-tab">
                        <form action="" method="get">
                            <div class="row mt-3">
                                <div class="col">
                                    <div class="form-inline">
                                        <div class="form-group">
                                            <label>Video Title
                                                <select name="" id="" class="form-control ml-3">
                                                    <option value="">Java Programming</option>
                                                </select>
                                            </label>
                                            <button class="btn btn-info ml-3">Report</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col mt-3">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>Sender Name</th>
                                            <th>Sender Email</th>
                                            <th>Receiver Email</th>
                                            <th>Sent Date</th>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>