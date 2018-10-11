<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"; %>

<!DOCTYPE html>
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
<body class="background">
<div class="col-md-4 col-md-offset-4 loginDIV" style="min-height: 30px" onclick="common1()">
    <h4 style="line-height: 50px;display: inline">基础属性设置</h4>
    <span class="caret" style="float: right;margin-top: 25px;"></span>
</div>
<div id="common" style="display: none" class="col-md-4 col-md-offset-4">
    <div class="col-md-11 col-md-offset-1 commonDIV" onclick="ToSinger()">
        <h4 style="line-height: 50px;display: inline">添加/修改歌姬</h4>
    </div>
    <div class="col-md-11 col-md-offset-1 commonDIV"  onclick="ToOpus()">
        <h4 style="line-height: 50px;display: inline">添加/修改作品</h4>
    </div>
    <div class="col-md-11 col-md-offset-1 commonDIV"  onclick="ToAttribute()">
        <h4 style="line-height: 50px;display: inline">添加/修改属性</h4>
    </div>
    <div class="col-md-11 col-md-offset-1 commonDIV" onclick="ToDifficult()">
        <h4 style="line-height: 50px;display: inline">添加/修改难度</h4>
    </div>
    <div class="col-md-11 col-md-offset-1 commonDIV" onclick="ToSkill()">
        <h4 style="line-height: 50px;display: inline">添加/修改技能</h4>
    </div>
</div>
<div class="col-md-4 col-md-offset-4 loginDIV" style="min-height: 30px;margin-top: 0px" onclick="common2()">
    <h4 style="line-height: 50px;display: inline">歌曲设置</h4>
    <span class="caret" style="float: right;margin-top: 25px;"></span>
</div>
<div id="song" style="display: none" class="col-md-4 col-md-offset-4">
    <div class="col-md-11 col-md-offset-1 commonDIV" onclick="ToAddSong()">
        <h4 style="line-height: 50px;display: inline">添加歌曲</h4>
    </div>
    <div class="col-md-11 col-md-offset-1 commonDIV"  onclick="ToEditSong()">
        <h4 style="line-height: 50px;display: inline">修改歌曲</h4>
    </div>
</div>
<div class="col-md-4 col-md-offset-4 loginDIV" style="min-height: 30px;margin-top: 0px" onclick="common3()">
    <h4 style="line-height: 50px;display: inline">飞机/服装设置</h4>
    <span class="caret" style="float: right;margin-top: 25px;"></span>
</div>
<div id="F_C" style="display: none" class="col-md-4 col-md-offset-4">
    <div class="col-md-11 col-md-offset-1 commonDIV" onclick="ToFighter()">
        <h4 style="line-height: 50px;display: inline">添加/修改飞机</h4>
    </div>
    <div class="col-md-11 col-md-offset-1 commonDIV" onclick="ToClothing()">
        <h4 style="line-height: 50px;display: inline">添加/修改衣服</h4>
    </div>
</div>
<div class="col-md-4 col-md-offset-4 loginDIV" style="min-height: 30px;margin-top: 0px" onclick="common4()">
    <h4 style="line-height: 50px;display: inline">卡面属性设置</h4>
    <span class="caret" style="float: right;margin-top: 25px;"></span>
</div>
<div id="card" style="display: none" class="col-md-4 col-md-offset-4">
    <div class="col-md-11 col-md-offset-1 commonDIV" onclick="ToAddCard()">
        <h4 style="line-height: 50px;display: inline">添加卡</h4>
    </div>
</div>
<script type="text/javascript">
    function common1() {
        $("#song").slideUp();
        $("#F_C").slideUp();
        $("#card").slideUp();
        $("#common").slideDown();

    }
    function common2() {
            $("#common").slideUp();
            $("#F_C").slideUp();
            $("#card").slideUp();
            $("#song").slideDown();
    }
    function common3() {
        $("#song").slideUp();
        $("#common").slideUp();
        $("#card").slideUp();
        $("#F_C").slideDown();
    }
    function common4() {
        $("#song").slideUp();
        $("#common").slideUp();
        $("#F_C").slideUp();
        $("#card").slideDown();
    }
    function ToAddCard() {
        window.location.href= strToAddCard;
    }
    function ToFighter() {
        window.location.href= strToFighter;
    }
    function ToClothing() {
        window.location.href= strToClothing;
    }
    function ToAddSong(){
        window.location.href= strToAddSong;
    }
    function ToEditSong(){
        window.location.href= strToEditSong;
    }
    function ToSinger(){
        window.location.href= strToSinger;
    }
    function ToOpus(){
        window.location.href= strToOpus;
    }
    function ToAttribute(){
        window.location.href= strToAttribute;
    }
    function ToDifficult(){
        window.location.href= strToDifficult;
    }
    function ToSkill(){
        window.location.href= strToSkill;
    }
</script>
</body>
</html>