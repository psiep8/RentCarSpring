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


            Inserimento nuovo utente

        </h2>
    </caption>
    <table border="1" cellpadding="5">

        <form:form method="post" action="saveUtente" modelAttribute="utente">
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
                    <form:input id="dataNascita" path="dataNascita" type="text"/>

                </td>
            </tr>
            <tr>
                <th>Customer:</th>
                <td>
                    <form:input id="customer" path="customer" type="text"/>

                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <form:button type="submit" value="Aggiungi" id="btnAdd"
                                 onclick="alert('Inserimento utente effettuato')">Aggiungi</form:button>
                </td>
            </tr>
        </form:form>
    </table>
</div>

