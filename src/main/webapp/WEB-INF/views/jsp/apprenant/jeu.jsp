<%@ page import="com.polytech.permis_piste.model.JeuEntity" %>
<%@ page import="com.polytech.permis_piste.model.MissionEntity" %>
<%@ page import="com.polytech.permis_piste.model.ObjectifEntity" %>
<%@ page import="com.polytech.permis_piste.service.JeuService" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.polytech.permis_piste.service.ObjectifService" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.polytech.permis_piste.model.ApprenantEntity" %>
<%@ page import="com.polytech.permis_piste.service.ApprenantService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-gamepad fa-fw"></i> Détail du jeu: ${jeu.libellejeu}
    </jsp:attribute>
    <jsp:body>
        <c:forEach items="${jeu.missions}" var="mission">
            <div class="panel panel-primary">
                <div class="panel-heading">${mission.libmission}</div>
                <div class="panel-body">
                    <div class="progress">
                        <c:set var="total" value="${mission.nbObjectifsComplets/mission.objectifs.size()*100}" />
                        <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="${mission.nbObjectifsComplets}" aria-valuemin="0" aria-valuemax="${mission.objectifs.size()}" style="width: ${total}%">
                            ${mission.nbObjectifsComplets}
                        </div>
                    </div>
                    <div class="row">
                        <c:forEach items="${mission.objectifs}" var="objectif">
                            <div class="col-md-2">
                                <div class="panel panel-warning">
                                    <div class="panel-body">
                                        <h4><strong>${objectif.libobjectif}</strong></h4>
                                        <strong>Actions réalisées : </strong>  <span class="badge">${objectif.nbActionsReussis}/${objectif.actions.size()}</span> <br />
                                        <a href="/apprenant/jeu/${jeu.numjeu}/${mission.nummission}/${objectif.numobjectif}">Accéder à l'objectif...</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </c:forEach>
    </jsp:body>
</t:generic_page>