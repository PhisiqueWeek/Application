<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

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


        .auth-window {
            display: flex;
            align-items:flex-end;
            justify-content: space-between;

            padding: 1rem;
            width: 350px;

            font-size: 14px;

            line-height: 40px;
            background-color: white;
            border-radius: 1rem;
        }

        .main-page {
            display: flex;
            align-items: flex-start;
            justify-content: center;
            flex-direction: column;
            gap: 2rem;

            padding: 2rem;

            background-color: white;
            border-radius: 1rem;
        }

        .form-block {
            display: flex;
            justify-content: flex-start;
            flex-direction: column;
            gap: 1rem;
        }

        .form-control {
            max-width: 300px;
        }

        .btn {
            width: 300px;
        }

        h2 {
            padding: 0;
            margin: 0;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="content">
    <sec:authorize access="!isAuthenticated()">
        <div class="auth-window">
            <h4><a href="/login">Войти</a></h4>
            <h4><a href="/registration">Зарегистрироваться</a></h4>
        </div>  
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <div class="main-page">

            <form method="POST" action="/insertProductMonkeyBars">
                <h2>Добавить новый товар(шведская стенка)</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="height" type="number" step="0.01" placeholder="Высота(см)" autofocus="true"/>
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="width" type="text" step="0.01" placeholder="Ширина(см)"/>
                     <button type="submit" class="btn btn-outline-info">Добавить</button>
                </div>
            </form>
    
            <form method="POST" action="/insertProductBall">
                <h2>Добавить новый товар(мяч)</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="type" type="text" placeholder="Тип"/>
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="volume" type="number" step="0.01" placeholder="Объём(см^3)"/>
                    <button type="button" class="btn btn-outline-info">Добавить</button>
                </div>
            </form>
    
            <form method="POST" action="/insertProductDumbell">
                <h2>Добавить новый товар(гантель)</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="weight" type="number" step="0.01" placeholder="Масса(кг)"/>
                    <button type="button" class="btn btn-outline-info">Добавить</button>
                </div>
            </form>
    
            <form method="POST" action="/insertProductHorizontalBar">
                <h2>Добавить новый товар(турник)</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="type" type="text" placeholder="Тип"/>
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="diameter" type="number" step="0.01" placeholder="Диаметр(мм)"/>
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="width" type="number" step="0.01" placeholder="Ширина(см)"/>
                    <button type="button" class="btn btn-outline-info">Добавить</button>
                </div>
            </form>
    
            <form method="POST" action="/insertProductMat">
                <h2>Добавить новый товар(мат)</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="square" type="number" step="0.01" placeholder="Площадь(см^2)"/>
                    <button type="button" class="btn btn-outline-info">Добавить</button>
                </div>
            </form>
    
            <form method="POST" action="/insertProductRope">
                <h2>Добавить новый товар(канат)</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="length" type="number" step="0.01" placeholder="Длина(см)"/>
                    <button type="button" class="btn btn-outline-info">Добавить</button>
                </div>
            </form>
    
            <div class="form-block">
                <h2>Пользователи</h2>
                <table class="table">
                    <thead>
                    <th>ID</th>
                    <th>Роль</th>
                    <th>Логин</th>
                    </thead>
                    <c:forEach items="${listOfAllUsers}" var="user">
                        <tr>
                            <td>${user.getId()}</td>
                            <td>${user.getRole()}</td>
                            <td>${user.getLogin().getId()}</td>
                        </tr>
                    </c:forEach>
                </table>
    
                <input type="button"
                        class="btn btn-outline-info"
                       value="Получить пользователей"
                       onclick="location.href='/getAllUsers'" />
            </div>
    
            <div class="form-block">
                <h2>Каталог</h2>
                <table class="table">
                    <thead>
                    <th>ID</th>
                    <th>Материал</th>
                    <th>Категория</th>
                    <th>Название товара</th>
                    <th>Цвет</th>
                    <th>Описание</th>
                    </thead>
                    <c:forEach items="${listOfCatalogue}" var="catalogue">
                        <tr>
                            <td>${catalogue.getId()}</td>
                            <td>${catalogue.getMaterial().getName()}</td>
                            <td>${catalogue.getCategory()}</td>
                            <td>${catalogue.getName()}</td>
                            <td>${catalogue.getColor()}</td>
                            <td>${catalogue.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
    
                <input type="button"
                        class="btn btn-outline-info"
                        value="Показать каталог"
                        onclick="location.href='/getCatalogue'" />
            </div>
    
    
            <form method="POST" action="/getAmountFromWarehouseByCatalogueName">
                <h2>Количество товара на складе по названию из каталога</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="name" type="text" placeholder="Название из каталога"/>
                     <button type="submit" class="btn btn-outline-info">Показать</button>
    
                    <table class="table">
                        <thead>
                        <th>Название товара</th>
                        <th>Количество</th>
                        </thead>
                        <tr>
                            <td>${catalogueName}</td>
                            <td>${warehouseAmount}</td>
                        </tr>
                    </table>
                </div>
            </form>
    
            <form method="POST" action="/getVendorNameByShipmentName">
                <h2>Имя поставщика по названию поставки</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="name" type="text" placeholder="Название поставки"/>
                     <button type="submit" class="btn btn-outline-info">Показать</button>
    
                    <table class="table">
                        <thead>
                        <th>Название поставки</th>
                        <th>Имя поставщика</th>
                        </thead>
                        <tr>
                            <td>${shipmentName}</td>
                            <td>${vendorName}</td>
                        </tr>
                    </table>
                </div>
            </form>
    
            <form method="POST" action="/getMaterialByProductName">
                <h2>Материал, из которого сделан продукт, по его названию из каталога</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="name" type="text" placeholder="Название продукта"/>
                     <button type="submit" class="btn btn-outline-info">Показать</button>
    
                    <table class="table">
                        <thead>
                        <th>Название продукта</th>
                        <th>Материал</th>
                        </thead>
                        <tr>
                            <td>${productName}</td>
                            <td>${materialName}</td>
                        </tr>
                    </table>
                </div>
            </form>
    
            <form method="POST" action="/deleteProductMat">
                <h2>Удалить товар(мат) по id</h2>
                <div class="form-block">
                    <input class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" name="matIdForDelete" type="text" placeholder="ID мата"/>
                     <button type="submit" class="btn btn-outline-info">Удалить</button>
                </div>
            </form>
    
            <h4><a href="/logout">Выйти</a></h4>
        </div>
    </sec:authorize>
</div>
</body>
</html>