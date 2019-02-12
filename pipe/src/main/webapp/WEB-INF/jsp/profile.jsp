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
                <a  class="navbar-brand" href="">PipeSystem 

                </a>
            </div>

            <div class="notifications-wrapper">
<ul class="nav">
               
                <li class="dropdown">
                    
                </li>
              
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user-plus"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="toPro"><i class="fa fa-user-plus"></i>个人信息</a>
                        </li>
                        <li class="divider"></li>
                        
                        <li><a href="editPass"><i class="fa fa-home"></i>密码修改</a>
                        </li>                                          
                        
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-sign-out"></i>注销</a>
                        </li>
                    </ul>
                </li>
            </ul>
               
            </div>
        </nav>
        <!-- /. NAV TOP  -->
        <nav  class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src= "<%=request.getContextPath()%>/images/${user.photo}"  class="img-circle" style="width: 150px;height: 150px; border-radius:250px;overflow: hidden;"/>
                        </div>

                    </li>
                     <li>
                        <a  href="toPro"> <strong> ${user.username}</strong></a>
                    </li>

                    <li>
                        <a href="toIndex"><i class="fa fa-dashboard "></i>管道参数</a>
                    </li>
                    <li>
                        <a href="toResult"><i class="fa fa-venus "></i>计算结果 </a>
                        
                    </li>
                    
                    <li>
                        <a href="toQuery"><i class="fa fa-bolt "></i>计算结果查询 </a>
                        
                    </li>
                   
                     
                    <!--  
                     <li>
                        <a href="toAnsys"><i class="fa fa-code "></i>结果分析</a>
                    </li>
                   --> 
                   
                   
                    <li>
                        <a href="toBlank"><i class="fa fa-dashcube "></i>说明</a>
                    </li>
                   
                </ul>
            </div>

        </nav>
        <!-- /. SIDEBAR MENU (navbar-side) -->
        <div id="page-wrapper" class="page-wrapper-cls">
               <div id="page-inner">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                        	<div class="col-md-4">
                        		<img class="user_profile_img" src="<%=request.getContextPath()%>/images/${user.photo}" alt="" style="width: 150px;height: 150px; border-radius:250px;overflow: hidden;"/>                        		
                        	</div>                            
                            <div class="col-md-8">
                            	<h1 class="user_profile_name"> ${user.nickName}</h1>
	                            <p class="user_profile_info">&nbsp;</p>
	                            <!--<p><button class="btn-danger">上传头像</button> </p>-->
                            </div>

                        </div>
                    </div>
                    <hr/>
                    <div class="row">
                        <div class="col-md-12">
                           <form id="myForm" action= "infoChange" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
                                <h3 class="heading_a"><span class="heading_text">基本信息</span></h3>
                                <div class="form-group">
                                    <label for="profile_username" class="col-sm-2 control-label">用户名</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="profile_username" value="${user.username}" disabled="disabled">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="profile_name" class="col-sm-2 control-label">昵称</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="profile_name" name="nickName" value="${user.nickName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="profile_bday" class="col-sm-2 control-label">生日</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="" name="birthday" value="${user.birthday}">
                                    </div>
                                </div>
                                <div class="form-group">
                                	<label class="col-sm-2 control-label">头像</label>
                                	<div class="col-sm-10">
		                               
		                                	<div class="col-md-4">
		                                		<input id="choose-file" type="file" name="photo" />
		                                	</div>

									</div>
                                </div>
                                <h3 class="heading_a"><span class="heading_text">详细信息</span></h3>

                                <div class="form-group">
                                    <label for="profile_fb" class="col-sm-2 control-label">性别</label>
                                    <div class="col-sm-6">
                                        <input type="radio" name="gender" value="男" /> 男
                                        &nbsp; &nbsp; &nbsp;
                                        <input type="radio" name="gender" value="女" /> 女
                                   <!--      <select class="form-control" name="gender">
											<option value="男">男</option>
											<option value="女">女</option>										
										</select>  -->
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="profile_skype" class="col-sm-2 control-label">联系方式</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="profile_skype" name="phone" value="${user.phone}">
                                    </div>
                                </div>
                               
                                <div class="form-group">
                                    <label for="profile_fb" class="col-sm-2 control-label">QQ/WeChat</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="profile_fb" name="QQorWechat" value="${user.QQorWechat}">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="profile_email" class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="profile_email" name="email" value="${user.email}">
                                    </div>
                                </div>
                                <h3 class="heading_a"><span class="heading_text">其他信息</span></h3>
                                <div class="form-group">
                                    <label for="profile_notes" class="col-sm-2 control-label">个人简介</label>
                                    <div class="col-sm-10">
                                        <textarea id="profile_notes" name="notes" cols="30" rows="4" class="form-control">
											${user.notes}
                                        </textarea>
                                    </div>
                                </div>
                                <hr/>
                                <div class="form-group">
                                    <div class="col-sm-10 col-sm-offset-2">
                                        <input type="submit" value="提交" class="btn-primary btn">
                                        <button class="btn-default btn" onclick="formReset();">取消</button>
                                        <h4>${hint}</h4>
                                    </div>
                                </div>
                            </form>                            
                        </div>
                    </div>                
                    </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
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
	</script>

</body>
</html>
