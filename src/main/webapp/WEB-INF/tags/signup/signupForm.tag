<%@tag description="Sign Up form" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<%@attribute name="title"%>

<form class="form-narrow form-horizontal" method="post" action="signup">
    <!--/* Show general error message when form contains errors */-->
    <c:if test="${fields.hasErrors('${signupForm.*}')}">
        <f:alert type="danger" message="Form contains errors. Please try again."/>
    </c:if>
    <fieldset>
        <c:if test="${not empty title}"><legend>${title}</legend></c:if>
        <div class="form-group${fields.hasErrors('email') ? ' has-error' : ""}">
            <label for="email" class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
                <input type="text" class="form-control" id="email" placeholder="Email address"/>
                <span class="help-block">Incorrect email</span>
            </div>
        </div>
        <div class="form-group${fields.hasErrors('password') ? ' has-error' : ''}">
            <label for="password" class="col-lg-2 control-label">Password</label>
            <div class="col-lg-10">
                <input type="password" class="form-control" id="password" placeholder="Password"/>
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
</form>