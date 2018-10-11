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
            添加难度
        </p>
    </div>
    <div class="col-md-6 tabDiv" onclick="edit()" id="editTab">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            修改难度
        </p>
    </div>
    <div class="loginDIV" style="margin-top: 35px" id="addDiff">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <input type="text" class="form-control input-lg" id="addDiffName" placeholder="难度等级" style="margin-top: 100px">
            <input type="number" class="form-control input-lg" id="addDiffConsume" placeholder="消耗体力" style="margin-top: 50px">
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="addDiff()">添加难度</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none" id="editDiff">
        <div style="text-align: center">
            <div style="text-align: center" class="col-md-8 col-md-offset-2">
                <select class="form-control" id="editSelect" onchange="changeSelect()">
                </select>
                <input type="text" class="form-control input-lg" id="editDiffName" placeholder="难度等级" style="margin-top: 100px">
                <input type="number" class="form-control input-lg" id="editDiffConsume" placeholder="消耗体力" style="margin-top: 50px">
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="editDiff()">修改难度</button>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    var allDiff;
    window.onload=function(){
        $.ajax({
            url:strQueryAllDiff,
            dataType:'json',
            async:false,
            success:function(data){
                allDiff =data.res;
                console.log(allDiff)
                var strHtml="<option value='0'></option>";
                for(i=0;i<allDiff.length;i++){
                    strHtml+="<option value='"+allDiff[i].diff_ID+"'>"+allDiff[i].diff_Diff+"</option>"
                }
                $("#editSelect").html(strHtml);
            }
        })
    }
    function changeSelect(){
        var a = $("#editSelect option:selected").val();
        for(i=0;i<allDiff.length;i++){
            if (a==allDiff[i].diff_ID){
                $("#editDiffName").val(allDiff[i].diff_Diff);
                $("#editDiffConsume").val(allDiff[i].diff_Consume);

            }
        }
    }
    function add(){
        $("#addTab").removeClass("tabDiv");
        $("#editTab").removeClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv");
        $("#addDiff").css("display","block");
        $("#editDiff").css("display","none");
    }
    function edit(){
        $("#editTab").removeClass("tabDiv");
        $("#addTab").removeClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv");
        $("#addDiff").css("display","none");
        $("#editDiff").css("display","block");
    }
    function empty(){
        $("#addDiffName").val("");
        $("#addDiffConsume").val("");
    }
    function addDiff(){
        var diffName = $("#addDiffName").val();
        var diffConsume = $("#addDiffConsume").val();
        $.ajax({
            url:strAddDiff,
            data:{
                diffName:diffName,
                diffConsume:diffConsume
            },
            dataType:"json",
            success:function (result){
                if (result.code==1){
                    alert("添加难度成功");
                    empty();
                }
            }
        })
    }
    function editDiff(){
        alert("尽请期待")
    }
</script>
</body>
</html>
