<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div align="center">
    <h1 align="center"><b>Lista prenotazioni di ${utente.nome} ${utente.cognome}:</b></h1>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Data Inizio</th>
            <th>Data Fine</th>
            <th>Veicolo</th>

        </tr>
        <tr>
            <c:forEach var="pren" items="${prenotazioni}">

            <th><c:out value="${pren.id}"/></th>
            <th><c:out value="${pren.dataInizio}"/></th>
            <th><c:out value="${pren.dataFine}"/></th>
            <th><c:out value="${pren.auto.marca}"/>
                <c:out value="${pren.auto.modello}"/></th>
            <th>
                <c:if test="${pren.approvata==false}">
                    <form:form action="approvata" method="POST">
                        <input type="hidden" name="id" value="${pren.id}">
                        <select name="approved">
                            <option value="Si">Si</option>
                            <option value="No">No</option>
                        </select>
                        <input type="submit" value="Approva">
                    </form:form>
                </c:if>
            </th>
        </tr>
        </c:forEach>
    </table>


</div>