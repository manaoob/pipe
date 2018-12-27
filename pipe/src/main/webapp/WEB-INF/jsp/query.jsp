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
     <link href="<%=request.getContextPath()%>/lib/assets/css/bootstrap.min.css" rel="stylesheet" /> 
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
    <link href="<%=request.getContextPath()%>/lib/assets/css/controlStyle.css" rel="stylesheet"  />
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
                   
                     
                     <li>
                        <a href="toAnsys"><i class="fa fa-code "></i>结果分析</a>
                    </li>
                   
                   
                    <li>
                        <a href="toBlank"><i class="fa fa-dashcube "></i>Blank Page</a>
                    </li>
                   
                </ul>
            </div>

        </nav>
        <!-- /. SIDEBAR MENU (navbar-side) -->
        <div id="page-wrapper" class="page-wrapper-cls">
            <div id="page-inner">
               <div class="all">
			 <p style="margin-top: 36px; text-align: center; font-size: 36px; color: #21A9E1; font-family: '黑体';">结果查询</p>
				<form  class="form-horizontal" role="from">
					<div class="form-group">
						<div class="" style="margin-right: 10px;height:200px; background: #00A651; border-radius: 20px;">
							<fieldset style="margin: 20px;">
								<legend class="def-title">查询参数</legend>
								<ul>
									<li class="a"><span class="def-font-result">管道外径：</span><input type="text" class="def-input-result" placeholder="mm"/>
									<span class="def-font-result">管道内径：</span><input class="def-input-result" type="text" placeholder="mm"/>
									<span class="def-font-result">裂纹长度：</span><input class="def-input-result" type="text" placeholder="mm"/>
									<span class="def-font-result">内压：</span><input type="text" class="def-input-result" placeholder="mm"/></li>
									<li class="a"><span class="def-font-result">裂纹类型：</span><input type="radio" name="colors" id="red">内裂纹
									              <input type="radio" name="colors" id="blue">外裂纹</li>
								</ul>
							</fieldset>							
								<input type="submit" value="查询" class="btn-primary btn" >														
						</div>												
					</div>
					
					<div class="form-group" style="background: #00A651; height:500px ; border-radius: 20px;">
						
					<h1 style="color: white;"> 详细结果</h1>
						
										
						<div class="form-group">
							<div class="col-md-3" style="margin-left: 35px; margin-right: 5px; width: 340px; height:400px; background: #d96615; border-radius: 20px;">
								<fieldset style="margin: 15px;">
									<legend class="def-title">应力计算结果</legend>
									<ul>
										<li class="a"><span class="def-font-result">裂纹尖端最大MISES：</span><input type="text" class="def-input-result" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端Max.Principal：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端Max.Principal(abs)：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端Mid.Principal：</span><input type="text" class="def-input-result" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端Min.Principal：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端S11：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端S22：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端S33：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
									</ul>
								</fieldset>
								
								
							</div>
							
							<div class="col-md-3" style="margin-right: 5px; width: 340px; height:400px; background: #2bbeb4; border-radius: 20px;">			
								<fieldset style="margin: 15px;">
									<legend>应变计算结果</legend>
									<ul>
										<li class="a"><span class="def-font-result">裂纹尖端Magnitude：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端U1：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端U2：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">应力强度因子K：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
									</ul>
								</fieldset>
							</div>
							
							<div class="col-md-3" style="margin-right: 5px; width: 340px; height:400px; background: #e93dab; border-radius: 20px;">			
								<fieldset style="margin: 15px;">
									<legend>应力应变图</legend>
										<p class="def-font-result">Mises应力图</p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
										<p></p>
										<p class="def-font-result">总应变图 </p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
								</fieldset>	
							</div>		
						</div>
						
						
					</div>
				</form>
		</div>

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <footer >
       &copy; 2019 YourCompany | By : <a href="" target="_blank">Allen</a>
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
