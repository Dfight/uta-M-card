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
            添加属性
        </p>
    </div>
    <div class="col-md-6 tabDiv" onclick="edit()" id="editTab">
        <p style="text-align: center;font-size: 20px;margin-top: 10px">
            修改属性
        </p>
    </div>
    <div class="loginDIV" style="margin-top: 35px" id="addAttr">
        <div style="text-align: center" class="col-md-8 col-md-offset-2">
            <input type="text" class="form-control input-lg" id="addAttrName" placeholder="属性名称" style="margin-top: 100px">
            <input type="text" class="form-control input-lg" id="addAttrIMG" placeholder="属性图标" style="margin-top: 50px">
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="addAttr()">添加属性</button>
            <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="empty()">清&nbsp;&nbsp;&nbsp;&nbsp;空</button>
        </div>
    </div>
    <div class="loginDIV" style="margin-top: 35px;display: none" id="editAttr">
        <div style="text-align: center">
            <div style="text-align: center" class="col-md-8 col-md-offset-2">
                <select class="form-control" id="editSelect" onchange="changeSelect()">
                </select>
                <input type="text" class="form-control input-lg" id="editAttrName" placeholder="属性名称" style="margin-top: 100px">
                <input type="text" class="form-control input-lg" id="editAttrIMG" placeholder="属性图标" style="margin-top: 50px">
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="window.location.href='/uta-macross/view/toMain'">返回首页</button>
                <button style="margin-top: 50px;width: 110px" class="btn btn-lg btn-primary" onclick="editAttr()">修改属性</button>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
    var allAttribute;
    window.onload=function(){
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
                $("#editSelect").html(strHtml);
            }
        })
    }
    function changeSelect(){
        var a = $("#editSelect option:selected").val();
        for(i=0;i<allAttribute.length;i++){
            if (a==allAttribute[i].attr_ID){
                $("#editAttrName").val(allAttribute[i].attr_Name);
                $("#editAttrIMG").val(allAttribute[i].attr_IMG);

            }
        }
    }
    function add(){
        $("#addTab").removeClass("tabDiv");
        $("#editTab").removeClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv");
        $("#addAttr").css("display","block");
        $("#editAttr").css("display","none");
    }
    function edit(){
        $("#editTab").removeClass("tabDiv");
        $("#addTab").removeClass("tabDiv-sel");
        $("#editTab").addClass("tabDiv-sel");
        $("#addTab").addClass("tabDiv");
        $("#addAttr").css("display","none");
        $("#editAttr").css("display","block");
    }
    function empty(){
        $("#addAttrName").val("");
        $("#addAttrIMG").val("");
    }
    function addAttr(){
        var attrName = $("#addAttrName").val();
        var attrIMG = $("#addAttrIMG").val();
        $.ajax({
            url:strAddAttr,
            data:{
                attrName:attrName,
                attrIMG:attrIMG
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
    function editAttr(){
        alert("尽请期待")
    }
</script>
</body>
</html>
