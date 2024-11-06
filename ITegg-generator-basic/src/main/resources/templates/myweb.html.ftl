<!DOCTYPE html>
<html>
<head>
    <title>
        it蛋代码生成器首页
    </title>
</head>
<body>
<h1>
    欢迎开始一个新的代码生成设计
</h1>
<ul>

    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>

<footer>
    ${currentYear} ITegg官网.
</footer>
</body>
</html>