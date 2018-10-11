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
            添加衣服
        </p>
    </div>
    <div class="col-md-6 tabDiv" onclick="edit()" id="editTab">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            修改衣服
        </p>
    </div>
    <div class="loginDIV" style="margin-top: 35px;height: 470px" id="addClothing">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <input type="text" class="form-control input-lg" id="addClothingName" placeholder="衣服名称" style="margin-top: 50px">
            <input type="text" class="form-control input-lg" id="addClothingFeatures" placeholder="衣服效果" style="margin-top: 50px">
            <input type="text" class="form-control input-lg" id="addClothingIMG" placeholder="衣服图标" style="margin-top: 50px">
            <select class="form-control" id="addClothingSinger" style="margin-top: 10px">
            </select>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="addClothing()">添加衣服</button>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none;height: 470px" id="editClothing">
        <div style="text-align: center">
            <div style="text-align: center" class="col-md-8 col-md-offset-2">
                <select class="form-control" id="editSelect" onchange="changeSelect()">
                </select>
                <input type="text" class="form-control input-lg" id="editClothingName" placeholder="衣服名称" style="margin-top: 50px">
                <input type="text" class="form-control input-lg" id="editClothingFeatures" placeholder="衣服效果" style="margin-top: 50px">
                <input type="text" class="form-control input-lg" id="editClothingIMG" placeholder="衣服图标" style="margin-top: 50px">
                <select class="form-control" id="editClothingSinger" style="margin-top: 20px">
                </select>
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="editClothing()">修改衣服</button>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    var allSinger;
    var allClothing;
    window.onload=function(){
        $.ajax({
            url:strQueryAllSinger,
            dataType:'json',
            async:false,
            success:function(data){
                allSinger =data.res;
                var strHtml="<option value='0'>请选择歌手</option>";
                for(i=0;i<allSinger.length;i++){
                    strHtml+="<option value='"+allSinger[i].singer_ID+"'>"+allSinger[i].singer_Name+"</option>"
                }
                $("#addClothingSinger").html(strHtml);
                $("#editClothingSinger").html(strHtml);
            }
        });
        $.ajax({
            url:strQueryAllClothing,
            dataType:'json',
            async:false,
            success:function(data){
                allClothing =data.res;
                var strHtml="<option value='0'></option>";
                for(i=0;i<allClothing.length;i++){
                    strHtml+="<option value='"+allClothing[i].clothing_ID+"'>"+allClothing[i].clothing_Name+"</option>"
                }
                $("#editSelect").html(strHtml);
            }
        });
    }
    function changeSelect(){
        var a = $("#editSelect option:selected").val();
        $.ajax({
            url:strQueryClothingSinger,
            data:{
                clothing:a
            },
            dataType:'json',
            success:function(data){
                $("#editClothingSinger").val(data.res)
            }
        })

        for(i=0;i<allClothing.length;i++){
            if (a==allClothing[i].clothing_ID){
                $("#editClothingName").val(allClothing[i].clothing_Name);
                $("#editclothingfeatures").val(allClothing[i].clothing_Features);
                $("#editClothingIMG").val(allClothing[i].clothing_IMG);



            }
        }
    }
    function add(){
        $("#addTab").removeClass("tabDiv");
        $("#editTab").removeClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv");
        $("#addClothing").css("display","block");
        $("#editClothing").css("display","none");
    }
    function edit(){
        $("#editTab").removeClass("tabDiv");
        $("#addTab").removeClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv");
        $("#addClothing").css("display","none");
        $("#editClothing").css("display","block");
    }
    function empty(){
        $("#addClothingName").val("");
        $("#addClothingIMG").val("");
        $("#addClothingFeatures").val("");
        $("#addClothingSinger").val(0);
    }
    function addClothing(){
        var clothingName = $("#addClothingName").val();
        var clothingIMG = $("#addClothingIMG").val();
        var clothingFeatures = $("#addClothingFeatures").val();
        var clothingSinger = $("#addClothingSinger option:selected").val();
        $.ajax({
            url:strAddClothing,
            data:{
                clothingName:clothingName,
                clothingIMG:clothingIMG,
                clothingFeatures:clothingFeatures,
                clothingSinger:clothingSinger
            },
            dataType:"json",
            success:function (result){
                console.log(result)
                if (result.code==1){
                    alert("添加衣服成功");
                    empty();
                }
            }
        })
    }
    function editClothing(){
        alert("尽请期待")
    }
</script>
</body>
</html>
