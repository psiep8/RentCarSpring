<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>

<div align="center">
    <a href="showForm">Nuova prenotazione</a>
    <h1 align="center">Lista prenotazioni:
    </h1>
    <div align="center">
        <tr>
            Data da cercare:<input path="inizio"/>
            Data da cercare:<input path="fine"/>
            <input type="submit" name="Cerca">
            <br/><br/>

        </tr>
    </div>

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