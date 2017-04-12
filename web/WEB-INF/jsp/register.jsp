<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src='<c:url value="/resources/script.js"/>'></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" ></c:url>" >

</head>
<body>
<header>
    <div onclick="myFun3()" id="divmenu"><img src="<c:url value="/resources/menu.png" />"></div>
    <div><img src="http://www.wopr.tarnow.pl/wp-content/uploads/2012/12/WOPR.png"></div>
</header>
<nav id="navMain">
    <ul>
        <li>Jak pomagać?</li>
        <li>Mapa AED</li>
        <li>Rejestracja</li>
        <li>Ustawienia</li>
        <li>Pomoc</li>
    </ul>
</nav>


    <section id="sectionMainContent3">
    <div id="divFormTitle">Podaj dane:</div>
    <form:form method="POST" modelAttribute="register"> <br>
        <form:input type="text" path="name"  name="name"  label="name" /> <br>
        <form:input type="text" path="surname"  name="surname"  label="surname" /> <br>
        <form:input type="text" path="username"  name="username"  label="username" /> <br>
        <form:input type="text" path="pesel"  name="pesel"  label="pesel" /> <br>
        <form:input type="text" path="password"  name="password"  label="password" /> <br>
        <input type="submit" value="Wyślij">
    </form:form>
</section>

</body>
</html>
