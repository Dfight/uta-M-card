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
    <div class="col-md-3 tabDiv-sel"  id="tab1">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            添加歌曲
        </p>
    </div>
    <div class="col-md-3 tabDiv"  id="tab2">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            作品属性
        </p>
    </div>
    <div class="col-md-3 tabDiv"  id="tab3" onclick="tab3()">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            难度信息
        </p>
    </div>
    <div class="col-md-3 tabDiv"  id="tab4">
    <p style="text-align: center;font-size: 20px;margin-top: 10px">
            熟练度
    </p>
</div>
    <div class="loginDIV" style="margin-top: 35px" id="ttab1">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <input type="text" class="form-control input-lg" id="addSongName" placeholder="歌曲名" style="margin-top: 50px">
            <input type="text" class="form-control input-lg" id="addSongIMG" placeholder="歌曲图标" style="margin-top: 50px">
            <input type="text" class="form-control input-lg" id="addSongSinger" placeholder="演唱者" style="margin-top: 50px">
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="addSong1()">添加歌曲</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none" id="ttab2">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <h1 style="margin-top: 40px">选择歌曲对应作品</h1>
            <select class="form-control input-lg" id="opusSelect" onchange="opusSelect()">
            </select>
            <h1 style="margin-top: 40px">选择歌曲对应属性</h1>
            <select class="form-control input-lg" id="attrSelect" onchange="attrSelect()">
            </select>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="addSong2()">保存信息</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>

        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none" id="ttab3">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <h3 style="margin-top: 10px">选择歌曲对应难度</h3>
            <select class="form-control input-lg" id="diffSelect" onchange="diffSelect()">
            </select>
            <input type="number" class="form-control input-lg" id="songRank" placeholder="歌曲等级" style="margin-top: 20px">
            <input type="number" class="form-control input-lg" id="songFCnum" placeholder="FC数" style="margin-top: 20px">
            <input type="text" class="form-control input-lg" id="songUnlock" placeholder="解锁方式" style="margin-top: 20px">
            <button style="margin-top: 20px;width: 80px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">首页</button>
            <button style="margin-top: 20px;width: 80px" class="btn btn-lg btn-primary" onclick="addSong3()">保存</button>
            <button style="margin-top: 20px;width: 80px" class="btn btn-lg btn-primary" onclick="tab4()">下一页</button>
            <button style="margin-top: 20px;width: 80px" class="btn btn-lg btn-primary" onclick="empty()">清空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none" id="ttab4">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <h1 style="margin-top: 40px">选择歌姬</h1>
            <select class="form-control input-lg"  id="singerSelect" onchange="singerSelect()">
            </select>
            <input type="text" class="form-control input-lg" id="singerUnlock" placeholder="熟练度解锁方式" style="margin-top: 20px">
            <button style="margin-top: 20px;width: 80px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">首页</button>
            <button style="margin-top: 20px;width: 150px" class="btn btn-lg btn-primary" onclick="addSong4()">保存</button>
            <button style="margin-top: 20px;width: 150px" class="btn btn-lg btn-primary" onclick="empty()">清空</button>
        </div>
    </div>

</div>
<script type="text/javascript">
    var allOpus;
    var allAttribute;
    var allDiff;
    var allSinger;
    var songID ;
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
            url:strQueryAllDiff,
            dataType:'json',
            async:false,
            success:function(data){
                allDiff =data.res;
                var strHtml="<option value='0'></option>";
                for(i=0;i<allDiff.length;i++){
                    strHtml+="<option value='"+allDiff[i].diff_ID+"'>"+allDiff[i].diff_Diff+"</option>"
                }
                $("#diffSelect").html(strHtml);
            }
        });
        $.ajax({
            url:strQueryAllSinger,
            dataType:'json',
            async:false,
            success:function(data){
                allSinger =data.res;
                var strHtml="<option value='0'></option>";
                for(i=0;i<allSinger.length;i++){
                    strHtml+="<option value='"+allSinger[i].singer_ID+"'>"+allSinger[i].singer_Name+"</option>"
                }
                $("#singerSelect").html(strHtml);
            }
        })
    }
    function addSong1(){
        var songname = $("#addSongName").val()
        var songIMG = $("#addSongIMG").val();
        var songsinger = $("#addSongSinger").val();
        $.ajax({
            url:strAddSong,
            dataType:'json',
            data:{
                songname:songname,
                songIMG:songIMG,
                songsinger:songsinger
            },
            success:function(data){
                songID=data.res;
                tab2();
            }
        })
    }
    function addSong2(){
        var opus=$("#opusSelect option:selected").val();
        var attr=$("#attrSelect option:selected").val();
        $.ajax({
            url:strAddSongOpusAttr,
            dataType:'json',
            data:{
                songID:songID,
                opus:opus,
                attr:attr
            },
            success:function(data){
                tab3()
            }
        })

    }
    function addSong3(){
        var diff=$("#diffSelect option:selected").val()
        var songRank = $("#songRank").val();
        var songFCNum = $("#songFCnum").val();
        var songUnlock = $("#songUnlock").val();
        $.ajax({
            url:strAddSongDiff,
            dataType:'json',
            data:{
                songID:songID,
                diff:diff,
                songRank:songRank,
                songFCNum:songFCNum,
                songUnlock:songUnlock
            },
            success:function(data){
            }
        })
    }
    function addSong4(){
        var singer=$("#singerSelect option:selected").val()
        var singerUnlock = $("#singerUnlock").val();
        $.ajax({
            url:strAddSongSinger,
            dataType:'json',
            data:{
                songID:songID,
                singer:singer,
                singerUnlock:singerUnlock
            },
            success:function(data){
            }
        })
    }
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
    function empty(){
        $("#addSongName").val("");
        $("#addSongSinger").val("");
        $("#addSongIMG").val("");
    }
</script>
</body>
</html>
