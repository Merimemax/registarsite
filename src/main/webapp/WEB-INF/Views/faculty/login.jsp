<%--
  Created by IntelliJ IDEA.
  User: merih
  Date: 11/19/18
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
         <%--pageEncoding="ISO-8859-1" %>--%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
    <title>Log In</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/studentCss/login.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

</head>
<body>

<h1> </h1>

<form:form modelAttribute="credentials">

   <a href="?lang=en" >English</a> | <a href="?lang=ti_ER" >Tigrigna(ትግርኛ)</a><hr>
    <h3><spring:message code="faculty.PleaseLogIn"/></h3>
    <br><br>
    <form:errors path="*" cssStyle="color: #f00;"/>
    <div class="form-group">
        <label for="exampleInputEmail1"><spring:message code="faculty.form.email"/></label>
        <form:input type="text" path="userName"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" />
        <div>
            <form:errors path="userName" cssStyle="color: #f00;"/>
        </div>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1"><spring:message code="faculty.form.password"/></label>
        <form:input type="password" path="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
        <div>
            <form:errors path="password" cssStyle="color: #f00;"/>
        </div>
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1"><spring:message code="faculty.form.rememberme"/></label>
    </div>
    <button type="submit" class="btn btn-primary"><spring:message code="faculty.submit"/></button>
</form:form>

</body>
</html>
