<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
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
                <th>Operazioni</th>
            </tr>

            <tr>
                <c:forEach var="temp" items="${auto}">
                <th><c:out value="${temp.id}"/></th>
                <th><c:out value="${temp.marca}"/></th>
                <th><c:out value="${temp.cilindrata}"/></th>
                <th><c:out value="${temp.modello}"/></th>
            </tr>
            </c:forEach>
        </table>
    </div>

</div>

