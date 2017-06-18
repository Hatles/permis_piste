<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading${mission.nummission}">
        <h4 class="panel-title">
            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${mission.nummission}" aria-expanded="true" aria-controls="collapse${mission.nummission}">
                ${mission.libmission}
            </a>
        </h4>
    </div>
    <div id="collapse${mission.nummission}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${mission.nummission}">
        <i>
            <a href="/mission/${mission.nummission}">Détail de la mission...</a>
        </i>
        <div class="panel-body">
            <c:forEach items="${mission.objectifs}" var="objectif">
                <%@include file="../objectif/detailinclude.jsp" %>
            </c:forEach>
        </div>
    </div>
</div>