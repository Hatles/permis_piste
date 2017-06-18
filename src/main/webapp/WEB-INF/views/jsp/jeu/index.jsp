<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-gamepad fa-fw"></i> Détail du jeu: ${jeu.libellejeu}
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-4">sfdsf</div>
            <div class="col-md-8">
                <h2>Missions</h2>
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <c:forEach items="${jeu.missions}" var="mission">
                        <%@include file="../mission/detailinclude.jsp" %>
                    </c:forEach>
                </div>
            </div>
        </div>
    </jsp:body>
</t:generic_page>