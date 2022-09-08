<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>

<div align="center">
    <h1 align="center">Lista prenotazioni:
    </h1>
    <form:form method="POST" action="selectDate">
        <div align="center">
            <tr>
                Data di inizio da cercare:<input name="inizio" type="date"/>
                Data di fine da cercare:<input name="fine" type="date"/>
                <input type="submit" class="btn btn-primary"/>
            </tr>
        </div>
    </form:form>

    <table border="1" cellpadding="5">
        <tr>
            <th>Data Inizio</th>
            <th>Data Fine</th>
            <th>Operazioni</th>
        </tr>
        <tr>
            <c:forEach var="pren" items="${prenotazioni}">
            <th><c:out value="${pren.dataInizio}"/></th>
            <th><c:out value="${pren.dataFine}"/></th>
            <th>
                <c:url var="toUpdatePrenotazione" value="updateForm">
                    <c:param name="id" value="${pren.id}"/></c:url>
                <a href="${toUpdatePrenotazione}">Modifica</a>
                <c:url var="toDeletePrenotazione" value="deletePrenotazione">
                    <c:param name="id" value="${pren.id}"/></c:url>
                <a href="${toDeletePrenotazione}">Elimina</a>
            </th>
        </tr>
        </c:forEach>

    </table>
</div>
</body>