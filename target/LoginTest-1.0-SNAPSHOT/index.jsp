<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "User Dash Board" %>
</h1>
<br/>
<form action="loginsuccess.jsp" method="post">
    <div class="col-md-8 order-md-1">
    <div class="form-group">
    User ID:<input type="text" class="form-control" name="username" />
    </div>
    <br>
    <br>

    <div class="form-group">
    Password:<input type="text" class="form-control" name="password" />
    </div>
    <br>
    <br>
    <div class="form-group">
    <input type="submit" class="btn btn-secondary" value="Submit" />
    </div>
</form>
<BR>
<a href="authenticate">HomePage</a>

</div>
</body>
</html>