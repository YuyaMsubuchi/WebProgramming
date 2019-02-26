<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/Stylesheet.css" rel="Stylesheet" >
<title>一覧</title>
</head>
<body>
<div class="header">

<a href="logout" class="logout">ログアウト</a>
<p class="user">${userInfo.name} さん</p>

</div>

<div class="main">

<div class="title">
<h1>ユーザ一覧</h1>
</div>
<div class="new">
<a href="UserJoin">新規登録</a>
</div>

<div class="form">
<form action="UserList" method="post">
<ul>
<li class="ID">
<label for="ID">ログインID</label>
 <input type="text" name="loginId" class="waku" style="width:263px;">
</li>
<li class="name">
<label for="name">ユーザ名</label>
 <input type="text" name="name" class="waku" style="width:263px;">
</li>
<li class="date">
<label for="date">生年月日</label>
<input type="date" name="birthDate1" max="9999-12-31" class="toshi"> ~ <input type="date" name="birthDate2" max="9999-12-31" class="toshi">
</li>
</ul>
<div class="hako">
<input type="submit" value="検索" class="hoge">
</div>
</form>
</div>

<hr>


<table >
 <thead>
<tr>
<th>ログインID</th><th>ユーザ名</th><th>生年月日<th>　　　　　　　　　　　　</th>
</tr>
 </thead>
 <tbody>
 <c:forEach var="user" items="${userList}" >
<tr>
      <td>${user.loginId}</td><td>${user.name}</td><td>${user.birthDate}</td>
<td>
 <c:if test='${userInfo.loginId.equals("admin") }' >
      <a class="shosai" href="UserRead?id=${user.id}">詳細</a>
      <a class="kosin" href="UserRe?id=${user.id}">更新</a>
      <a class="sakuzixyo" href ="UserDe?id=${user.id}">削除</a>
</c:if>
<c:if test='${!userInfo.loginId.equals("admin") }' >
      <a class="shosai" href="UserRead?id=${user.id}">詳細</a>
<c:if test='${userInfo.loginId.equals(user.loginId) }'>
      <a class="kosin" href="UserRe?id=${user.id}">更新</a>
</c:if>
</c:if>

</td>
</tr>
</c:forEach>
</tbody>
</table>



</div>


</body>
</html>