<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <#--<link href="css/bootstrap.css" rel="stylesheet"/>-->
		<link href="https://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.css" rel="stylesheet">
        <link href="css/app.css" rel="stylesheet"/>
    </head>
    <body>

        <div ui-view></div>
        <#--<script src="js/lib/angular.min.js" ></script>-->
        <script src="https://cdn.bootcss.com/angular.js/1.5.8/angular.min.js" ></script>
        <#--<script src="js/lib/angular-ui-router.min.js" ></script>-->
		<script src="https://cdn.bootcss.com/angular-ui-router/0.3.1/angular-ui-router.min.js"></script>
        <#--<script src="js/lib/localforage.min.js" ></script>-->
		<script src="https://cdn.bootcss.com/localforage/1.4.2/localforage.min.js"></script>
        <#--<script src="js/lib/ngStorage.min.js"></script>-->
		<script src="https://cdn.bootcss.com/ngStorage/0.3.10/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/UserService.js"></script>
        <script src="js/app/UserController.js"></script>
    </body>
</html>