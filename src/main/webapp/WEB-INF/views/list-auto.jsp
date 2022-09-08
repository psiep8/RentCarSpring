<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div align="center">
    <a href="showForm">Nuova Auto</a>
    <h1 align="center">Lista Auto:
    </h1>
    <div align="center">
        <table border="1" cellpadding="5">
            </br></br>
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Cilindrata</th>
                <th>Modello</th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th>Operazioni</th>
                </sec:authorize>
            </tr>

            <tr>
                <c:forEach var="temp" items="${autos}">
                <th><c:out value="${temp.id}"/></th>
                <th><c:out value="${temp.marca}"/></th>
                <th><c:out value="${temp.cilindrata}"/></th>
                <th><c:out value="${temp.modello}"/></th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th><c:url var="toUpdateAuto" value="updateForm">
                        <c:param name="id" value="${temp.id}"/></c:url>
                        <a href="${toUpdateAuto}">Modifica</a>
                        <c:url var="toDeleteAuto" value="deleteAuto">
                            <c:param name="id" value="${temp.id}"/></c:url>
                        <a href="${toDeleteAuto}">Elimina</a>
                        <c:url var="toListPrenotazione" value="listPrenotazioni">
                            <c:param name="id" value="${temp.id}"/></c:url>
                        <a href="${toListPrenotazione}">Visualizza Prenotazioni</a></th>
                </sec:authorize>

            </tr>
            </c:forEach>
        </table>
    </div>

</div>

