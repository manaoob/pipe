<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="utf-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() +
			":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Pipe System</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="<%=request.getContextPath()%>/lib/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME ICONS STYLES-->
    <link href="<%=request.getContextPath()%>/lib/assets/css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM STYLES-->
    <link href="<%=request.getContextPath()%>/lib/assets/css/style.css" rel="stylesheet" />
      <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a  class="navbar-brand" href="">Administrator

                </a>
            </div>

            <div class="notifications-wrapper">
<ul class="nav">
               

              
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user-plus"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="toPro"><i class="fa fa-user-plus"></i>个人信息</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-sign-out"></i>注销</a>
                        </li>
                    </ul>
                </li>
            </ul>
               
            </div>
        </nav>
     
        <!-- /. SIDEBAR MENU (navbar-side) -->

			<div class="row">		
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading" data-original-title>
							<h2><i class="fa fa-user"></i><span class="break"></span>&nbsp;&nbsp;&nbsp;用户信息</h2>
							<!--<div class="panel-actions">
								<a href="table.html#" class="btn-setting"><i class="fa fa-wrench"></i></a>
								<a href="table.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="table.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>-->
						</div>
						<div class="panel-body">
							<table class="table table-striped table-bordered bootstrap-datatable datatable">
							  <thead>
								  <tr>
									  <th>用户名</th>
									  <th>昵称</th>
									  <th>Email</th>
									  <th>电话</th>
									  <th>操作</th>
								  </tr>
							  </thead>   
							  <tbody>
							  <c:forEach items="${pageBean.list}" var="user">
								<tr>
									<td>${user.username}</td>
									<td>${user.nickName}</td>
									<td>${user.email}</td>
									<td>
										${user.phone}
									</td>
									<td>
										<!-- <a class="btn btn-success" href="table.html#">
											<i class="fa fa-search-plus "></i>  
										</a>
									 	<a class="btn btn-info" href="table.html#">
											<i class="fa fa-edit "></i>  
										</a> -->
										
										<a href="javascript:if(window.confirm('是否删除？')){window.location.href='deleteUser?userName=${user.username}'}">
												<i class="fa fa-trash-o "></i>
										</a>
										
									<!--  	<a class="btn btn-danger" href="deleteUser?userName=${user.username}">
											<i class="fa fa-trash-o "></i> 
										</a>  -->
										
									</td>
									
									<td onload="checkForm()">
										<input type="hidden" id="message" value="hint">
									</td>
									
								</tr>
								</c:forEach>
								
								
								
								 </tbody>
						  </table>            
						</div>
					</div>
					<div class="col-md-offset-9">
							<ul class="pagination">
							
					<c:if test="${pageBean.currentPage > 1}"> 
							<li>
								<a href="showUser?page=${pageBean.currentPage-1}">上一页</a>
							</li>
					</c:if> 							
								
								
							<!--  	<li class="active">
								  <a href="table.html#">1</a>
								</li>
								<li><a href="table.html#">2</a></li>
								<li><a href="table.html#">3</a></li>
								<li><a href="table.html#">4</a></li> -->
								
					<c:if test="${pageBean.currentPage < pageBean.totalPage}">
							<li>
								<a href="showUser?page=${pageBean.currentPage+1}">下一页</a>
							</li>
					</c:if> 																
								
							  </ul> 
					</div>
				</div><!--/col-->
			</div>     
       
    <!-- /. WRAPPER  -->
    <footer >
        &copy; 2019 YourCompany | By : <a href="http://www.designbootstrap.com/" target="_blank">Allen</a>
    </footer>
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="<%=request.getContextPath()%>/lib/assets/js/jquery-1.11.1.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="<%=request.getContextPath()%>/lib/assets/js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<%=request.getContextPath()%>/lib/assets/js/jquery.metisMenu.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="<%=request.getContextPath()%>/lib/assets/js/custom.js"></script>
	<script src="<%=request.getContextPath()%>/lib/js/scripts.js">
	function formReset()
	 {
	     document.getElementById("myForm").reset();

	 }
	
    function checkForm(){
     var flag=true;
     var message=document.getElementById("message");
     if(message!='null'){
      alert(message.value);
      flag=false;
     }
     return flag;
    }

	</script>

</body>
</html>
