<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div align="center">
    <form:form action="PrenotazioneServlet" method="GET">
        <h1 align="center"><b>Lista auto disponibili alla prenotazione:</b></h1>
        </br></br>
        <table border="1" cellpadding="5">
            <tr>
                <th>Marca</th>
                <th>Cilindrata</th>
                <th>Modello</th>
                <th>Prenota</th>
            </tr>
            <tr>
                <c:forEach var="auto" items="${listFiltered}">
                <th><c:out value="${auto.marca}"/></th>
                <th><c:out value="${auto.cilindrata}"/></th>
                <th><c:out value="${auto.modello}"/></th>
                <td colspan="2" align="center">
                    <form:button cssClass="btn btn-primary">Modifica</form:button>
                </td>
            </tr>
            </c:forEach>

        </table>
    </form:form>
</div>
