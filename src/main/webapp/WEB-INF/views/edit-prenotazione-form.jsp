<%--
Created by IntelliJ IDEA.
User: Giuseppe Romagnoli
Date: 27/07/2022
Time: 16:10
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
    <caption>
        <h2>
            Modifica Prenotazione
        </h2>
    </caption>
    <table border="1" cellpadding="5">

        <form:form method="POST" action="selectDate">
            <tr>
                <th>ID:</th>
                <td>
                    <input name="id" value="${prenotazione.id}" readonly="true"/>
                </td>
            </tr>
            <tr>
                <th>Data Inizio:</th>
                <td>
                    <input name="inizio" value="${prenotazione.dataInizio}"/>
                </td>
            </tr>
            <tr>
                <th>Data Fine:</th>
                <td>
                    <input name="fine" value="${prenotazione.dataFine}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button class="btn btn-primary">Modifica</button>
                </td>
            </tr>
        </form:form>
    </table>
</div>

