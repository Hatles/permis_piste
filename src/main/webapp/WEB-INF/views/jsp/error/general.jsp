<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<%--<t:generic_page>--%>
    <%--<jsp:attribute name="title">--%>
        <%--Error page--%>
    <%--</jsp:attribute>--%>
    <%--<jsp:body>--%>
        <%--<f:alert type="danger" message="${errorMessage})"/>--%>
    <%--</jsp:body>--%>
<%--</t:generic_page>--%>
<html>
<head><title>Error page</title></head>
<body>
<f:alert type="danger" message="${errorMessage})"/>
</body>
</html>