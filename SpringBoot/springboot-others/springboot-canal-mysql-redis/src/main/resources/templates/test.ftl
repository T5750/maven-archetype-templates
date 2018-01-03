<#assign contextPath=springMacroRequestContext.getContextPath() />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>缓存配置平台</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="http://cdn.bootcss.com/datatables/1.10.11/css/dataTables.bootstrap.min.css" rel="stylesheet"
          media="screen">
    <style type="text/css">
        body {
            overflow: auto;
            background-color: #F1F2F7;
            min-width: 1150px;
        }

        * {
            padding: 0;
            margin: 0;
        }

        .table-dialog tr th {
            width: 40%;
        }

        .table-dialog tr td input {
            width: 80%;
        }
        .dataTables_filter input{
            height: 30px;
            border: 1px solid #F1F2EF;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/" style="color:#F1F2F7">&nbsp;&nbsp;医生端缓存配置平台</a>
        </div>
    </div>
</nav>
<br>
<br>
<br>
<div class="container">
    <div class="row">
        <div>
            <div class="container-fluid">
                <table class="table table-striped table-bordered" id="datatable">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>表名</th>
                        <th>缓存key</th>
                        <th>
                            <button type="button" class="btn btn-primary btn-sm btn-add" data-toggle="modal"
                                    data-backdrop="static">新增
                            </button>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list list as bean>
                    <tr>
                        <td>${bean_index+1}</td>
                        <td>${bean.tableName!}</td>
                        <td>${bean.cacheKey!}</td>
                        <td>
                            <button type="button" class="btn btn-warning btn-xs" onclick="alterf('${bean.tableName}')">
                                修改
                            </button>
                            <button type="button" class="btn btn-danger btn-xs" onclick="deletef('${bean.tableName}')">
                                删除
                            </button>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<form action="/alter" method="post" modelAttribute="bean" id="modalform">
    <div class="modal fade bs-example-modal-sm" id="myModal_02" tabindex="-1" role="dialog"
         aria-labelledby="mySmallModalLabel">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel_02">缓存配置</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-striped table-bordered table-dialog">
                        <tr>
                            <th>表名</th>
                            <td><input type="text" class="form-control required" name="tableName" id="tableName"/></td>
                        </tr>
                        <tr>
                            <th>缓存key(多个以,隔开),可用*结尾，如：com.myweimai*</th>
                            <td><input type="text" class="form-control required" name="cacheKey" id="cacheKey"/></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-info">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>
<div class="modal fade bs-example-modal-sm" id="myModal_03" tabindex="-1" role="dialog"
     aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel_03">确认删除</h4>
            </div>
            <div class="modal-body">
                <span>您真的要删除这条配置吗？</span><br/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="btn-del-true" tableName="">删除</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/2.2.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/datatables/1.10.11/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</body>
</html>
