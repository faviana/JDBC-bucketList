<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Bucket List</title>

    <style> table, th, td {
        border: 1px solid black;
        padding: 5px;
    }table{
        border-spaceing: 15px;
                 }
    </style>

</head>

<body background="http://static.tumblr.com/ae6q3li/OPflvk3dj/paris__esquerda.png">

<font face="cursive" color="#ffa07a"><h1 align ="center">My Bucket List</h1></font>

<form method="post" action="/configurationweb/bucket">

    <table align="center">
        <tr><td>Where To Go</td> <td><input type="text" name="where" value="<c:out value="${abucketlistItem.where}"/>"></td></tr>
        <tr><td>When To Go</td> <td><input type="text" name="when" value="<c:out value="${abucketlistItem.when}"/>"></td></tr>
        <tr><td>Budget</td> <td><input type="text" name="howMuch" value="<c:out value="${abucketlistItem.howMuch}"/>"></td></tr>
        <tr><td>ID</td> <td><input type="text" name="id" value="<c:out value="${abucketlistItem.id}"/>"></td></tr>
    </table>

    <p></p>

    <center><input type="submit" value="Save"></center>
</form>

<p></p>

<font face ="cursive" color="#87cefa"><h2 align="center">Your Journey stars with:</h2></font>

<table align="center">
    <tr><th>Edit</th><th>Where</th><th>When</th><th>Budget</th><th>ID</th><th>Delete</th></tr>

    <c:forEach items="${theBucketList}" var="bucketList">

        <tr><td><a href="/configurationweb/editbucket?id=<c:out value="${bucketList.id}"/>"><font face ="cursive">Edit</font></a> </td><td>
            <c:out value="${bucketList.where}"/></td><td>
            <c:out value="${bucketList.when}"/></td><td>
            <c:out value="${bucketList.howMuch}"/></td><td>
            <c:out value="${bucketList.id}"/></td><td>
            <a href="/configurationweb/deletebucket?delete=<c:out value="${bucketList.id}"/>"><font face="cursive">Delete</font></a></td></tr>
    </c:forEach>
</table>

</body>
</html>






