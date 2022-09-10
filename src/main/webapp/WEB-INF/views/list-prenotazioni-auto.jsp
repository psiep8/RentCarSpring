<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
    <form action="listPrenotazioni" method="GET">

        <h1 align="center"><b>Lista prenotazioni di ${auto.marca} ${auto.modello}:</b></h1>
        </br></br>
        <table border="1" cellpadding="5">
            <tr>
                <th>Data Inizio</th>
                <th>Data Fine</th>
                <th>Customer</th>
            </tr>

            <tr>
                <c:forEach var="pren" items="${prenotazioni}">
                <th><c:out value="${pren.dataInizio}"/></th>
                <th><c:out value="${pren.dataFine}"/></th>
                <th><c:out value="${pren.utente.nome}"/>
                    <c:out value="${pren.utente.cognome}"/></th>
            </tr>
            </c:forEach>
    </form>
    </table>


</div>
