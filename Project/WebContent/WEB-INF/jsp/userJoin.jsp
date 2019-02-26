<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/Stylesheet.css" rel="Stylesheet" >
<title>ユーザ新規登録</title>

</head>
<body>
<div class="header">

<a href="logout" class="logout">ログアウト</a>
<a href="logout" class="user">${userInfo.name} さん</a>
</div>
<div class="main">

<div class="title">
<h1>ユーザ新規登録</h1>

</div>
<form action="UserJoin" method="post">
<div class="form">
<ul>
<li class="ID">
<label for="ID">ログインID</label>
 <input type="text" name="loginId" class="waku" style="width:263px;">
</li>
<li class="pass">
<label for="pass">パスワード</label>
 <input type="text" name="password" class="waku" style="width:263px;">
</li>
<li class="pass1">
<label for="pass1">パスワード(確認)</label>
<input type="text" class="waku" style="width:263px;">
</li>
<li class="name">
<label for="name">ユーザ名</label>
<input type="text" name="name" class="waku" style="width:263px;">
</li>
<li class="date">
<label for="date">生年月日</label>
<input type="date" name="birthDate" max="9999-12-31" class="toshi" style="width:263px;">
</li>

</ul>

<input type="submit" value="登録" class="hoge">

</div>
</form>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
</div>
<div class="back">
<a href="UserList">戻る</a>
</div>
</body>
</html>