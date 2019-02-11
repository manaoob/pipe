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
                   
                     
                     <li>
                        <a href="toAnsys"><i class="fa fa-code "></i>结果分析</a>
                    </li>
                   
                   
                    <li>
                        <a href="toBlank"><i class="fa fa-dashcube "></i>说明</a>
                    </li>
                   
                </ul>
            </div>

        </nav>
        <!-- /. SIDEBAR MENU (navbar-side) -->
        <div id="page-wrapper" class="page-wrapper-cls" style="padding:0px; height:1500px">
      		<div style="height: 150px; width: 1318px; padding: 0px;margin: 0px; background-image: url(<%=request.getContextPath()%>/lib/img/backgrounds/background03.png)">
      			 <div style="height: 10px;"></div>
      			 <p style="margin-top: 36px; text-align: center; font-size: 48px; color: white; font-family: '黑体'; ">结果查询</p>
		 	</div>
            <div id="page-inner" >
               <div class="all" style="margin-top: 0px;">
				<form  class="form-horizontal" role="from" action="query" method="post">
					<div class="form-group">
						<div class="" style="margin-right: 10px;height:280px; background: #ACD373; border-radius: 20px;">
							<fieldset style="margin: 20px;">
								<legend class="def-title" style="text-align:center;">查询参数</legend>
								<ul>
							
									<li class="a"><span class="def-font-result">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter" placeholder="mm"/>
									<span class="def-font-result">管道内径：</span><input class="def-input-result" type="text"  name="innerDiameter" placeholder="mm"/>
									<span class="def-font-result">弹性模量：</span><input class="def-input-result" type="text"  name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-result">泊松比：</span><input class="def-input-result" type="text"  name="poissonRatio" placeholder="mm"/>
									<span class="def-font-result">屈服强度：</span><input class="def-input-result" type="text"  name="yield" placeholder="mm"/>
									<span class="def-font-result">内压：</span><input class="def-input-result" type="text"  name="pressure" placeholder="mm"/>
									<span class="def-font-result">弹性系数：</span><input class="def-input-result" type="text"  name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-result">应变硬化系数：</span><input class="def-input-result" type="text"  name="hardening" placeholder="mm"/>
									<span class="def-font-result">裂纹形状比：</span><input class="def-input-result" type="text"  name="crackLength" placeholder="mm"/>
									<span class="def-font-result">相对长度：</span><input class="def-input-result" type="text"  name="relativeLength" placeholder="mm"/>
									<span class="def-font-result">沉降区长度：</span><input class="def-input-result" type="text"  name="lenghtOfSubside" placeholder="mm"/>
									<span class="def-font-result">沉降深度：</span><input class="def-input-result" type="text"  name="depthOfSubside" placeholder="mm"/>
									<span class="def-font-result">埋深：</span><input class="def-input-result" type="text"  name="buriedDepth" placeholder="mm"/></li>
									<li class="a"><span class="def-font-result">裂纹类型：</span><input type="radio" name="typeOfCrack" id="red" value="1">环向裂纹
									              <input type="radio" name="typeOfCrack" id="blue" value="2">轴向裂纹</li>
									<li class="a"><span class="def-font1">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> 砂土
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> 粉土
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> 黏土                                   
									</li>
								</ul>
							</fieldset>							
								<input type="submit" value="查询" class="btn-primary btn" >														
						</div>												
					</div>
					
					<!--  
					<div class="form-group" style="background: #ACD373; height:500px ; border-radius: 20px;">
						
					<h1 style="color: white;"> 详细结果</h1>
						
										
						<div class="form-group">
							<div class="col-md-3" style="margin-left: 35px; margin-right: 5px; width: 190px; height:400px; background: #FAAC6D; border-radius: 20px;">
								<fieldset style="margin: 15px;">
									<legend class="def-title" style="font-family: '黑体';">竖直位移</legend>
									<ul>
										<li class="a"><span class="def-font-result">裂纹尖端最大MISES：</span><input type="text" class="def-input-result" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端Max.Principal：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端Max.Principal(abs)：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端Mid.Principal：</span><input type="text" class="def-input-result" placeholder="mm"/></li>
									</ul>
								</fieldset>
								
								
							</div>
							
							<div class="col-md-3" style="margin-right: 5px; width: 190px; height:400px; background: #FAAC6D; border-radius: 20px;">			
								<fieldset style="margin: 15px;">
									<legend class="def-title" style="font-family: '黑体';">轴向正应力</legend>
									<ul>
										<li class="a"><span class="def-font-result">裂纹尖端Magnitude：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端U1：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">裂纹尖端U2：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
										<li class="a"><span class="def-font-result">应力强度因子K：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
									</ul>
								</fieldset>
							</div>
							
							<div class="col-md-3" style="margin-right: 5px; width: 190px; height:400px; background: #FAAC6D; border-radius: 20px;">			
								<fieldset style="margin: 15px;">
									<legend class="def-title" style="font-family: '黑体';">轴向剪应力</legend>
										<p class="def-font-result">Mises应力图</p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
										<p></p>
										<p class="def-font-result">总应变图 </p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
								</fieldset>	
							</div>	
							<div class="col-md-3" style="margin-right: 5px; width: 190px; height:400px; background: #FAAC6D; border-radius: 20px;">			
								<fieldset style="margin: 15px;">
									<legend class="def-title" style="font-family: '黑体';font-size:20px;">轴向mises应力</legend>
										<p class="def-font-result">Mises应力图</p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
										<p></p>
										<p class="def-font-result">总应变图 </p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
								</fieldset>	
							</div>								
							<div class="col-md-3" style="margin-right: 5px; width: 190px; height:400px; background: #FAAC6D; border-radius: 20px;">			
								<fieldset style="margin: 15px;">
									<legend class="def-title" style="font-family: '黑体';">裂纹J积分</legend>
										<p class="def-font-result">Mises应力图</p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
										<p></p>
										<p class="def-font-result">总应变图 </p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
								</fieldset>	
							</div>
							<div class="col-md-3" style="margin-right: 5px; width: 190px; height:400px; background: #FAAC6D; border-radius: 20px;">			
								<fieldset style="margin: 15px;">
									<legend class="def-title" style="font-family: '黑体'; font-size:16px;">裂纹处mises应力</legend>
										<p class="def-font-result">Mises应力图</p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
										<p></p>
										<p class="def-font-result">总应变图 </p>
										<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
								</fieldset>	
							</div>																	
						</div>
						
						
					</div> -->
				</form>
				
		</div>
				
		<div style="height:40px"></div>
		<div id="CrackJs" style="height: 400px; width:400px; float:left"></div>
		<div id="CrackMises" style="height: 400px; width:400px; float:left"></div>
		<div id="AxialMises" style="height: 400px; width:400px; float:left"></div>
		<div id="AxialU2" style="height: 400px; width:400px; float:left"></div>
		<div id="AxialPressure" style="height: 400px; width:400px; float:left"></div>	
		<div id="AxialShear" style="height: 400px; width:400px; float:left"></div>
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
    <script src="<%=request.getContextPath()%>/lib/assets/js/echarts.min.js"></script>
    
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        
        var myChart1 = echarts.init(document.getElementById('CrackJs'));
	      option={
	            title: {
	                text: '沿裂纹的J积分值',
					borderWidth:2,
					x:'center'
					
	            },
	            tooltip: {},
	            legend: {
					orient:'vertical',
					x:'right',
	                data:[]
					
	            },
	            xAxis: {
					type: 'category',
					name: '单位/。',
	                data: ${mapCrackJs.X}
					//data: [1,2,3,4,5]
	            },
	            yAxis: { 
						name: '单位/kJm-2'
						},
	            series: [{
	                name: '',
	                type: 'line',
//					stack:'总水量',
					smooth: true,
					data: ${mapCrackJs.Y}
	                //data: [12,15,18,21,14]
	 				
	            }]
//				{
//	                name: 'd=600',
//	                type: 'line',
//					stack:'总水量',
//					color:'#B5C334',
//					smooth: true,
//					data:${map.first}
	                //data: [22,25,28,31,24]
//	            }
	
	        };
	     myChart1.setOption(option);
	var myChart2 = echarts.init(document.getElementById('CrackMises'));
	      option={
	            title: {
	                text: '沿裂纹的mises应力',
					borderWidth:2,
					x:'center'
					
	            },
	            tooltip: {},
	            legend: {
					orient:'vertical',
					x:'right',
	                data:[]
					
	            },
	            xAxis: {
					type: 'category',
					name: '单位/。',
	                data: ${mapCrackMises.X}
	            },
	            yAxis: { 
						name: '单位/MPa'
						},
	            series: [{
	                name: '',
	                type: 'line',
//					stack:'总水量',
					smooth: true,
					data:${mapCrackMises.Y}
	               // data: [12,15,18,21,14]
	 				
	            }]
	            
	        };
	     myChart2.setOption(option);

	var myChart3 = echarts.init(document.getElementById('AxialMises'));
	      option={
	            title: {
	                text: '管道轴向mises应力',
					borderWidth:2,
					x:'center'
					
	            },
	            tooltip: {},
	            legend: {
					orient:'vertical',
					x:'right',
	                data:[]
					
	            },
	            xAxis: {
					type: 'category',
					name: '单位/m',
	                data: ${mapAxialMises.X}
	            },
	            yAxis: { 
						name: '单位/MPa'
						},
	            series: [{
	                name: '',
	                type: 'line',
//					stack:'总水量',
					smooth: true,
					data: ${mapAxialMises.Y}
	               // data: [12,15,18,21,14]
	 				
	            }]
	            
	        };
	     myChart3.setOption(option);

	var myChart4 = echarts.init(document.getElementById('AxialU2'));
	      option={
	            title: {
	                text: '管道沉降',
					borderWidth:2,
					x:'center'
					
	            },
	            tooltip: {},
	            legend: {
					orient:'vertical',
					x:'right',
	                data:[]
					
	            },
	            xAxis: {
					type: 'category',
					name: '单位/m',
	                data: ${mapAxialU2.X}
	            },
	            yAxis: { 
						name: '单位/mm'
						},
	            series: [{
	                name: '',
	                type: 'line',
//					stack:'总水量',
					smooth: true,
					data:${mapAxialU2.Y}
	               // data: [12,15,18,21,14]
	 				
	            }]
	            
	        };
	     myChart4.setOption(option);
	
	var myChart5 = echarts.init(document.getElementById('AxialPressure'));
	      option={
	            title: {
	                text: '管道轴应力',
					borderWidth:2,
					x:'center'
					
	            },
	            tooltip: {},
	            legend: {
					orient:'vertical',
					x:'right',
	                data:[]
					
	            },
	            xAxis: {
					type: 'category',
					name: '单位/m',
	                data: ${mapAxialPressure.X}
	            },
	            yAxis: { 
						name: '单位/MPa'
						},
	            series: [{
	                name: '',
	                type: 'line',
//					stack:'总水量',
					smooth: true,
					data:${mapAxialPressure.Y}
	               // data: [12,15,18,21,14]
	 				
	            }]
	            
	        };
	     myChart5.setOption(option);
		
	var myChart6 = echarts.init(document.getElementById('AxialShear'));
	      option={
	            title: {
	                text: '管道切应力',
					borderWidth:2,
					x:'center'
					
	            },
	            tooltip: {},
	            legend: {
					orient:'vertical',
					x:'right',
	                data:[]
					
	            },
	            xAxis: {
					type: 'category',
					name: '单位/m',
	                data: ${mapAxialShear.X}
	            },
	            yAxis: { 
						name: '单位/MPa'
						},
	            series: [{
	                name: '',
	                type: 'line',
//					stack:'总水量',
					smooth: true,
					data:${mapAxialShear.Y}
	               // data: [12,15,18,21,14]
	 				
	            
	            }]
	        };
	     myChart6.setOption(option);	
	</script>

</body>
</html>
