<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<t:generic_page>
    <jsp:attribute name="title">
      Bienvenue sur Permis Piste Polytech
    </jsp:attribute>
    <jsp:body>
        <c:if test="${message != null}">
            <f:alert type="${fn:toLowerCase(message.type)}" message="${message.message}${authentication.name}"/>
        </c:if>
        <p class="lead text-center">
            ...
        </p>
    </jsp:body>
</t:generic_page>
