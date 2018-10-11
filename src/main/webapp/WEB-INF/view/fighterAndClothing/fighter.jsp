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
            添加飞机
        </p>
    </div>
    <div class="col-md-6 tabDiv" onclick="edit()" id="editTab">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            修改飞机
        </p>
    </div>
    <div class="loginDIV" style="margin-top: 35px;height: 470px" id="addFighter">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <input type="text" class="form-control" id="addFighterName" placeholder="飞机名称" style="margin-top: 20px">
            <input type="text" class="form-control " id="addFighterDriver" placeholder="驾驶员" style="margin-top: 20px">
            <input type="number" class="form-control " id="addFighterAttack" placeholder="攻击" style="margin-top: 20px">
            <input type="number" class="form-control " id="addFighterHit" placeholder="命中" style="margin-top: 20px">
            <input type="text" class="form-control " id="addFighterIMG" placeholder="飞机图标" style="margin-top: 20px">
            <select class="form-control" id="addFighterOpus" style="margin-top: 10px">
            </select>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="addFighter()">添加飞机</button>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none;height: 470px" id="editFighter">
        <div style="text-align: center">
            <div style="text-align: center" class="col-md-8 col-md-offset-2">
                <select class="form-control" id="editSelect" onchange="changeSelect()">
                </select>
                <input type="text" class="form-control" id="editFighterName" placeholder="飞机名称" style="margin-top: 20px">
                <input type="text" class="form-control " id="editFighterDriver" placeholder="驾驶员" style="margin-top: 20px">
                <input type="number" class="form-control " id="editFighterAttack" placeholder="攻击" style="margin-top: 20px">
                <input type="number" class="form-control " id="editFighterHit" placeholder="命中" style="margin-top: 20px">
                <input type="text" class="form-control " id="editFighterIMG" placeholder="飞机图标" style="margin-top: 20px">
                <select class="form-control" id="editFighterOpus" style="margin-top: 20px">
                </select>
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="editFighter()">修改飞机</button>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    var allOpus;
    var allFighter;
    window.onload=function(){
        $.ajax({
            url:strQueryAllOpus,
            dataType:'json',
            async:false,
            success:function(data){
                allOpus =data.res;
                var strHtml="<option value='0'>请选择作品</option>";
                for(i=0;i<allOpus.length;i++){
                    strHtml+="<option value='"+allOpus[i].opus_ID+"'>"+allOpus[i].opus_Name+"</option>"
                }
                $("#addFighterOpus").html(strHtml);
                $("#editFighterOpus").html(strHtml);
            }
        });
        $.ajax({
            url:strQueryAllFighter,
            dataType:'json',
            async:false,
            success:function(data){
                allFighter =data.res;
                var strHtml="<option value='0'></option>";
                for(i=0;i<allFighter.length;i++){
                    strHtml+="<option value='"+allFighter[i].fighter_ID+"'>"+allFighter[i].fighter_Name+"</option>"
                }
                $("#editSelect").html(strHtml);
            }
        });
    }
    function changeSelect(){
        var a = $("#editSelect option:selected").val();
        $.ajax({
            url:strQueryFighterOpus,
            data:{
                fighter:a
            },
            dataType:'json',
            success:function(data){
                $("#editFighterOpus").val(data.res)
            }
        })
        for(i=0;i<allFighter.length;i++){
            if (a==allFighter[i].fighter_ID){
                $("#editFighterName").val(allFighter[i].fighter_Name);
                $("#editFighterAttack").val(allFighter[i].fighter_Attack);
                $("#editFighterDriver").val(allFighter[i].fighter_Driver);
                $("#editFighterHit").val(allFighter[i].fighter_Hit);
                $("#editFighterIMG").val(allFighter[i].fighter_IMG);



            }
        }
    }
    function add(){
        $("#addTab").removeClass("tabDiv");
        $("#editTab").removeClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv");
        $("#addFighter").css("display","block");
        $("#editFighter").css("display","none");
    }
    function edit(){
        $("#editTab").removeClass("tabDiv");
        $("#addTab").removeClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv");
        $("#addFighter").css("display","none");
        $("#editFighter").css("display","block");
    }
    function empty(){
        $("#addFighterName").val("");
        $("#addfighterdriver").val("");
        $("#addfighterattack").val("");
        $("#addfighterhit").val("");
        $("#addfighterimg").val("");
    }
    function addFighter(){
        var fighterName = $("#addFighterName").val();
        var fighterDriver = $("#addFighterDriver").val();
        var fighterAttack = $("#addFighterAttack").val();
        var fighterHit = $("#addFighterHit").val();
        var fighterIMG = $("#addFighterIMG").val();
        var fighterOpus = $("#addFighterOpus option:selected").val();
        $.ajax({
            url:strAddFighter,
            data:{
                fighterName:fighterName,
                fighterDriver:fighterDriver,
                fighterAttack:fighterAttack,
                fighterHit:fighterHit,
                fighterIMG:fighterIMG,
                fighterOpus:fighterOpus
            },
            dataType:"json",
            success:function (result){
                if (result.code==1){
                    alert("添加属性成功");
                    empty();
                }
            }
        })
    }
    function editFighter(){
        alert("尽请期待")
    }
</script>
</body>
</html>
