<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<title>Super购，欢迎登录</title>

    <link rel="stylesheet" type="text/css" href="css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="css/pages-login.css" />
</head>

<body>
	<div class="login-box">
		<!--head-->
		<div class="py-container logoArea">
			<a href="" class="logo"></a>
		</div>
		<!--loginArea-->
		<div class="loginArea">
			<div class="py-container login">
				<div class="loginform">
					<ul class="sui-nav nav-tabs tab-wraped">
						<li>
							<a href="#index" data-toggle="tab">
								<h3>扫描登录</h3>
							</a>
						</li>
						<li class="active">
							<a href="#profile" data-toggle="tab">
								<h3>账户登录</h3>
							</a>
						</li>
					</ul>
					<div class="tab-content tab-wraped">
						<div id="index" class="tab-pane">
							<p>二维码登录，暂为官网二维码</p>
							<img src="img/wx_cz.jpg" />
						</div>
						<div id="profile" class="tab-pane  active">
							<form class="sui-form" id="loginForm" action="login" method="post">
								<div class="input-prepend"><span class="add-on loginname"></span>
									<input id="memberName" name="memberName" type="text" placeholder="邮箱/用户名/手机号" class="span2 input-xfat">
								</div>
								<div class="input-prepend"><span class="add-on loginpwd"></span>
									<input id="password" name="password" type="password" placeholder="请输入密码" class="span2 input-xfat">
								</div>
								<div class="setting">
									<label class="checkbox inline">
          <input name="m1" type="checkbox" value="2" checked=""> 
          自动登录
        </label>
									<span class="forget">忘记密码？</span>
								</div>
								<div class="logined" id="logined">
									<!--<a class="sui-btn btn-block btn-xlarge btn-danger">登&nbsp;&nbsp;录</a>-->
									<input type="submit" id="login" class="sui-btn btn-block btn-xlarge btn-danger" value="登录" />
								</div>
							</form>
							<div class="otherlogin">
								<div class="types">
									<ul>
										<li><img src="img/qq.png" width="35px" height="35px" /></li>
										<li><img src="img/sina.png" /></li>
										<li><img src="img/ali.png" /></li>
										<li><img src="img/weixin.png" /></li>
									</ul>
								</div>
								<span class="register"><a href="register" target="_blank">立即注册</a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--foot-->
		<div class="py-container copyright">
			<ul>
				<li>关于我们</li>
				<li>联系我们</li>
				<li>联系客服</li>
				<li>商家入驻</li>
				<li>营销中心</li>
				<li>手机Super购</li>
				<li>销售联盟</li>
				<li>Super购社区</li>
			</ul>
			<div class="address">地址：北京市昌平区幸福安路2号楼 邮编：100096 电话：400-118-4123 传真：010-81235343</div>
			<div class="beian">京ICP备000000号京公网安备100000000
			</div>
		</div>
	</div>

<script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/pages/login.js"></script>
<!--<script>
    $(function() {
        // window.location.href="index.html"
        $('#logined').click(function(event) {
             // 清除默认事件
             // alert("验证成功,即将跳转至首页");
             event.preventDefault();

             var formObject = {
                "memberName":$('#memberName').val(),
                "password":$('#password').val()
             };
             //formObject.append('memberName', $('#memberName').val);
             //formObject.append('password', $('#password').val);
             $.ajax({
                 url:"/login",
                 type:"POST",
                 contentType: "application/json; charset=utf-8",
                 data: JSON.stringify(formObject),
                 success:function(response){
                     console.log(response);
                     if(response.status == 200){
                         window.location.href="/admin/home_page.html";
                     }else{
                         alert(response.msg);
                     }
                 }
             })
        })
    })
</script>-->
</body>

</html>