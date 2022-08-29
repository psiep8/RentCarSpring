<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<body>
<div align="center">
    <a href="showForm">Nuovo utente</a>
    <h1 align="center">Lista utenti:
    </h1>
    <div align="center">
        <table border="1" cellpadding="5">


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
                <c:forEach var="user" items="${utenti}">

                <th><c:out value="${user.id}"/></th>
                <th><c:out value="${user.nome}"/></th>
                <th><c:out value="${user.cognome}"/></th>
                <th><c:out value="${user.email}"/></th>
                <th><c:out value="${user.telefono}"/></th>
                <th><c:out value="${user.dataNascita}"/></th>
                <th>
                    <a href="@{/showForm/{id}(id=${user.id}">Modifica</a>
                    <a href="@{/deleteUtente/{id}(id=${user.id}">Elimina</a>
                </th>
            </tr>
            </c:forEach>
        </table>
    </div>

</div>
</body>

