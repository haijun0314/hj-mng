<!-- 页面布局：头部页面    -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<script  src="${contextPath}/static/logic/sys/userUtil.js" type="text/javascript" ></script>
<script  src="${contextPath}/static/logic/msg/msg.js" type="text/javascript" ></script>
<%
	String navbarId=(String)request.getAttribute("navbarId");
%>

<script type="text/javascript">
$(document).ready(function(){
	UserUtil.loadLoginUser();
	$("#"+"<%=navbarId%>").addClass("active");
});
 
 

/***********顶部导航点击********/
function navbarClick(navbarId){
	window.location.href="${contextPath}/index?sysIndex&navbarId="+navbarId;
}
 
 
</script>

	<div id="navbar" class="navbar navbar-default navbar-wrapper" style="height: 50px;width: 100%;z-index: 9999">
			<div id="navbar-container" class="navbar-container">
				<div class="navbar-header pull-left" ></div>
				<div class="navbar-header pull-left">
					
					<a href="${contextPath}/forward?index">
						<img  src="${contextPath}/static/image/logo.png" style="float: left;"/>
					</a>
					
					<a class="navbar-brand navbar-btn" href="##" id="navbar-btn-1" onclick="navbarClick('navbar-btn-1')">
						<small>
							管理平台 
						</small>
					</a>
					<!-- 
					<a class="navbar-brand navbar-btn" href="###" id="navbar-btn-2" onclick="navbarClick('navbar-btn-2')">
						<small>
							统计分析
						</small>
					</a>
					<a class="navbar-brand navbar-btn" href="###" id="navbar-btn-3" onclick="navbarClick('navbar-btn-3')">
						<small>
							用户管理
						</small>
					</a>
					<a class="navbar-brand navbar-btn" href="###" id="navbar-btn-4" onclick="navbarClick('navbar-btn-4')">
						<small>
							管理平台 
						</small>
					</a>
					<a class="navbar-brand navbar-btn" href="###" id="navbar-btn-5" onclick="navbarClick('navbar-btn-5')">
						<small>
							帮助中心
						</small>
					</a> -->
				</div>

				<div role="navigation" class="navbar-header pull-right">
					<ul class="nav ace-nav">
						<li class="purple">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" >
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important" id="activity"></span>
							</a>

							<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-warning-sign">
									通知
									</i>
								</li>

								<li>
									<a href="#" onclick="activity()">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
												活动审核
											</span>
											<span class="pull-right badge badge-info" id="activityStat">+</span>
											<input type="hidden" id="userType" >
										</div>
									</a>
								</li>
							</ul>
						</li>
						<!-- 
						<li class="grey">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="icon-tasks"></i>
								<span class="badge badge-grey">4</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-ok"></i>
									还有4个任务完成
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">软件更新</span>
											<span class="pull-right">65%</span>
										</div>

										<div class="progress progress-mini ">
											<div class="progress-bar " style="width:65%"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">硬件更新</span>
											<span class="pull-right">35%</span>
										</div>

										<div class="progress progress-mini ">
											<div class="progress-bar progress-bar-danger" style="width:35%"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">单元测试</span>
											<span class="pull-right">15%</span>
										</div>

										<div class="progress progress-mini ">
											<div class="progress-bar progress-bar-warning" style="width:15%"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">错误修复</span>
											<span class="pull-right">90%</span>
										</div>

										<div class="progress progress-mini progress-striped active">
											<div class="progress-bar progress-bar-success" style="width:90%"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										查看任务详情
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>
						
						
						


						<li class="green">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="icon-envelope"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-envelope-alt"></i>
									5条消息
								</li>

								<li>
									<a href="#">
										<img alt="Alex's Avatar" class="msg-photo" src="${contextPath}/static/image/avatars/avatar.png">
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Alex:</span>
												不知道写啥 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>1分钟以前</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img alt="Susan's Avatar" class="msg-photo" src="${contextPath}/static/image/avatars/avatar3.png">
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Susan:</span>
												不知道翻译...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>20分钟以前</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img alt="Bob's Avatar" class="msg-photo" src="${contextPath}/static/image/avatars/avatar4.png">
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Bob:</span>
												到底是不是英文 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>下午3:15</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="inbox.html">
										查看所有消息
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>
						 -->
						<li class="light-blue">
							<a class="dropdown-toggle" href="#" data-toggle="dropdown">
								<img alt="Jason's Photo" src="${contextPath}/static/image/avatars/user.jpg" class="nav-user-photo">
								<span class="user-info">
									<small>欢迎光临,</small>
									<span class="login_user_name"></span>
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#" onclick="UserUtil.mySet()">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#" onclick ="UserUtil.userInfo()">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>
								<li>
									<a href="#" onclick="UserUtil.setPassword()">
										<i class="icon-user" ></i>
										修改密码
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#"  onclick="UserUtil.logout()">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>
	 