<%-- リスト10-17の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User,model.Mutter,java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
// アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList =
(List<Mutter>) request.getAttribute("mutterList");
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="/docoTsubu3/Logout">ログアウト</a>
</p>
<p><a href="/docoTsubu3/Main">更新</a></p>
<form action="/docoTsubu3/Search" method="get">
<input type="text" name="keyword">
<input type="submit" value="検索">
</form>
<form action="/docoTsubu3/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList){%>
<p><%=mutter.getId()%>:<%=mutter.getUserName()%>：<%=mutter.getText()%></p>
<a href="/docoTsubu3/UpdateMutter?id=<%=mutter.getId()%>">編集</a>
<a href="/docoTsubu3/DeleteMutter?id=<%=mutter.getId()%>">削除</a>
<% } %>
</body>
</html>