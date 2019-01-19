<%@page pageEncoding="utf-8"%>
<!--
	作者：289141865@qq.com
	时间：2018-09-24
	描述：bootstrap 的注册页面
-->
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pipe Register</title>

        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lib/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lib/bootstrap/css/style.css"/>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/lib/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/lib/css/form-elements.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/lib/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="lib/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/lib/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/lib/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/lib/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/lib/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>
        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>用户注册</strong> Register </h1>
                            <!--<div class="description">
                            	<p>
	                            	This is a free responsive login form made with Bootstrap. 
	                            	Download it on <a href="#"><strong>AZMIND</strong></a>, customize and use it as you like!
                            	</p>
                            </div>-->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Register to our site</h3>
                            		<!--<p>请输入您的用户名和密码:</p>-->
                            		<p>${hint}</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="register" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">用户名</label>
			                        	<input type="text" name="username" placeholder="用户名..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">输入密码</label>
			                        	<input type="password" name="password" placeholder="输入密码..." class="form-password form-control" id="form-password">
			                        </div>
			                        <div class="form-group">
			           
			                        		<label class="sr-only" for="form-password">确认密码</label>
			                        		<input type="password" name="rePassword" placeholder="确认密码..." class="form-password form-control" id="form-password">		                        
			                        </div>			                        
			                        <button type="submit" class="btn">注册</button>	
								</form>
		                    </div>
                        </div>
                    </div>
                    <!--<div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>...or login with:</h3>
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-facebook"></i> Facebook
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-twitter"></i> Twitter
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-google-plus"></i> Google Plus
	                        	</a>
                        	</div>
                        </div>
                    </div>-->
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="<%=request.getContextPath()%>/lib/js/jquery-1.11.1.min.js"></script>
        <script src="<%=request.getContextPath()%>/lib/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/lib/js/jquery.backstretch.min.js"></script>
        <script src="<%=request.getContextPath()%>/lib/js/scripts.js"></script>
		<!--<script type="text/javascript">
			/**
			 * 刷新验证码
			 */
			function reloadCode(){
			    var time = new Date().getTime();
			    document.getElementById("imgCode").src="VerifyCode?d=" + time;
			    }
			function checkLoginNoNull() {
			    if ($.trim($("#verifycode").val()) == "") {
			        alert("验证码不能为空！请重新输入！");
			        return false;
			    }
			}
			function toRegister(){
				window.location=" <%=request.getContextPath()%>/user/ResAction> ";
			}
			</script>-->
    </body>

</html>