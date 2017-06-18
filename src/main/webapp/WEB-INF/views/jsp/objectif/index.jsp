<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-bullseye fa-fw"></i> Détail de l'objectif: ${objectif.libobjectif}
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Actions liées:</h2>
                        <c:forEach items="${objectif.actions}" var="action">
                            <a href="/action/${action.numaction}">${action.libaction}</a><br />
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Missions liées :</h2>
                        <c:forEach items="${objectif.missions}" var="mission">
                            <a href="/mission/${mission.nummission}">${mission.libmission}</a><br />
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:generic_page>