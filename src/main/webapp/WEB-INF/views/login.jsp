<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<main class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal"><b>${intestazione}</b></h1>

    <c:url var="loginUrl" value="/login"/>
    <form action="${loginUrl}" method="post" class="form-horizontal">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <p>Nome utente o password errata</p>
            </div>
        </c:if>

        <c:if test="${param.forbidden != null}">
            <div class="alert alert-danger">
                <p>Accesso negato.</p>
            </div>
        </c:if>

        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>Logout eseguito.</p>
            </div>
        </c:if>
        <h1 class="h3 mb-3 fw-normal">Accesso</h1>
        <div class="form-floating">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="Inserisci email">
        </div>
        <div class="form-floating">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"
                   placeholder="Inserisci password">
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <button class="w-100 btn btn-lg btn-primary" name="login-submit" id="login-submit" type="submit">Accedi</button>
    </form>
</main>