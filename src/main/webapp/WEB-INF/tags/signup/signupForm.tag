<%@tag description="Sign Up form" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@attribute name="title"%>

<form:form method="post" action="/signup" modelAttribute="signupForm" class="form-narrow form-horizontal">
    <!--/* Show general error message when form contains errors */-->
    <c:set var="errors"><form:errors path="*"/></c:set>
    <c:if test="${not empty errors}">
        <f:alert type="danger" message="Form contains errors. Please try again."/>
    </c:if>
    <fieldset>
        <c:if test="${not empty title}"><legend>${title}</legend></c:if>
        <c:set var="emailErrors"><form:errors path="email"/></c:set>
        <div class="form-group${not empty emailErrors ? ' has-error' : ''}">
            <label for="email" class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
                <form:input class="form-control" type="text" path="email" placeholder="Email address" id="email"/>
                ${emailErrors}
                <span class="help-block">Incorrect email</span>
            </div>
        </div>
        <c:set var="nomErrors"><form:errors path="email"/></c:set>
        <div class="form-group${not empty nomErrors ? ' has-error' : ''}">
            <label for="nom" class="col-lg-2 control-label">Nom</label>
            <div class="col-lg-10">
                <form:input class="form-control" type="text" path="nom" placeholder="Nom" id="nom"/>
                <span class="help-block">Incorrect nom</span>
            </div>
        </div>
        <c:set var="prenomErrors"><form:errors path="email"/></c:set>
        <div class="form-group${not empty prenomErrors ? ' has-error' : ''}">
            <label for="prenom" class="col-lg-2 control-label">Prénom</label>
            <div class="col-lg-10">
                <form:input class="form-control" type="text" path="prenom" placeholder="Prenom" id="prenom"/>
                <span class="help-block">Incorrect prénom</span>
            </div>
        </div>
        <c:set var="passwordErrors"><form:errors path="email"/></c:set>
        <div class="form-group${not empty passwordErrors ? ' has-error' : ''}">
            <label for="password" class="col-lg-2 control-label">Password</label>
            <div class="col-lg-10">
                <form:input class="form-control" type="text" path="password" placeholder="Password" id="password"/>
                <span class="help-block">Incorrect password</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Sign up</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <p>Already have an account? <a href="signin">Sign In</a></p>
            </div>
        </div>
    </fieldset>
</form:form>