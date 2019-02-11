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
	        <div id="page-wrapper" class="page-wrapper-cls" style="padding: 0px;">
			 	<div class="all" style="background-image: url(<%=request.getContextPath()%>/lib/img/backgrounds/background01.png);padding: 0px; margin: 0px;">				
					<div style="height: 40px;"></div>
					<p style="margin-top: 0px; text-align: center; font-size: 48px; color: #21A9E1; font-family: '黑体';">数据分析</p>
					<div style="height: 10px;"></div>
					<form  action="" class="form-horizontal" role="from">
						<div>
							<div style="margin: 15px; text-align: center;">
							 <label class="checkbox-inline">
							 	<span style=" color:white; font-size:18px;">裂纹类型：<span>
							 </label>
							 <label class="checkbox-inline">
							      <input  type="radio" name="typeOfCrack" id="optionsRadios3" 
							         value="1" > <span style="font-size:18px ; color: white;">环向裂纹</span>
							   </label>
							   <label class="checkbox-inline">
							      <input type="radio" name="typeOfCrack" id="optionsRadios4" 
							         value="2">  <span style="font-size:18px ; color: white;">轴向裂纹</span>
							   </label> 
							</div>
							
							<div style="margin: 15px;">
								<p style="margin-left:-240px; color:white; font-size:18px; background-color: red;">影响因素：<p>
								
						<c:choose>
							<c:when test="${param1==1}">
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
										    <option value="1" selected="selected">不同沉降长度</option>
										    <option value="2">不同沉降深度</option>
										    <option value="3">不同土体种类</option> 
										    <option value="4">不同管道埋深</option>
										    <option value="5">不同裂纹形状比</option>     
										    <option value="6">不同裂纹相对深度</option>
										    <option value="7">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text" name="yield" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" name="hardening" type="text" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength" placeholder="mm"/>
									<!-- <span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside" placeholder="mm"/>  -->
									<span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" name="depthOfSubside" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth" placeholder="mm"/></li>
									<li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li>
								</ul>
							</c:when>
							<c:when test="${param1==2}">
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
										    <option value="1">不同沉降长度</option>
										    <option value="2" selected="selected">不同沉降深度</option>
										    <option value="3">不同土体种类</option> 
										    <option value="4">不同管道埋深</option>
										    <option value="5">不同裂纹形状比</option>     
										    <option value="6">不同裂纹相对深度</option>
										    <option value="7">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter"  placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text"  name="yield" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure"  placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" type="text" name="hardening" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength"  placeholder="mm"/>
									<span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside"  placeholder="mm"/>  
									<!-- <span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" placeholder="mm"/> -->
									<span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth"  placeholder="mm"/></li>
									<li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li>
								</ul>								
							</c:when>
							<c:when test="${param1==3}">
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
										    <option value="1">不同沉降长度</option>
										    <option value="2">不同沉降深度</option>
										    <option value="3" selected="selected">不同土体种类</option> 
										    <option value="4">不同管道埋深</option>
										    <option value="5">不同裂纹形状比</option>     
										    <option value="6">不同裂纹相对深度</option>
										    <option value="7">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text" name="yield" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" name="hardening" type="text" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside" placeholder="mm"/>  
									<span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" name="depthOfSubside" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth" placeholder="mm"/></li>
									<!-- <li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li> -->
								</ul>								
							</c:when>
							<c:when test="${param1==4}">
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
										    <option value="1">不同沉降长度</option>
										    <option value="2">不同沉降深度</option>
										    <option value="3" >不同土体种类</option> 
										    <option value="4" selected="selected">不同管道埋深</option>
										    <option value="5">不同裂纹形状比</option>     
										    <option value="6">不同裂纹相对深度</option>
										    <option value="7">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter"  placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text"  name="yield" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure"  placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" type="text" name="hardening" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength"  placeholder="mm"/>
									<span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside"  placeholder="mm"/>  
									<span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" placeholder="mm"/> 
									<!-- <span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth"  placeholder="mm"/>-->
									</li>
									<li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li>
								</ul>								
							</c:when>	
							<c:when test="${param1==5}">
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
										    <option value="1">不同沉降长度</option>
										    <option value="2">不同沉降深度</option>
										    <option value="3" >不同土体种类</option> 
										    <option value="4">不同管道埋深</option>
										    <option value="5" selected="selected">不同裂纹形状比</option>     
										    <option value="6">不同裂纹相对深度</option>
										    <option value="7">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text" name="yield" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" name="hardening" type="text" placeholder="mm"/>
									<!--<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>-->
									<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside" placeholder="mm"/>  
									<span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" name="depthOfSubside" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth" placeholder="mm"/></li>
									<li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li>
								</ul>								
							</c:when>
							<c:when test="${param1==6}">
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
										    <option value="1">不同沉降长度</option>
										    <option value="2">不同沉降深度</option>
										    <option value="3" >不同土体种类</option> 
										    <option value="4">不同管道埋深</option>
										    <option value="5">不同裂纹形状比</option>     
										    <option value="6" selected="selected">不同裂纹相对深度</option>
										    <option value="7">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text" name="yield" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" name="hardening" type="text" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>
									<!--<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength" placeholder="mm"/>-->
									<span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside" placeholder="mm"/>  
									<span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" name="depthOfSubside" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth" placeholder="mm"/></li>
									<li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li>
								</ul>								
							</c:when>
							<c:when test="${param1==7}"> 
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
										    <option value="1">不同沉降长度</option>
										    <option value="2">不同沉降深度</option>
										    <option value="3" >不同土体种类</option> 
										    <option value="4">不同管道埋深</option>
										    <option value="5">不同裂纹形状比</option>     
										    <option value="6">不同裂纹相对深度</option>
										    <option value="7" selected="selected">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text" name="yield" placeholder="mm"/>
									<!--<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure" placeholder="mm"/>-->
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" name="hardening" type="text" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside" placeholder="mm"/>  
									<span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" name="depthOfSubside" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth" placeholder="mm"/></li>
									<li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li>
								</ul>									
							</c:when>
							<c:otherwise>
								<select id="mySelect" class="form-control selectpicker" style="width: 200px; margin: auto; ">
											<option value="1">不同沉降长度</option>
										    <option value="2">不同沉降深度</option>
										    <option value="3" >不同土体种类</option> 
										    <option value="4">不同管道埋深</option>
										    <option value="5">不同裂纹形状比</option>     
										    <option value="6">不同裂纹相对深度</option>
										    <option value="7">不同内压</option>
								</select>
								<ul>
									<li class="a"><span class="def-font-query" style="color:white;">管道外径：</span><input type="text" class="def-input-result" name="externalDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">管道内径：</span><input class="def-input-result" type="text" name="innerDiameter" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性模量：</span><input class="def-input-result" type="text" name="elasticityModulus" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">泊松比：</span><input class="def-input-result" type="text" name="poissonRatio" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">屈服强度：</span><input class="def-input-result" type="text" name="yield" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">内压：</span><input class="def-input-result" type="text" name="pressure" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">弹性系数：</span><input class="def-input-result" type="text" name="yieldOffset" placeholder="mm"/></li>
									<li class="a"><span class="def-font-query" style="color:white;">应变硬化系数：</span><input class="def-input-result" name="hardening" type="text" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">裂纹形状比：</span><input class="def-input-result" type="text" name="crackLength" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">相对长度：</span><input class="def-input-result" type="text" name="relativeLength" placeholder="mm"/>
									<!-- <span class="def-font-query" style="color:white;">沉降区长度：</span><input class="def-input-result" type="text" name="lenghtOfSubside" placeholder="mm"/>  -->
									<span class="def-font-query" style="color:white;">沉降深度：</span><input class="def-input-result" type="text" name="depthOfSubside" placeholder="mm"/>
									<span class="def-font-query" style="color:white;">埋深：</span><input class="def-input-result" type="text" name="buriedDepth" placeholder="mm"/></li>
									<li class="a"><span class="def-font1" style="color:white;">土体种类：</span>
										<input class="def-font1" type="radio" name="typeOfSoil" value="1" /> <span style="color:white;">砂土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="2" /> <span style="color:white;">粉土</span>
                                        &nbsp; &nbsp; &nbsp;
                                        <input class="def-font1" type="radio" name="typeOfSoil" value="3" /> <span style="color:white;">黏土</span>                                   
									</li>
								</ul>								
							</c:otherwise>					 													
							</c:choose>
								
								
							</div>
							
						</div>
						
						<div style="margin-top: 20px; text-align: center;">
							<button type="submit" class="btn-blue" style="background: #d9edf6;">提交分析</button> 
						</div>
					</form>					
					<div style="height: 20px;"></div>	
				</div>	
				<h1>${param1}</h1>
				<div id="main" style="height: 500px; background-color: ;"></div>
	        
	        </div>           
           
           
           
           
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
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
	<script language="javascript" type="text/javascript">  
		$(document).ready(function(){  
		$('#mySelect').change(function(){  
		//alert($(this).children('option:selected').val());  
		var p1 = $(this).children('option:selected').val();//这就是selected的值  
		//var p2=$('#param2').val();//获取本页面其他标签的值  
		//window.location.href="xx.php?param1="+p1+"¶m2="+p2+"";//页面跳转并传参
		window.location.href="ansysFactor?"+"param="+p1;  //页面跳转并传参
		})  
		})  
	</script>  

</body>
</html>
