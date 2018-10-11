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
    <link rel="stylesheet" type="text/css"  href="<%=path%>static/font-awesome/css/font-awesome.min.css">
</head>
<body  class="background">
<div class="col-md-6 " >
    <div class="loginDIV" style="margin-top: 35px;min-height: 200px;height: 800px">
        <div style="text-align: center" >
            <h1>添加卡基本信息</h1>
            <input type="text" class="form-control input-lg" id="addCardName" placeholder="卡面名称" style="margin-top: 50px;width: 75%;margin-left: auto;margin-right: auto">
            <h2 style="margin-top: 40px">选择歌曲对应作品</h2>
            <select class="form-control input-lg" id="opusSelect" onchange="opusSelect()" style="width: 75%;margin-left: auto;margin-right: auto">
            </select>
            <h2 style="margin-top: 40px">选择歌曲对应属性</h2>
            <select class="form-control input-lg" id="attrSelect" onchange="attrSelect()" style="width: 75%;margin-left: auto;margin-right: auto">
            </select>
            <h2 style="margin-top: 40px">选择歌曲对应衣服或飞机</h2>
            <select class="form-control input-lg" id="fighterSelect" onchange="attrSelect()" style="width: 75%;margin-left: auto;margin-right: auto">
            </select>
            <select class="form-control input-lg" id="clothingSelect" onchange="attrSelect()" style="width: 75%;margin-left: auto;margin-right: auto;margin-top: 50px">
            </select>
        </div>
        <div style="text-align: center">
            <h1>添加歌姬相性信息</h1>
            <div id="singerSelect" style="font-size: 18px"></div>
        </div>
    </div>
</div>
<div class="col-md-6 " id="init">
    <div class="loginDIV" style="margin-top: 35px;min-height: 385px">
        <div style="text-align: center">
            <h1>添加卡初期信息</h1>
            <div class="col-md-12" style="padding: 0px;">
                <div class="col-md-8">
                    <input type="text" class="form-control input-lg" id="cardInitIMG" placeholder="初期卡面" style="margin-top: 30px">
                </div>
                <div class="col-md-4" style="padding-top: 35px" id="initStar">
                    <i class="fa fa-star-o fa-2x" onclick="initStar(1)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="initStar(2)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="initStar(3)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="initStar(4)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="initStar(5)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="initStar(6)"></i>
                </div>
            </div>
            <div class="col-md-12" style="padding: 0px;margin-top: 10px">
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitTotal" placeholder="Total" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitSoul" placeholder="Soul" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitVoice" placeholder="Voice" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitCharm" placeholder="Charm" style="margin-top: 10px">
                </div>
            </div>
            <div class="col-md-12" style="padding: 0px;">
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitLife" placeholder="Life" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitSupport" placeholder="Support" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitFoldWave" placeholder="FoldWave" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardInitLuck" placeholder="Luck" style="margin-top: 10px">
                </div>
            </div>
            <div class="col-md-12" style="padding-left: 15px;padding-right: 15px;margin-top: 10px">
                <input type="text" class="form-control" id="cardInitCSkill" placeholder="初期C技能" style="margin-top: 10px">
                <input type="text" class="form-control" id="cardInitASkill" placeholder="初期A技能" style="margin-top: 10px">
                <input type="text" class="form-control" id="cardInitLSkill" placeholder="初期L技能" style="margin-top: 10px">
            </div>
        </div>
    </div>
</div>
<div class="col-md-6" id="max">
    <div class="loginDIV" style="margin-top: 0px;min-height: 385px">
        <div style="text-align: center">
            <h1> 添加卡满级信息</h1>
            <div class="col-md-12" style="padding: 0px;">
                <div class="col-md-8">
                    <input type="text" class="form-control input-lg" id="cardMaxIMG" placeholder="满级卡面" style="margin-top: 30px">
                </div>
                <div class="col-md-4" style="padding-top: 35px" id="maxStar">
                    <i class="fa fa-star-o fa-2x" onclick="maxStar(1)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="maxStar(2)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="maxStar(3)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="maxStar(4)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="maxStar(5)"></i>
                    <i class="fa fa-star-o fa-2x" onclick="maxStar(6)"></i>
                </div>
            </div>
            <div class="col-md-12" style="padding: 0px;margin-top: 10px">
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxTotal" placeholder="Total" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxSoul" placeholder="Soul" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxVoice" placeholder="Voice" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxCharm" placeholder="Charm" style="margin-top: 10px">
                </div>
            </div>
            <div class="col-md-12" style="padding: 0px;">
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxLife" placeholder="Life" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxSupport" placeholder="Support" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxFoldWave" placeholder="FoldWave" style="margin-top: 10px">
                </div>
                <div class="col-md-3">
                    <input type="number" class="form-control" id="cardMaxLuck" placeholder="Luck" style="margin-top: 10px">
                </div>
            </div>
            <div class="col-md-12" style="padding-left: 15px;padding-right: 15px;margin-top: 10px">
                <input type="text" class="form-control" id="cardMaxCSkill" placeholder="满级C技能" style="margin-top: 10px">
                <input type="text" class="form-control" id="cardMaxASkill" placeholder="满级A技能" style="margin-top: 10px">
                <input type="text" class="form-control" id="cardMaxLSkill" placeholder="满级L技能" style="margin-top: 10px">
            </div>
        </div>
    </div>
</div>

<div class="col-md-offset-3 col-md-6">
    <button style="margin-top: 30px;width: 33%" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
    <button style="margin-top: 30px;width: 32%" class="btn btn-lg btn-primary" onclick="addCard()">添加新卡</button>
    <button style="margin-top: 30px;width: 33%" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空</button>
</div>

<script type="text/javascript">
    var allOpus;
    var allAttribute;
    var allSinger;
    var allClothing;
    var allFighter;
    window.onload=function(){
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
                $("#fighterSelect").html(strHtml);
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
                $("#clothingSelect").html(strHtml);
            }
        });
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
                $("#opusSelect").html(strHtml);
            }
        });
        $.ajax({
            url:strQueryAllAttr,
            dataType:'json',
            async:false,
            success:function(data){
                allAttribute =data.res;
                var strHtml="<option value='0'></option>";
                for(i=0;i<allAttribute.length;i++){
                    strHtml+="<option value='"+allAttribute[i].attr_ID+"'>"+allAttribute[i].attr_Name+"</option>"
                }
                $("#attrSelect").html(strHtml);
            }
        });
        $.ajax({
            url:strQueryAllSinger,
            dataType:'json',
            async:false,
            success:function(data){
                allSinger =data.res;
                var strHtml="";
                for(i=0;i<allSinger.length;i++){
                    strHtml+="<div class='col-xs-4'><input style='zoom:150%;float: left' type='checkbox' value='"+allSinger[i].singer_ID+"'>"+allSinger[i].singer_Name+"</div>";
                }
                $("#singerSelect").html(strHtml);
            }
        })
    }
    function initStar(num) {
        $("#initStar i").removeClass("fa-star");
        $("#initStar i").removeClass("fa-star-o");
        $("#initStar i").addClass("fa-star-o");
        if (num == 1) {
            $("#initStar i:lt(1)").removeClass("fa-star-o");
            $("#initStar i:lt(1)").addClass("fa-star");
        } else if (num == 2) {
            $("#initStar i:lt(2)").removeClass("fa-star-o");
            $("#initStar i:lt(2)").addClass("fa-star");
        } else if (num == 3) {
            $("#initStar i:lt(3)").removeClass("fa-star-o");
            $("#initStar i:lt(3)").addClass("fa-star");
        } else if (num == 4) {
            $("#initStar i:lt(4)").removeClass("fa-star-o");
            $("#initStar i:lt(4)").addClass("fa-star");
        } else if (num == 5) {
            $("#initStar i:lt(5)").removeClass("fa-star-o");
            $("#initStar i:lt(5)").addClass("fa-star");
        } else if(num==6){
            $("#initStar i:lt(5)").removeClass("fa-star-o");
            $("#initStar i:lt(5)").addClass("fa-star");
            $("#initStar i:eq(5)").removeClass("fa-star-o");
            $("#initStar i:eq(5)").addClass("fa-star");
        }
    }
    function maxStar(num) {
        $("#maxStar i").removeClass("fa-star");
        $("#maxStar i").removeClass("fa-star-o");
        $("#maxStar i").addClass("fa-star-o");
        if (num == 1) {
            $("#maxStar i:lt(1)").removeClass("fa-star-o");
            $("#maxStar i:lt(1)").addClass("fa-star");
        } else if (num == 2) {
            $("#maxStar i:lt(2)").removeClass("fa-star-o");
            $("#maxStar i:lt(2)").addClass("fa-star");
        } else if (num == 3) {
            $("#maxStar i:lt(3)").removeClass("fa-star-o");
            $("#maxStar i:lt(3)").addClass("fa-star");
        } else if (num == 4) {
            $("#maxStar i:lt(4)").removeClass("fa-star-o");
            $("#maxStar i:lt(4)").addClass("fa-star");
        } else if (num == 5) {
            $("#maxStar i:lt(5)").removeClass("fa-star-o");
            $("#maxStar i:lt(5)").addClass("fa-star");
        } else if(num==6){
            $("#maxStar i:lt(5)").removeClass("fa-star-o");
            $("#maxStar i:lt(5)").addClass("fa-star");
            $("#maxStar i:eq(5)").removeClass("fa-star-o");
            $("#maxStar i:eq(5)").addClass("fa-star");
        }
    }
    function empty(){
//        $("input").val("");
//        $("select").val(0);
//        $("input[type='checkbox']").removeAttr('checked');
//        initStar(0);
//        maxStar(0);
        window.location.reload();
    }

    function addCard(){

        if($("#addCardName").val()==""||$("#addCardName").val()==null){
            alert("请添加卡名");
            return;
        }
        if($("#opusSelect").val()==0){
            alert("请选择作品");
            return;
        }
        if($("#attrSelect").val()==0){
            alert("请选择属性");
            return;
        }
        if($("#fighterSelect").val()!=0&&$("#clothingSelect").val()!=0){
            alert("一张卡不能同时绑定飞机和服装");
            return;
        }
        if($("input[type='checkbox']:checked").length==0){
            alert("请添加歌姬相性");
            return;
        }
        if($("#initStar .fa-star").size()==0||$("#init input").val()==""||$("#init input").val()==null){
            alert("请添加初期卡面信息");
           return;
        }
        if($("#maxStar .fa-star").size()==0||$("#max input").val()==""||$("#max input").val()==null){
            alert("请添加满级卡面信息");
            return;
        }
        if($("#cardInitASkill").val()==null||$("#cardInitASkill").val()==""||$("#cardInitCSkill").val()==null||$("#cardInitCSkill").val()==""||$("#cardInitLSkill").val()==null||$("#cardInitLSkill").val()==""){
            alert("请添加初期技能信息");
            return;
        }
        if($("#cardMaxASkill").val()==null||$("#cardMaxASkill").val()==""||$("#cardMaxCSkill").val()==null||$("#cardMaxCSkill").val()==""||$("#cardMaxLSkill").val()==null||$("#cardMaxLSkill").val()==""){
            alert("请添加满级技能信息");
            return;
        }

        var singer = new Array();
        $("input[type='checkbox']:checked").each(function(){
            singer.push($(this).val())
        })
        var init = {
            initIMG : $("#cardInitIMG").val(),
            initStar : $("#initStar .fa-star").size(),
            initTotal : $("#cardInitTotal").val(),
            initSoul : $("#cardInitSoul").val(),
            initVoice : $("#cardInitVoice").val(),
            initCharm : $("#cardInitCharm").val(),
            initLife : $("#cardInitLife").val(),
            initSupport : $("#cardInitSupport").val(),
            initFoldWave : $("#cardInitFoldWave").val(),
            initLuck : $("#cardInitLuck").val(),
            initASkill : $("#cardInitASkill").val(),
            initCSkill : $("#cardInitCSkill").val(),
            initLSkill : $("#cardInitLSkill").val()
        }
        var max = {
            maxIMG : $("#cardMaxIMG").val(),
            maxStar : $("#maxStar .fa-star").size(),
            maxTotal : $("#cardMaxTotal").val(),
            maxSoul : $("#cardMaxSoul").val(),
            maxVoice : $("#cardMaxVoice").val(),
            maxCharm : $("#cardMaxCharm").val(),
            maxLife : $("#cardMaxLife").val(),
            maxSupport : $("#cardMaxSupport").val(),
            maxFoldWave : $("#cardMaxFoldWave").val(),
            maxLuck : $("#cardMaxLuck").val(),
            maxASkill : $("#cardMaxASkill").val(),
            maxCSkill : $("#cardMaxCSkill").val(),
            maxLSkill : $("#cardMaxLSkill").val()
        }
        var data = {
            cardName:$("#addCardName").val(),
            opus : $("#opusSelect :checked").val(),
            attr : $("#attrSelect :checked").val(),
            fighter : $("#fighterSelect :checked").val(),
            clothing : $("#clothingSelect :checked").val(),
            singer : singer,
            init :  JSON.stringify(init),
            max : JSON.stringify(max)
        };
        console.log(data);
        $.ajax({
            url:strAddCard,
            dataType:'json',
            type:'post',
            async:false,
            data :data,
            success:function(data){

            }
        })

    }
</script>
</body>
</html>
