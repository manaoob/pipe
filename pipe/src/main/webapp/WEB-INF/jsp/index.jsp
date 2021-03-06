<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Pipe System</title>
    <link href="<%=request.getContextPath()%>/lib/assets/css/controlStyle.css" rel="stylesheet"/>
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
       <div id="page-wrapper" class="page-wrapper-cls" style="padding: 0px; height:1000px; text-align:center;">
        	<!--<a href="index.html" style="margin-left: 14px; text-align: center; font-size: 24px; color: #21A9E1; font-family: '黑体';">管道参数输入</a> 
        	<a href="index.html" style="margin-left: 14px; text-align: center; font-size: 24px; color: #21A9E1; font-family: '黑体';">土体参数输入</a>
        	-->
      			<div style="height: 150px; width: 1318px; padding: 0px;margin: 0px; background-image: url(<%=request.getContextPath()%>/lib/img/backgrounds/background03.png)">
      			 	<div style="height: 10px;"></div>
      			 	<p style="margin-top: 36px; text-align: center; font-size: 48px; color: white; font-family: '黑体'; ">参数输入</p>
		 		</div>
		 	<div class="all" style="margin-top:40px;">				
				<form  class="form-horizontal" role="from" action="compute" method="post">
					<div class="form-group">
						<div class="col-md-3" style="margin-right: 10px; width: 700px; height:620px; background: #FAAC6D; border-radius: 20px;">
							<fieldset style="margin: 20px;"> 
								<legend class="def-title" style="font-size: 24px; color: white; font-family: '黑体';padding-bottom: 10px;">管道参数输入</legend>
								
								<div style="background-color: ;height: 200px; margin-bottom: 20px;padding: 0px;">
									<div class="div-inline" style="background-color: ; float:left;width: 250px;  padding:10px; margin-left:48px;">
										<img src="<%=request.getContextPath()%>/lib/img/soft_huan_01.png" style="height: 180px; width: 250px; float:left;" />
									</div>
									<div class="div-inline" style="background-color: ;float:left; padding:10px; width: 250px; ">
										<img src="<%=request.getContextPath()%>/lib/img/soft_zhou_03.png" style="height: 180px; width: 250px; float:left;" />
									</div>
								</div>
																
								<ul style="padding-top:-10px;">									
									<li class="a"><span class="def-font">管道外径：</span><input type="text" class="def-input" name="externalDiameter" placeholder="mm"/>
													<span class="def-font">管道内径：</span><input class="def-input" type="text" name="innerDiameter" placeholder="mm"/>
									</li>
									<li class="a"><span class="def-font">弹性模量：</span><input class="def-input" type="text" name="elasticityModulus" placeholder="MPa"/>
													<span class="def-font">泊松比：&nbsp;&nbsp;&nbsp;&nbsp;</span><input class="def-input" type="text" name="poissonRatio" placeholder=""/>
									</li>
									<li class="a"><span class="def-font">屈服强度：</span><input class="def-input" type="text" name="yield" placeholder="MPa"/>
													<span class="def-font">内&nbsp;&nbsp;&nbsp;&nbsp;压：&nbsp;&nbsp;&nbsp;&nbsp;</span><input class="def-input" type="text" name="pressure" placeholder="MPa"/>
									</li>
									<li class="a"><span class="def-font">弹性系数：</span><input class="def-input" type="text" name="yieldOffset" placeholder=""/>
													<span class="def-font">应变硬化系数：</span><input class="def-input" type="text" name="hardening" placeholder=""/>
									</li>
									<li class="a"><span class="def-font">裂纹形状比：</span><input class="def-input" type="text" name="crackLength" placeholder=""/>
													<span class="def-font">相对长度：</span><input class="def-input" type="text" name="relativeLength" placeholder=""/>
									</li>
									<li class="a" style="padding:0px; background-color: ;"><span class="def-font">裂纹种类：</span>
										<input class="def-font" type="radio" name="typeOfCrack" value="1" /> 环向裂纹
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font" type="radio" name="typeOfCrack" value="2" /> 轴向裂纹                              

									</li>
																												
								</ul>
								<ul>
									
								</ul>
								
								<ul>
									
								</ul>
								
							</fieldset>
							
							
						</div>
						
						<!--<div class="col-md-3" style="margin-right: 10px; width: 350px; height:200px; background: #2bbeb4; border-radius: 20px;">			

						</div>-->
						
						<div class="col-md-6" style="margin-right: 10px; width: 380px; height:620px; background: #E696C1; border-radius: 20px;">			
							<fieldset style="margin: 20px;">
								<legend style="font-size: 24px; color: white; font-family: '黑体';padding-bottom: 10px;">土体参数输入</legend>
									<div style="background-color: ;height: 200px; margin-bottom: 20px;padding: 0px;">
										<div  style="background-color: ;">
											<img src="<%=request.getContextPath()%>/lib/img/tuti.png" style="height: 200px; width: 300px; " />
										</div>
									</div>
									<li class="a"><span class="def-font1">沉降区长度：</span><input type="text" class="def-input" name="lenghtOfSubside" placeholder="mm"/></li>
									<li class="a"><span class="def-font1">沉降深度：</span><input class="def-input" type="text" name="depthOfSubside" placeholder="mm"/></li>
									<li class="a"><span class="def-font1">埋&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;深：</span><input class="def-input" type="text" name="buriedDepth" placeholder="mm"/></li>
									<li class="a"><span class="def-font1">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> 砂土
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> 粉土
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> 黏土                                   
									</li>
									
									<!--<li class="a"><span class="def-font">泊松比：&nbsp;&nbsp;</span> <input class="def-input" type="text" placeholder="mm"/></li>								
									<li class="a"><span class="def-font">裂纹长度：</span><input class="def-input" type="text" placeholder="mm"/></li>
									<li class="a"><span class="def-font">相对长度：</span><input class="def-input" type="text" placeholder="mm"/></li>								
									<li class="a"><span class="def-font">内压：</span><input class="def-input" type="text" placeholder="MPa"/></li>									-->
							
							</fieldset>	
						</div>		
					
					</div>
					<h3 style="color:red;">${message}</h3>
					<div style="margin-top: 50px;">
						<button type="submit" class="btn-blue" style="background: #d9edf6;">提交计算</button>
						<a href="testJson">${temp}</a> 
					</div>
				</form>
			</div>	
			
			<!--  <div id="main" style="height: 500px; background-color: ;"></div> -->
        
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
