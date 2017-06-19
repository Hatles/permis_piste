<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-gamepad fa-fw"></i> Détail de l'objectif: ${objectif.libobjectif}
    </jsp:attribute>
    <jsp:body>
        <a class="btn  btn-primary"
                             href="/apprenant/jeu/${jeuid}">Retour au jeu</a>
        <div class="row">
            <c:forEach items="${objectif.actions}" var="action">
                <div class="col-md-4">
                    <div class="panel panel-info">
                        <div class="panel-heading">${action.libaction}</div>
                        <div class="panel-body">

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="panel panel-warning">
                                        <div class="panel-body">
                                            Minimum : <span class="badge">${action.scoremin}/20</span><br/>
                                            <c:choose>
                                                <c:when test="${not empty action.scores}">
                                                    Votre score : <span
                                                        class="badge">${action.scores[0].valeur}/20</span>
                                                    <br/>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${action.canDo==true}">
                                                            <br/>
                                                            <a class="btn btn-block btn-primary"
                                                               href="/action/valider/${jeuid}/${missionid}/${objectifid}/${action.numaction}">Effecuter
                                                                l'action</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <br/>
                                                            Vous ne pouvez pas effectuer l'action tant que les actions précédentes ne sont pas validés
                                                            <br/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="panel panel-warning">
                                        <div class="panel-body">
                                            <h4><strong>Actions précédentes à valider</strong></h4>
                                            <c:forEach items="${action.actions}" var="actionprec">
                                                <i>-${actionprec.libaction}</i><br />
                                            </c:forEach>
                                            <c:if test="${empty action.actions}">
                                                <i>Aucune action à valider</i>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:generic_page>