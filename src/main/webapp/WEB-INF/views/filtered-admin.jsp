<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div align="center">
    <a href="showForm">Nuovo utente</a>
    <h1 align="center">Lista utenti filtrati:
    </h1>
    <div align="center">
        <table border="1" cellpadding="5">
            <form action="filter" method="POST">
                <tr>
                    Campo per il filtraggio:
                    <select name="parametri">
                        <option value="Nome">Nome</option>
                        <option value="Cognome">Cognome</option>
                        <option value="Email">Email</option>
                    </select>
                    Testo da cercare:<input type="text" name="text"/>
                    <button Class="btn btn-primary">Cerca</button>
                    <br/><br/>

                </tr>
            </form>

            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Data Di Nascita</th>
                <th>Operazioni</th>
            </tr>

            <tr>
                <c:forEach var="user" items="${column}">

                <th><c:out value="${user.id}"/></th>
                <th><c:out value="${user.nome}"/></th>
                <th><c:out value="${user.cognome}"/></th>
                <th><c:out value="${user.email}"/></th>
                <th><c:out value="${user.telefono}"/></th>
                <th><c:out value="${user.dataNascita}"/></th>
                <th>
                    <c:url var="toUpdateUtente" value="updateForm">
                        <c:param name="id" value="${user.id}"/></c:url>
                    <a href="${toUpdateUtente}">Modifica</a>
                    <c:url var="toDeleteUtente" value="deleteUtente">
                        <c:param name="id" value="${user.id}"/></c:url>
                    <a href="${toDeleteUtente}">Elimina</a>
                    <c:url var="toViewPrenotazioni" value="listPrenotazioni">
                        <c:param name="id" value="${user.id}"/>
                    </c:url>
                    <a href="${toViewPrenotazioni}">Visualizza prenotazioni</a>

                </th>
            </tr>
            </c:forEach>
        </table>
    </div>


</div>
