<%--
  Created by IntelliJ IDEA.
  User: Giuseppe Romagnoli
  Date: 27/07/2022
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div align="center">

    <caption>
        <h2>
            <c:choose>
                <c:when test="${utente.id==0}">
                    Inserimento nuovo utente
                </c:when>
                <c:otherwise>
                    Modifica utente
                </c:otherwise>
            </c:choose>
        </h2>
    </caption>
    <table border="1" cellpadding="5">

        <form:form method="POST" modelAttribute="utente" action="saveUtente">
            <c:if test="${utente.id!=0}">
                <tr>
                    <th>ID:</th>
                    <td>
                        <form:input id="id" path="id" value="${utente.id}" readonly="true"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>Nome:</th>
                <td>
                    <form:input id="nome" path="nome" type="text"/>
                </td>
            </tr>
            <tr>
                <th>Cognome:</th>
                <td>
                    <form:input id="cognome" path="cognome" type="text"/>
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <form:input id="password" path="password" type="text"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <form:input id="email" path="email" type="text"/>
                </td>
            </tr>
            <tr>
                <th>Telefono:</th>
                <td>
                    <form:input id="telefono" path="telefono" type="text"/>
                </td>
            </tr>
            <tr>
                <th>Data di nascita:</th>
                <td>
                    <form:input id="dataNascita" path="dataNascita" type="date"/>
                </td>
            </tr>
            <form:hidden path="customer" value="true"/>
            <tr>
                <td colspan="2" align="center">
                    <form:button cssClass="btn btn-primary">Procedi</form:button>
                </td>
            </tr>
        </form:form>
    </table>
</div>

