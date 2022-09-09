<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">

    <caption>
        <h2>
            <c:choose>
                <c:when test="${auto.id==0}">
                    Inserimento nuova auto
                </c:when>
                <c:otherwise>
                    Modifica auto
                </c:otherwise>
            </c:choose>
        </h2>
    </caption>
    <table border="1" cellpadding="5">

        <form:form method="POST" modelAttribute="auto" action="saveAuto">
            <c:if test="${auto.id!=0}">
                <tr>
                    <th>ID:</th>
                    <td>
                        <form:input id="id" path="id" value="${auto.id}" readonly="true"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>Marca:</th>
                <td>
                    <form:input id="marca" path="marca" value="${auto.marca}"/>
                </td>
            </tr>
            <tr>
                <th>Cilindrata:</th>
                <td>
                    <form:input id="cilindrata" path="cilindrata" value="${auto.cilindrata}"/>
                </td>
            </tr>
            <tr>
                <th>Modello:</th>
                <td>
                    <form:input id="modello" path="modello" value="${auto.modello}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <form:button cssClass="btn btn-primary">Procedi</form:button>
                </td>
            </tr>
        </form:form>
    </table>
</div>
