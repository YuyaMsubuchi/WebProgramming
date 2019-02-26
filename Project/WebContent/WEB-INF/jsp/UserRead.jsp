<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/Stylesheet.css" rel="Stylesheet" >

<title>詳細</title>
</head>
<body>
<body>
<div class="header">

<a href="logout" class="logout">ログアウト</a>
<p class="user">${userInfo.name} さん</p>
</div>
<div class="main">

<div class="title">
<h1>ユーザ情報詳細参照</h1>

</div>

<div class="Read">
<ul>
<li class="ID">
<label for="ID">ログインID</label>
 <p>${UserRead.loginId}</p>
</li>

<li class="name">
<label for="name">ユーザー名</label>
<p>${UserRead.name}</p>
</li>

<li class="date">
<label for="date">生年月日</label>
<p>${UserRead.birthDate}</p>
</li>

<li class="dateJoin">
<label for="dateJoin">登録日時</label>
 <p>${UserRead.createDate}</p>
</li>
<li class="dateRe">
<label for="dateRe">更新日時</label>
 <p>${UserRead.createDate}</p>
</li>



</ul>
<div class="back">
<a href="UserList">戻る</a>
</div>


</div>
</div>

</body>

</body>
</html>