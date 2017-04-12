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
<section id="sectionMainContent">
    <div onclick="myFun1();" id="buttonAlert">
        <div>S.O.S</div>
    </div>
    <div id="AlertInfo">Kliknij 3 razy, <br> aby wezwać pomoc.</div>

</section>

<section id="sectionMainContent2">
    <div id="divFormTitle">Podaj przyczynę wezwania pomocy:</div>
    <form:form method="POST" modelAttribute="user">

        <form:radiobutton onchange="myFun2()" path="message" name="characterAccident" checked="checked" value="Sinking" label="Ktoś się topi" /> <br>
        <form:radiobutton onchange="myFun2()" path="message" name="characterAccident" value="Someone" label="Widzę osobę, która się nie rusza" /> <br>
        <form:radiobutton onchange="myFun2()" path="message" name="characterAccident" value="Child" label="Nie mogę znaleźć dziecka" /> <br>
        <form:radiobutton onchange="myFun2()" path="message" name="characterAccident" value="WaterEquipment" label="Mój rower wodny / łódź utracił możliwość sterowania" /> <br>
        <form:radiobutton onchange="myFun2()" path="message" name="characterAccident" id="characterAccidentOther" value="OtherAccident" label="Inna przyczyna" /> <br>
        <form:input path="message" id="inputCharacterAccidentOther" name="characterAccident5" disabled="true"/>


        <input type="submit" value="Wyślij">
    </form:form>
</section>

</body>
</html>

