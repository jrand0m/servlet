
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hi ${sex} ${name}!!!</h2>
<form action="/servlet_war_exploded/home" method="get"> <%--разобраться со ссылкой--%>
    <%--//servlet_war_exploded/home--%>
    <input type="text" name="sex" placeholder="sex">
    <input type="text" name="name" placeholder="name">

    <input type="submit" name="" placeholder="">
</form>

<form action="/servlet_war_exploded" method="post">
<input type="text" name="name" placeholder="name">
<input type="text" name="sex" placeholder="sex">

<input type="submit" name="" placeholder="">
</form>

${list}

</body>
</html>
