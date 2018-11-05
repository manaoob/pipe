<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Pipe System</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/lib/css/controlStyle.css" />
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
                <a  class="navbar-brand" href="index.html"> 

                </a>
            </div>

            <div class="notifications-wrapper">
<ul class="nav">
               
              <!--    <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 1</strong>
                                                <span class="pull-right text-muted">60% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                                    <span class="sr-only">60% Complete (danger)</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 2</strong>
                                                <span class="pull-right text-muted">30% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                                    <span class="sr-only">30% Complete</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 3</strong>
                                                <span class="pull-right text-muted">80% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                                    <span class="sr-only">80% Complete (warning)</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div>
                                            <p>
                                                <strong>Task 4</strong>
                                                <span class="pull-right text-muted">90% Complete</span>
                                            </p>
                                            <div class="progress progress-striped active">
                                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                                                    <span class="sr-only">90% Complete (success)</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a class="text-center" href="#">
                                        <strong>See Tasks List + </strong>
                                    </a>
                                </li>
                            </ul>
                </li> -->
              
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user-plus"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="toPro"><i class="fa fa-user-plus"></i> My Profile</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out"></i> Logout</a>
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
                            <img src="assets/img/user.jpg" class="img-circle" />

                           
                        </div>

                    </li>
                     <li>
                        <a  href="toPro"> <strong> ${user.username} </strong></a>
                    </li>

                    <li>
                        <a class="active-menu"  href="toIndex"><i class="fa fa-dashboard "></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="toUI"><i class="fa fa-venus "></i>UI Elements </a>
                        
                    </li>
                    
                    <li>
                        <a href="toTable"><i class="fa fa-bolt "></i>Data Tables </a>
                        
                    </li>
                   
                     
                     <li>
                        <a href="toForms"><i class="fa fa-code "></i>Forms</a>
                    </li>
                   
                    <li>
                        <a href="#"><i class="fa fa-sitemap "></i>Multilevel Link <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-cogs "></i>Second  Link</a>
                            </li>
                             <li>
                                <a href="#"><i class="fa fa-bullhorn "></i>Second Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third  Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="blank.html"><i class="fa fa-dashcube "></i>Blank Page</a>
                    </li>
                   
                </ul>
            </div>

        </nav>
        <!-- /. SIDEBAR MENU (navbar-side) -->
               <div id="page-wrapper" class="page-wrapper-cls">
        <p style="margin-top: 36px; text-align: center; font-size: 36px; color: #21A9E1; font-family: '黑体';">管道参数输入</p>
			<div class="all">
				
				<form  class="form-horizontal" role="from">
					<div class="form-group">
						<div class="col-md-3" style="margin-right: 10px; width: 350px; height:200px; background: #d96615; border-radius: 20px;">
							<fieldset style="margin: 20px;">
								<legend>模型参数</legend>
								<ul>
									<li class="a"><span class="def-font">管道外径：</span><input type="text" class="def-input"/></li>
									<li class="a">管道内径：<input type="text" /></li>
									<li class="a">管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;厚：<input type="text" /></li>
								</ul>
							</fieldset>
							
							
						</div>
						
						<div class="col-md-3" style="margin-right: 10px; width: 350px; height:200px; background: #2bbeb4; border-radius: 20px;">			
							<fieldset style="margin: 20px;">
								<legend>材料属性</legend>
								<ul>
									<li class="a">弹性模量：<input type="text" /></li>
									<li class="a">泊松比：&nbsp;&nbsp; <input type="text" /></li>
								</ul>
							</fieldset>
						</div>
						
						<div class="col-md-3" style="margin-right: 10px; width: 350px; height:200px; background: #e93dab; border-radius: 20px;">			
							<fieldset style="margin: 20px;">
								<legend>管道模型图</legend>
									<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
							</fieldset>	
						</div>		
					</div>
					
			
					<div class="form-group">
						<div class="col-md-3" style="margin-right: 10px; width: 350px; height:200px; background: #d96615; border-radius: 20px;">		
							<fieldse style="margin: 20px;">
								<legend>裂纹尺寸</legend>
								<ul>
									<li class="a">裂纹长度：<input type="text" /></li>
									<li class="a">相对长度： <input type="text" /></li>
								</ul>
							</fieldset>
						</div>
						
						<div class="col-md-3" style=" margin-right: 10px; width: 350px; height:200px; background: #2bbeb4; border-radius: 20px;">		
							<fieldse style="margin: 20px;">
								<legend>操作参数</legend>
								<ul>
									<li class="a">内压：<input type="text" /></li>
									<!--<li class="a">： <input type="text" /></li>-->
								</ul>
							</fieldset>
						</div>
						
						<div class="col-md-3" style="margin-right: 10px; width: 350px; height:200px; background: #adaa37; border-radius: 20px;">			
							<fieldset style="margin: 20px;">
								<legend>说明</legend>
									<p>  哈哈哈哈哈哈，哈哈哈哈哈哈</p>
							</fieldset>
						</div>
					</div>
					<div style="margin-top: 50px;">
						<button type="submit" class="btn-blue" style="background: #d9edf6;">提交计算</button>
					</div>
				</form>
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


</body>
</html>
