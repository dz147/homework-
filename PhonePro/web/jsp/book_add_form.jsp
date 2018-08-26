<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加产品</title>
    <meta name="subtitle" content="新增产品">
</head>
<body>

<form action="/phone/add" method="post">
    <div class="form-group">
        <label for="name">产品名字</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="name">
    </div>
    <div class="form-group">
        <label for="price">产品价格</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="price">
    </div>
    <div class="form-group">
        <label for="de">上市时间</label>
        <input type="date" class="form-control" id="de" name="de" placeholder="date">
    </div>
    <div class="form-group">
        <label for="Salesvolume">销量</label>
        <input type="text" class="form-control" id="Salesvolume" name="Salesvolume" placeholder="Salesvolume">
    </div>
    <div class="form-group">
        <label for="inventory">库存</label>
        <input type="number" class="form-control" id="inventory" name="inventory" placeholder="inventory">
    </div>
    <div class="form-group">
        <label for="picture">图片名称</label>
        <input type="text" class="form-control" id="picture" name="picture" placeholder="picture">
    </div>
    <div><input type="submit" class="form-control"></div>
</form>

<script>
    document.querySelector("#bookadd").classList.add("active");
</script>

</body>
</html>
