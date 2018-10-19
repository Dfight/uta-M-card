<%@ page import="uta.macross.entry.singer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            添加技能
        </p>
    </div>
    <div class="col-md-6 tabDiv" onclick="edit()" id="editTab">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            修改技能
        </p>
    </div>
    <div class="loginDIV" style="margin-top: 35px" id="addSkill">
        <div style="text-align: center" class="col-md-10 col-md-offset-1">
            <div class="col-md-4" style="padding-left: 0px">
                <select class="form-control input-lg" id="Skill_Pos" onchange="changePos()" style="margin-top: 30px">
                    <option value="0"></option>
                    <option value="1">Center</option>
                    <option value="2">Action</option>
                    <option value="3">Live</option>
                </select>
            </div>
            <div class="col-md-8" style="padding-right: 0px">
                <select class="form-control input-lg" id="Skill_Type" style="margin-top: 30px" onchange="isOther()">
                </select>
            </div>
            <div class="col-md-4" style="padding-left: 0px">
                <select class="form-control input-lg" id="Skill_LV">
                    <option value="0"></option>
                    <option value="1">S</option>
                    <option value="2">A</option>
                    <option value="3">B</option>
                    <option value="4">C</option>
                </select>
            </div>
            <div class="col-md-8" style="padding-right: 0px">
                <input type="text" class="form-control input-lg" id="otherType" placeholder="类型" style="visibility: hidden">
            </div>
            <input type="text" class="form-control input-lg" id="Skill_J" placeholder="技能描述(日语)" style="margin-top: 150px">
            <input type="text" class="form-control input-lg" id="Skill_C" placeholder="技能描述(中文)(可不填)" style="margin-top: 30px">
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="addSkill()">添加技能</button>
            <button style="margin-top: 30px;width: 110px" class="btn btn-lg btn-primary" onclick="  empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none" id="editSkill">
        <div style="text-align: center">
            <div style="text-align: center" class="col-md-8 col-md-offset-2">
                <select class="form-control" id="editSelect" onchange="changeSelect()">
                </select>
                <input type="text" class="form-control input-lg" id="editSingerName" placeholder="歌姬姓名" style="margin-top: 20px">
                <input type="text" class="form-control input-lg" id="editSingerIMG" placeholder="歌姬图片(圆)" style="margin-top: 20px">
                <input type="text" class="form-control input-lg" id="editSingerIMG1" placeholder="歌姬图片(方)" style="margin-top: 20px">
                <select class="form-control input-lg" id="opusSelect1" style="margin-top: 20px">
                </select>
                <button style="margin-top: 33px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
                <button style="margin-top: 33px;width: 110px" class="btn btn-lg btn-primary" onclick="editSkill()">修改技能</button>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    var allOpus;
    var allSinger;
    window.onload=function(){
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
                $("#editSelect").html(strHtml);
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
                $("#opusSelect1").html(strHtml);
            }
        });
    }
    function changeSelect(){
        var a = $("#editSelect option:selected").val();
        for(i=0;i<allSinger.length;i++) {
            if (a == allSinger[i].singer_ID) {
                $("#editSingerName").val(allSinger[i].singer_Name);
                $("#editSingerIMG").val(allSinger[i].singer_IMG);
                $("#editSingerIMG1").val(allSinger[i].singer_IMG1);
                $.ajax({
                    url: strGetOpusBySingerID,
                    dataType: 'json',
                    data: {id: a},
                    async: false,
                    success: function (data) {
                        $("#opusSelect1").val(data.Opus_ID);
                    }
                })
            }
        }
    }
    function add(){
        $("#addTab").removeClass("tabDiv");
        $("#editTab").removeClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv");
        $("#addSkill").css("display","block");
        $("#editSkill").css("display","none");
    }
    function edit(){
        $("#editTab").removeClass("tabDiv");
        $("#addTab").removeClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv");
        $("#addSkill").css("display","none");
        $("#editSkill").css("display","block");
    }
    function empty(){

    }
    function addSkill(){
        $.ajax({
            url:strAddSkill,
            dataType: 'json',
            data:{
                pos:$("#Skill_Pos option:selected").text(),
                type:$("#Skill_Type option:selected").val(),
                otherType:$("#otherType").val(),
                lv:$("#Skill_LV option:selected").text(),
                skill_J:$("#Skill_J").val(),
                skill_C:$("#Skill_C").val(),
            },
            async: false,
            success: function (data) {

            }
        })
    }
    function editSkill(){
        alert("尽请期待")
    }
    function changePos(){
        var pos = $("#Skill_Pos option:selected").text();
        $.ajax({
            url:strGetSkillTypeByPos,
            dataType:'json',
            async:false,
            data:{
                pos:pos
            },
            success:function(data){
                var strHtml="<option value='0'></option>";
                for(i=0;i<data.res.length;i++){
                    strHtml+="<option value='"+data.res[i].id+"'>"+data.res[i].type+"</option>"
                }
                strHtml+="<option value='99999'>其他</option>"
                $("#Skill_Type").html(strHtml);
                $("#otherType").val("");
                $("#otherType").css('visibility','hidden');
            }
        });
    }
    function isOther(){
        if($("#Skill_Type").val()==99999){
            $("#otherType").css('visibility','visible')
        }else{
            $("#otherType").css('visibility','hidden')
        }
    }
</script>
</body>
</html>
