<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>

<html>
<head>
    <title>test</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="<%=path%>static/urlSetting.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=path%>static/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>static/css/style.css">
</head>
<body>
<div class="col-md-6 col-md-offset-2">
    <input type="text" class="form-control" id="b">
</div>
<div class="col-md-2">
    <button class="btn btn-primary col-md-4" onclick="get()">
        test
    </button>
</div>
<iframe height="800px" width="600px" id="a"></iframe>
<script>
    function get(){
        var src = $("#b").val();
        alert(src);
        $("#a").attr("src",src);
    }
</script>
</body>
</html>
