<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div align="center">
    <h1 align="center"><b>Lista prenotazioni:</b></h1>
    </br></br>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Data Inizio</th>
            <th>Data Fine</th>
            <th>Customer</th>
            <th>Veicolo</th>
            <th>Approvazione</th>

        </tr>

        <tr>
            <c:forEach var="pren" items="${prenotazioni}">
            <th><c:out value="${pren.id}"/></th>
            <th><c:out value="${pren.dataInizio}"/></th>
            <th><c:out value="${pren.dataFine}"/></th>
            <th><c:out value="${pren.utente.nome}"/>
                <c:out value="${pren.utente.cognome}"/></th>
            <th><c:out value="${pren.auto.marca}"/>
                <c:out value="${pren.auto.modello}"/></th>
            <th>

                <form:form action="approvata" method="POST">
                    <input type="hidden" value="/approvata" name="action">
                    <input type="hidden" name="idP" value="${pren.id}">
                    <input type="hidden" value="/list" name="action">
                    <form:select path="approved">
                        <form:option value="Si">Si</form:option>f
                        <form:option value="No">No</form:option>
                    </form:select>
                    <input type="submit" value="vai">
                </form:form>
            </th>


        </tr>
        </c:forEach>
    </table>


</div>