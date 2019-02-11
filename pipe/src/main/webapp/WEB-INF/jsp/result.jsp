<%@page pageEncoding="utf-8"%>
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
        <div id="page-wrapper" class="page-wrapper-cls" style="padding: 0px; height:1000px">
      		<div style="height: 150px; width: 1318px; padding: 0px;margin: 0px; background-image: url(<%=request.getContextPath()%>/lib/img/backgrounds/background03.png)">
      			 <div style="height: 10px;"></div>
      			 <p style="margin-top: 36px; text-align: center; font-size: 48px; color: white; font-family: '黑体'; ">计算结果</p>
		 	</div>
		<div style="height:40px"></div>
		<div id="CrackJs" style="height: 400px; width:400px; float:left"></div>
		<div id="CrackMises" style="height: 400px; width:400px; float:left"></div>
		<div id="AxialMises" style="height: 400px; width:400px; float:left"></div>
		<div id="AxialU2" style="height: 400px; width:400px; float:left"></div>
		<div id="AxialPressure" style="height: 400px; width:400px; float:left"></div>	
		<div id="AxialShear" style="height: 400px; width:400px; float:left"></div>
		
		<a href="testJson"> submit</a>
		
		<!--  
		<div class="all">
			 <<p style="margin-top: 36px; text-align: center; font-size: 36px; color: #21A9E1; font-family: '黑体';">管道参数输入</p>
				<form  class="form-horizontal" role="from">
					<div class="form-group">
						<div class="col-md-3" style="margin-right: 5px; width: 350px; height:400px; background: #d96615; border-radius: 20px;">
							<fieldset style="margin: 20px;">
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
						
						<div class="col-md-3" style="margin-right: 5px; width: 350px; height:400px; background: #2bbeb4; border-radius: 20px;">			
							<fieldset style="margin: 20px;">
								<legend>应变计算结果</legend>
								<ul>
									<li class="a"><span class="def-font-result">裂纹尖端Magnitude：</span><input class="def-input-result" type="text" placeholder="mm"/></li>
									<li class="a"><span class="def-font-result">裂纹尖端U1：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
									<li class="a"><span class="def-font-result">裂纹尖端U2：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
									<li class="a"><span class="def-font-result">应力强度因子K：</span> <input class="def-input-result" type="text" placeholder="mm"/></li>
								</ul>
							</fieldset>
						</div>
						
						<div class="col-md-3" style="margin-right: 5px; width: 350px; height:400px; background: #e93dab; border-radius: 20px;">			
							<fieldset style="margin: 20px;">
								<legend>应力应变图</legend>
									<p class="def-font-result">Mises应力图</p>
									<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
									<p></p>
									<p class="def-font-result">总应变图 </p>
									<img src="img/_02.png" style="text-align: center; width: 150px; height: 100px;"/>
							</fieldset>	
						</div>		
					</div>  -->
					
			
			
					<!-- 
					<div style="margin-top: 50px;">
						<input type="submit" value="保存" class="btn-primary btn">
					</div> 
				</form> -->
				
		</div>
            <!-- /. PAGE INNER  -->
            
        </div>
        <!-- /. PAGE WRAPPER  -->
        
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
	               // data: [12,15,18,21,14]
	 				
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
	
	
	
	
	
	
	
	
	
	
	
	/**	$.ajax({
		    type : "get",
		    async : true,
		    url : "testJson",
		    dataType:"json",
		    success:function(map) {
		        
		        if(map)
		        {
		           var obj =  map ; 
		           myChart.hideLoading();
		             myChart.setOption({
		                // xAxis:{  
		                  //   data:obj.xAxisData
		                // },  
		                 series:[{
		                	 	data:obj[1]
		                 
		                 		}]
		                 
		             });
		        }
		                  
		   },
		    error : function(errorMsg) {
		        //请求失败时执行该函数
		    alert("请求数据失败!");
		    myChart.hideLoading();
		    }
		});
	**/
		
	</script >     


</body>
</html>
