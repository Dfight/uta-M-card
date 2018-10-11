<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <script type="text/javascript" src="static/urlSetting.js"></script>
    <script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/style.css">

</head>
<body class="background">
<div class="col-md-6 col-md-offset-3 loginDIV">
    <h1 class="text-center" style="margin-top: 20px">login</h1>
    <div style="width: 50%;margin-right: auto;margin-left: auto;margin-top: 50px">
        <input type="text" id="name" class="form-control input-lg" style="margin-top: 50px">
        <input type="password" id="pass" class="form-control input-lg" style="margin-top: 50px">
        <input type="button" onclick="login()" value="登录" class="form-control input-lg" style="margin-top: 50px">
    </div>
</div>
<script type="text/javascript">
    function login(){
        var name  = $("#name").val();
        var pass  = $("#pass").val();
        $.ajax({
            url : strLogin,
            data :{
                name:name,
                pass:pass
            },
            success:function(data){
                if (data){
                    window.location.href = strToMain;
                }
            }
        })
    }
</script>
</body>
</html>