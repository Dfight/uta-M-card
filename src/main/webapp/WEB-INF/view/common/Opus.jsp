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
    <div class="col-md-6 tabDiv-sel" onclick="add()" id="addTab">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            添加作品
        </p>
    </div>
    <div class="col-md-6 tabDiv" onclick="edit()" id="editTab">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            修改作品
        </p>
    </div>
    <div class="loginDIV" style="margin-top: 35px" id="addOpus">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <input type="text" class="form-control input-lg" id="addOpusName" placeholder="作品名称" style="margin-top: 100px">
            <input type="text" class="form-control input-lg" id="addOpusIMG" placeholder="作品图标" style="margin-top: 50px">
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="addOpus()">添加作品</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none" id="editOpus">
        <div style="text-align: center">
            <div style="text-align: center" class="col-md-8 col-md-offset-2">
                <select class="form-control" id="editSelect" onchange="changeSelect()">
                </select>
                <input type="text" class="form-control input-lg" id="editOpusName" placeholder="作品名称" style="margin-top: 100px">
                <input type="text" class="form-control input-lg" id="editOpusIMG" placeholder="作品图标" style="margin-top: 50px">
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="editOpus()">修改作品</button>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    var allOpus;
    window.onload=function(){
        $.ajax({
            url:strQueryAllOpus,
            dataType:'json',
            async:false,
            success:function(data){
                allOpus =data.res;
                var strHtml="<option value='0'></option>";
                for(i=0;i<allOpus.length;i++){
                    strHtml+="<option value='"+allOpus[i].opus_ID+"'>"+allOpus[i].opus_Name+"</option>"
                }
                $("#editSelect").html(strHtml);
            }
        })
    }
    function changeSelect(){
        var a = $("#editSelect option:selected").val();
        for(i=0;i<allOpus.length;i++){
            if (a==allOpus[i].opus_ID){
                $("#editOpusName").val(allOpus[i].opus_Name);
                $("#editOpusIMG").val(allOpus[i].opus_IMG);
            }
        }
    }
    function add(){
        $("#addTab").removeClass("tabDiv");
        $("#editTab").removeClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv");
        $("#addOpus").css("display","block");
        $("#editOpus").css("display","none");
    }
    function edit(){
        $("#editTab").removeClass("tabDiv");
        $("#addTab").removeClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv");
        $("#addOpus").css("display","none");
        $("#editOpus").css("display","block");
    }
    function empty(){
        $("#addOpusName").val("");
        $("#addOpusIMG").val("");
    }
    function addOpus(){
        var opusName = $("#addOpusName").val();
        var opusIMG = $("#addOpusIMG").val();
        $.ajax({
            url:strAddOpus,
            type:'post',
            data:{
                opusName:opusName,
                opusIMG:opusIMG
            },
            dataType:"json",
            success:function (result){

                console.log(result)
                if (result.code==1){
                    alert("添加作品成功");
                    empty();
                }
            }
        })
    }
    function editOpus(){
        alert("尽请期待")
    }
</script>
</body>
</html>
