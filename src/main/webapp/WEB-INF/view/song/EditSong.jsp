<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>

<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <script type="text/javascript" src="<%=path%>static/urlSetting.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=path%>static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>static/css/style.css">
</head>
<body  class="background">

<div class="col-md-6 col-md-offset-3" style="margin-top: 100px">
    <h1>尽请期待</h1>


</div>
<script type="text/javascript">
    function tab(){
        $("#tab1").removeClass("tabDiv");
        $("#tab2").removeClass("tabDiv");
        $("#tab3").removeClass("tabDiv");
        $("#tab4").removeClass("tabDiv");
        $("#tab1").removeClass("tabDiv-sel");
        $("#tab2").removeClass("tabDiv-sel");
        $("#tab3").removeClass("tabDiv-sel");
        $("#tab4").removeClass("tabDiv-sel");
    }
    function tab2(){
        tab();
        $("#tab2").addClass("tabDiv-sel");
        $("#tab1").addClass("tabDiv");
        $("#tab3").addClass("tabDiv");
        $("#tab4").addClass("tabDiv");
        $("#ttab2").css("display","block");
        $("#ttab1").css("display","none");
        $("#ttab3").css("display","none");
        $("#ttab4").css("display","none");
    }
    function tab3(){
        tab();
        $("#tab3").addClass("tabDiv-sel");
        $("#tab1").addClass("tabDiv");
        $("#tab2").addClass("tabDiv");
        $("#tab4").addClass("tabDiv");
        $("#ttab3").css("display","block");
        $("#ttab1").css("display","none");
        $("#ttab2").css("display","none");
        $("#ttab4").css("display","none");
    }
    function tab4(){
        tab();
        $("#tab4").addClass("tabDiv-sel");
        $("#tab1").addClass("tabDiv");
        $("#tab2").addClass("tabDiv");
        $("#tab3").addClass("tabDiv");
        $("#ttab4").css("display","block");
        $("#ttab1").css("display","none");
        $("#ttab2").css("display","none");
        $("#ttab3").css("display","none");
    }
</script>
</body>
</html>
