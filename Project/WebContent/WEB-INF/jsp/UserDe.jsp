<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/Stylesheet.css" rel="Stylesheet" >

<title>削除</title>
</head>
<body>
<body>
<div class="header">

<a href="logout" class="logout">ログアウト</a>
<p class="user">${userInfo.name} さん</p>
</div>
<div class="main">

<div class="title">
<h1>ユーザ削除</h1>

</div>

<div class="form">
<ul>
<li class="ID">
<label for="ID">ログインID</label>
 <p>ログインID:id ${UserRead.loginId} </p>
 <p>を本当に削除してよろしいでしょうか。</p>
</li>

</ul>
</div>

<div class="choice">
<ul>
<li>
<form action="UserList" method="get">
 <input type="submit" value="キャンセル" class="hoge">
 </form>
</li>
<li>
<form action="UserDe" method="post">
<input type="hidden" value="${UserRead.id}" name="id">
 <input type="submit" value="OK" class="hoge">
</form>
</li>
</ul>
</div>

</div>
</body>

</body>
</html>