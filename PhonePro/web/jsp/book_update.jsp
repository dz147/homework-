<%@ page import="com.nf.bookstore1.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍修改表单</title>
</head>
<body>

<% Book book = (Book) request.getAttribute("book"); %>

<form action="/book/update" method="post">
    <div><input type="text" name="name" placeholder="name" value="<%= book.getName()%>"></div>
    <div><input type="number" step="0.01" name="price" placeholder="price" value="<%= book.getPrice()%>"></div>
    <div><input type="text" name="author" placeholder="author" value="<%= book.getAuthor()%>"></div>
    <div><input type="text" name="press" placeholder="press" value="<%= book.getPress()%>"></div>
    <div><input type="hidden" name="id" value="<%= book.getId()%>"></div>

    <div><input type="submit" value="提交更新"></div>
</form>

</body>
</html>
