<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<t:generic_page>
    <jsp:attribute name="title">
        Sign In
    </jsp:attribute>
    <jsp:body>
        <f:panel title="Sign In">
            <jsp:body>
                <form class="form-narrow form-horizontal" method="post" action="authenticate">
                    <c:if test="${param.error != null}">
                        <f:alert type="danger" message="Sign in error. Please try again."/>
                    </c:if>
                    <fieldset>
                        <legend>Please Sign In</legend>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="username" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                            <div class="col-lg-10">
                                <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="_spring_security_remember_me" /> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button type="submit" class="btn btn-default">Sign in</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <p>New here? <a href="signup">Sign Up</a></p>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </jsp:body>
        </f:panel>
    </jsp:body>
</t:generic_page>
