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
    <script type="text/javascript" src="<%=path%>static/js/vue.min.js"></script>
    <link rel="stylesheet" type="text/css"  href="<%=path%>static/font-awesome/css/font-awesome.min.css">
</head>
<body  class="background">
<div class="col-md-8 col-md-offset-2" >
    <div class="cardDiv" style="margin-top: 35px;min-height: 200px;height: 400px">
        <div style="text-align: center;padding-top:20px" id="fighter">
            <h1 style="display: none" id="fighterID">{{ID}}</h1>
            <h1>{{name}}</h1>
            <img :src="img" style="margin-top: -150px;margin-bottom: -170px">
        </div>
        <div id="opus"></div>
    </div>
</div>
<div class="col-md-offset-3 col-md-6">

    <button style="margin-top: 30px;width: 33%" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
    <button style="margin-top: 30px;width: 65%" class="btn btn-lg btn-primary" onclick="bind()">绑定</button>
</div>

<script type="text/javascript">
    var allOpus;
    var img = "https://cdn-image.pf.dena.com/fa9c327e33426cd5e3dff097aa3feee754c90f9a/1/";//图片文件前缀
    var fighter = new Vue({
       el:"#fighter",
       data:{
           ID:"",
           name:"",
           img:""
       }
    });
    window.onload=function(){
        $.ajax({
            url:strQueryAllOpus,
            dataType:'json',
            async:false,
            success:function(data){
                allOpus =data.res;
                var strHtml="";
                for(i=0;i<allOpus.length;i++){
                    strHtml+="<img id='"+allOpus[i].opus_ID+"' name='"+allOpus[i].opus_Name+"' src='"+img+allOpus[i].opus_IMG+"' class='opusSelect col-md-3 gray' onclick='gray(this)'>";
                }
                $("#opus").html(strHtml);
            }
        });
        getFighter();
    }
    function getFighter() {
        $.ajax({
            url:strGetNoOpusFighter,
            dataType:'json',
            async:false,
            success:function(data){
                if (data.fighter==null){
                    fighter.ID = "";
                    fighter.name ="";
                    fighter.img = "";
                    alert("没有未分类的飞机")
                }else{
                    fighter.ID = data.fighter.Fighter_ID;
                    fighter.name = data.fighter.Fighter_Name;
                    fighter.img = img+data.fighter.Fighter_IMG;
                }

            }
        });
    }
    function gray(e){
        $(".opusSelect").addClass("gray");
        $(e).removeClass("gray");
    }
    function bind() {
        var opusID= new Array();
        $(".opusSelect").each(function(){
            if(!$(this).hasClass("gray")) {
                opusID.push($(this).attr("id"));
            }
        })
        var fighterID = $("#fighterID").text();
        if(opusID[0]==undefined){
            alert("请选择作品");
        }
        $.ajax({
            url:strBindFighterOpus,
            dataType:'json',
            async:false,
            data:{
                fighter:fighterID,
                opus:opusID[0]
            },
            success:function(data){
                getFighter();
                $(".opusSelect").addClass("gray");
            }
        });
    }
</script>
</body>
</html>
