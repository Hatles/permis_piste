<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<t:generic_page>
    <jsp:attribute name="title">
        Page d'erreur
    </jsp:attribute>
    <jsp:body>
        <f:alert type="danger" message="${errorMessage})"/>
    </jsp:body>
</t:generic_page>