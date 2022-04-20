<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&family=Rubik:wght@400;600&display=swap');

        * {
            box-sizing: border-box;
            margin: 0;
        }

        body {
            font-family: 'Rubik', sans-serif;
        }

        .content {
            background: rgb(238,174,202);
            background: radial-gradient(circle, rgba(238,174,202,1) 0%, rgba(148,187,233,1) 100%);
            padding: 3rem;
            min-height: 100vh;

            display: flex;
            justify-content: center;
            align-items: center;
            gap: 2rem;
            flex-direction: column;
        }


        .reg-window {
            display: flex;
            align-items:center;
            justify-content: center;
            flex-direction: column;

            padding: 1rem;
            width: 350px;

            font-size: 14px;

            line-height: 40px;
            background-color: white;
            border-radius: 1rem;
        }

        .form-center {
            display: flex;
            align-items:center;
            justify-content: center;
            flex-direction: column;
            gap: 0.5rem;
        }

    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>
<div class="content white">
    <div class="reg-window">
        <%--@elvariable id="credentialForm" type="mirea.Sportsinventory.entity.Credential"--%>
        <form:form class="form-center" method="POST" modelAttribute="credentialForm">
            <h2>Регистрация</h2>
            <div>
                <form:input class="btn btn-outline-info" type="text" path="id" placeholder="Логин"
                            autofocus="true"></form:input>
                <form:errors path="id"></form:errors>
                    ${credentialError}
            </div>
            <div>
                <form:input class="btn btn-outline-info" type="password" path="password" placeholder="Пароль"></form:input>
            </div>
            <div>
                <form:input class="btn btn-outline-info" type="password" path="passwordConfirm"
                            placeholder="Повторите пароль"></form:input>
                <form:errors path="password"></form:errors>
                    ${passwordError}
            </div>
            <button class="btn btn-outline-info" type="submit">Зарегистрироваться</button>
        </form:form>
        <a href="/">Главная</a>
    </div>
</div>
</body>
</html>