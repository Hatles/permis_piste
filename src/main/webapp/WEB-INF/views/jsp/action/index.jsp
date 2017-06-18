<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:generic_page>
    <jsp:attribute name="title">
     <i class="fa fa-gear fa-fw"></i> Détail de l'action: ${action.libaction}
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Note minimale</h2>
                            ${action.scoremin}/20
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Actions précédentes :</h2>
                        <c:forEach items="${action.actions}" var="action">
                            <a href="/action/${action.numaction}">${action.libaction}</a><br />
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Objectifs liés :</h2>
                        <c:forEach items="${action.objectifs}" var="objectif">
                            <a href="/objectif/${objectif.numobjectif}">${objectif.libobjectif}</a><br />
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:generic_page>