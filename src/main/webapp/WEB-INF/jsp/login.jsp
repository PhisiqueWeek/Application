<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Войти</title>

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


        .log-window {
            display: flex;
            align-items:center;
            justify-content: space-between;
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
<div class="content">
    <div class="log-window form">
        <sec:authorize access="isAuthenticated()">
            <% response.sendRedirect("/"); %>
        </sec:authorize>
        <div>
        <form  method="POST" action="/login">
            <h2>Вход в систему</h2>
            <div  class="form-center">
                <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="username" type="text" placeholder="Логин"
                       autofocus="true"/>
                <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="password" type="password" placeholder="Пароль"/>
                <button class="btn btn-outline-info" type="submit">Войти</button>
                <h6><a href="/registration">Зарегистрироваться</a></h6>
            </div>
        </form>
    </div>
</div>
</div>

</body>
</html>