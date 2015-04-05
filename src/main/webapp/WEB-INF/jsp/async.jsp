<%--
  Created by IntelliJ IDEA.
  User: m.lysenchuk
  Date: 4/3/15
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>jQuery Async request example</title>
  <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
</head>
<body>

Send sync request - <input type="button" value="Request" onclick="sendSyncRequest();"><br/>
Send async request - <input type="button" value="Request" onclick="sendAsyncRequest();"><br/>
Send async request - <input type="button" value="Request" onclick="sendAsyncRequest2();"><br/>
<br/>
Response:&nbsp;&nbsp;&nbsp;<label id="label"></label>
<br/>
<hr/>
<br/>
<input type="button" id="ajaxBt1"  value="Update data" onclick="handleAjaxBtn1()" /> <br/>
<div id="req1Response"></div>


<script>

  function sendSyncRequest() {
    $.ajax({
      type: 'POST',
      url: 'sync-servlet-api',
      data: '',
      success: function(data){
        $('#label').text(data);
      },
      error: function(data){
        $('#label').text(data);
      }
    });

  }

  function sendAsyncRequest() {
    $.ajax({
      type: 'POST',
      url: 'async-servlet-api',
      data: '',
      success: function(data){
        $('#label').text(data);
      },
      error: function(data){
        $('#label').text(data);
      }
    });
  }

  function sendAsyncRequest2() {
    $.ajax({
      type: 'GET',
      url: 'async-servlet-api2',
      data: '',
      success: function(data){
        $('#label').text(data);
      },
      error: function(data){
        $('#label').text(data);
      }
    });
  }


  function handleAjaxBtn1(){
    var xmlhrObj = new XMLHttpRequest();
    xmlhrObj.open("POST", "http://localhost:8080/training/async-servlet-api", true);
    xmlhrObj.onreadystatechange = function(){
      if(xmlhrObj.readyState == 4 && xmlhrObj.status == 200){
        var div1 = document.getElementById("req1Response");
        div1.innerHTML = xmlhrObj.responseText;
      }
    };
    xmlhrObj.send();
  }

</script>

</body>
</html>
