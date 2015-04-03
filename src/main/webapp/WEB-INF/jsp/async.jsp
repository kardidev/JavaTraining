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
  <script type="text/javascript" src="/WEB-INF/js/jquery-2.1.3.min.js"></script>
</head>
<body>


<label id="label"></label>
<input type="button" value="Request" onclick="sendRequest();">

<script>
  function sendRequest() {
    $.ajax({
        type: 'POST',
        url: '/async-servlet-api',
        data: '',
    success: function(data){
      $('#label').text(data);
    },
    error: function(data){
      $('#label').text(data);
    }
  });

  }
</script>

</body>
</html>
