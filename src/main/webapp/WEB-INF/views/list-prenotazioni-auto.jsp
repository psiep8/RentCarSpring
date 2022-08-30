
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
    <form action="UtenteServlet" method="POST">
        <h1 align="center"><b>Lista prenotazioni:</b></h1>
        </br></br>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Data Inizio</th>
                <th>Data Fine</th>
                <th>Customer</th>
                <th>Veicolo</th>
            </tr>

            <tr>
                <c:forEach var="pren" items="${list}">
                <th><c:out value="${pren.id}"/></th>
                <th><c:out value="${pren.dataInizio}"/></th>
                <th><c:out value="${pren.dataFine}"/></th>
                <th><c:out value="${pren.utente.nome}"/>
                    <c:out value="${pren.utente.cognome}"/></th>
                <th><c:out value="${pren.auto.marca}"/>
                    <c:out value="${pren.auto.modello}"/></th>
            </tr>
            </c:forEach>
    </form>
    </table>


</div>
