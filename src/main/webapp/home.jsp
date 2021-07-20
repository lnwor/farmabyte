<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <head>
                <meta charset="UTF-8">
                <title>Benvenuto${nomeUtente}!</title>
                <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
                <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
                <%@ include file="parts/header.jsp" %>
            </head>

            <body>
                <h2 class="hello-title">Benvenuto${nomeUtente}!</h2>
                <a href="utente">Utente</a><br />
                <div class="${hide ? 'hide' : 'show'}"><a href="logout">Logout</a></div><br />
                <div class="container">
                    <form action="home" method="post">
                        <input type="text" name="farmaco">
                        <input type="text" name="città">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Cerca</button>
                    </form>
                </div>
                <div class="results">
                    <c:forEach var="entry" items="${farmaciResult}">
                        <c:out value="${entry.key.nome}" />&emsp;
                        <c:out value="${entry.key.via}" />&emsp;
                        <c:out value="${entry.value.y.quantita > 10 ? 'disponibili' : 'in esaurimento'}" />&emsp;
                        <a href="/nuovaprenotazione?farmacia=${entry.key.id}&farmaco=${entry.value.x.nome}">prenota</a></br>
                    </c:forEach>
                </div>
            </body>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

            </html>