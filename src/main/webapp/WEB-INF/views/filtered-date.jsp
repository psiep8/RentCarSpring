<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div align="center">

    <h1 align="center"><b>Lista auto disponibili alla prenotazione:</b></h1>
    </br></br>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Marca</th>
            <th>Cilindrata</th>
            <th>Modello</th>
            <th>Prenota</th>
        </tr>
        <tr>
            <c:forEach var="auto" items="${listFiltered}">
            <th><c:out value="${auto.id}"/></th>
            <th><c:out value="${auto.marca}"/></th>
            <th><c:out value="${auto.cilindrata}"/></th>
            <th><c:out value="${auto.modello}"/></th>
            <form:form method="POST" modelAttribute="prenotazione" action="savePrenotazione">
                <form:hidden value="${inizio}" path="dataInizio"/>
                <form:hidden value="${fine}" path="dataFine"/>
                <form:hidden path="id_auto" value="${auto.id}"/>
                <td colspan="2" align="center">
                    <input type="submit"></td>
            </form:form>
        </tr>
        </c:forEach>

    </table>
</div>
