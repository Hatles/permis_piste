<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags/signup" %>

<t:generic_page>
    <jsp:attribute name="title">
        Sign Up
    </jsp:attribute>
    <jsp:body>
        <f:panel title="Please Sign Up">
            <jsp:body>
                <s:signupForm/>
            </jsp:body>
        </f:panel>
    </jsp:body>
</t:generic_page>

