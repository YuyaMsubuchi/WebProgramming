<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/Stylesheet.css" rel="Stylesheet" >
<title>更新</title>

</head>
<body>
<div class="header">

<a href="logout" class="logout">ログアウト</a>
<p class="user">${userInfo.name} さん</p>
</div>
<div class="main">

<div class="title">
<h1>ユーザ情報更新</h1>

</div>

<div class="form">
<form action="UserRe" method="post">
<ul>
<li class="ID">
<label for="ID">ログインID</label>
 <p>${UserRead.loginId}</p>
 <input type="hidden" name="id" value="${UserRead.id}"  class="waku" style="width:263px;">
</li>


<li class="pass">
<label for="pass">パスワード</label>
 <input type="text" name="password"  class="waku" style="width:263px;">
</li>
<li class="pass1">
<label for="pass1">パスワード(確認)</label>
<input type="text" name="passwordC"  class="waku" style="width:263px;">
</li>
<li class="name">
<label for="name">ユーザー名</label>
<input type="text" name="name" value="${UserRead.name}" class="waku" style="width:263px;">
</li>
<li class="date">
<label for="date">生年月日</label>
<input type="text" name="birthDate" value="${UserRead.birthDate}" max="9999-12-31" class="toshi"style="width:263px;">
</li>

</ul>


<input type="submit" value="更新" class="hoge">
</form>
<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

<div class="back">
<a href="UserList">戻る</a>
</div>
</div>
</div>


</body>
</html>