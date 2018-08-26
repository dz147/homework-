<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="/book/update" method="post" class="form-horizontal">
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">更新书籍信息</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="bookId" class="col-sm-2 control-label">ID</label>
                        <div class="col-sm-10">
                            <input type="text" id="bookId" class="form-control" name="id" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bookname" class="col-sm-2 control-label">书名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bookname" placeholder="书名" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bookprice" class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-10">
                            <input type="number" step="0.001" class="form-control" id="bookprice" placeholder="价格"
                                   name="price">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bookauthor" class="col-sm-2 control-label">作者</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bookauthor" placeholder="作者" name="author">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bookpress" class="col-sm-2 control-label">出版社</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="bookpress" placeholder="出版社" name="press">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div><input type="submit" class="btn btn-primary" value="提交更新"></div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>
<script>
    $("#myModal").on("show.bs.modal", function (e) {
        var x = event.target;
        var id = $(x).attr("data-id");
        $.ajax({
            type: "post",//请求的类型
            url: "/book/detail?act=lsid",//请求路径带参数
            data: {id: id}
        }).done(function (da) {
            $("#bookId").val(da.id);
            $("#bookname").val(da.name);
            $("#bookprice").val(da.price);
            $("#bookauthor").val(da.author.trim());
            $("#bookpress").val(da.press.trim());
        }).fail(function (xhr, textStatus, errorThrown) {
            alert("原生ajax：" + xhr + textStatus + "详细错误：" + errorThrown);
        }).always(function () {
            console.log("完成任务流程结束");
        })
    });
</script>
