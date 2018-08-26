<%@ page import="java.util.List" %>
<%@ page import="com.nf.bookstore1.entity.Book" %>
<%@ page import="util.WebUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>图书列表</title>
    <link rel="stylesheet" href="../assets/css/bootstrap.css"/>
    <link rel="stylesheet" href="../assets/css/dashboard.css"/>
    <style>
        @-webkit-keyframes fadeIn {
            0% {
                opacity: 0; /*初始状态 透明度为0*/
            }
            50% {
                opacity: 0; /*中间状态 透明度为0*/
            }
            100% {
                opacity: 1; /*结尾状态 透明度为1*/
            }
        }

        table {
            padding: 5px 1em;
            border-collapse: collapse;
            -webkit-animation-name: fadeIn; /*动画名称*/
            -webkit-animation-duration: 1s; /*动画持续时间*/
            -webkit-animation-iteration-count: 1; /*动画次数*/
            -webkit-animation-delay: 0s; /*延迟时间*/
        }
    </style>
</head>
<body>

<%= WebUtil.popSessionMsg(request) %>

<form action="/book/del" method="post">
    <table class="table table-striped" id="tab">
        <tr>
            <th><input type="checkbox" onclick="alls(this)"></th>
            <th>id</th>
            <th>产品名称</th>
            <th>价钱</th>
            <th>上市时间</th>
            <th>销量</th>
            <th>库存</th>
            <th>图片地址</th>
            <th>操作</th>
        </tr>
        <%-- jstl+EL<%
             List<Book> books = (List<Book>) request.getAttribute("books");
             pageContext.setAttribute("bs", books);
         %>--%>
        <%--<c:forEach var="books" items="${requestScope.books}">
            <tr>
                <td><input name="id" value="<c:out value="${books.id}"/>" type="checkbox"></td>
                <td><c:out value="${books.id}"/>
                </td>
                <td><a href="book/detail?id=<c:out value="${books.id}"/>"><c:out value="${books.name}"/>
                </a></td>
                <td><c:out value="${books.price}"/>
                </td>
                <td><c:out value="${books.author}"/>
                </td>
                <td><c:out value="${books.press}"/>
                </td>
                <td>

                    <a href="/book/del?id=<c:out value="${books.id}"/>">删除</a>
                    <a data-toggle="modal" href="#myModal" data-id="${books.id}">更新</a>
                </td>
            </tr>
        </c:forEach>--%>
    </table>

    <div style="margin-top: 2em;">
        <input type="submit" value="删除" class="btn btn-success">
        <a href="/book/add">增加新的书籍</a>
        <br/>
        <br/>
        <!-- Button trigger modal -->
    </div>

</form>
<%@include file="book_update_modal.jsp" %>
<div id="ck">
    <input type="checkbox" value="苹果">苹果
    <input type="checkbox" value="三星">三星
    <input type="checkbox" value="华为">华为
    <br/>
    <button type="button" onclick="choice()">我的选择</button>
</div>
<script>
    function choice() {
        var ckboxs = $("#ck input[type=checkbox]");
        var str = " ";
        var space_mark = "";
        ckboxs.each(function (index, ele) {
            if (ele.checked) {
                str += space_mark + ele.value;
                space_mark = "、";
            }
        })
        console.log(str);
    }
    var list = function () {
        $.ajax({
            type: "post",
            url: "/phone.html",
            success: function (data) {
                $("#tab tr:gt(0)").remove();
                $.each(data, function (index, da) {
                    var tr = "<tr>";
                    tr += "<td><input name='id' value=" + da.id + " type='checkbox'></td>";
                    tr += "<td>" + da.id + "";
                    tr += "</td>";
                    tr += "<td><a href='/book/detail?id=" + da.id + "'>" + da.name + "";
                    tr += "</a></td>";
                    tr += " <td>" + da.price + "</td>";
                    tr += "<td>" + da.dateTime + "</td>";
                    tr += "<td>" + da.salesvolume + "</td>";
                    tr += "<td>" + da.inventory + "</td>";
                    tr += "<td>" + da.picture + "</td>";
                    tr += "<td>";
                    tr += " <a onclick='return deleteBook()' href='/phone/del?id=" + da.id + "'>删除</a>";
                    tr += "<a  data-toggle='modal' href='#myModal' data-id=" + da.id + ">更新</a>";
                    tr += " </td>";
                    tr += "  </tr>";
                    $("#tab").append(tr);
                })
            }, error: function (xhr, textStatus, errorThrown) {
                alert("原生ajax：" + xhr + textStatus + "详细错误：" + errorThrown);
            }
        });
    };
    list();

    function deleteBook() {
        if (confirm("您确定要删除吗？")) {
            return true;
        } else {
            return false;
        }
    }

    function alls(e) {
        var checkboxs = document.getElementsByName("id");
        for (var i = 0; i < checkboxs.length; i++) {
            checkboxs[i].checked = e.checked
        }
    }

    document.querySelector("#booklist").classList.add("active");
</script>
</body>
</html>
