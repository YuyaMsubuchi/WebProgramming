<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="css/Stylesheet.css" rel="Stylesheet" >
</head>

<body>
<div class="header">
</div>

<div class="main">

<div class="tite">
<h1>ログイン画面</h1>
</div>
<form action ="login" method="post">
<div class="form">
<ul>
<li class="ID">
<label for="ID">ログインID</label>
 <input type="text" name="loginId" id="inputLoginId" class="waku" style="width:263px;">
</li>


<li class="pass">
<label for="pass">パスワード</label>
<input type="text"name="password" id="inputPassword" class="waku" style="width:263px;">
</li>
</ul>
<input type="submit" value="ログイン"  class="hoge">


</div>
</form>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
</div>


</body>
</html>