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
        <p class="lead text-center">
            Heureux de vous revoir ${account.apprenant.prenomapprenant} !
        </p>
        <p>Ci-dessous, vous pouvez retrouver toutes les informations concernant la formation permis piste</p>
        <div class="row">
            <f:task number="${numberApprenants}" title="Apprenants" icon="users" target="apprenant/list"/>
            <f:task number="${numberJeux}" title="Jeux" icon="gamepad" type="green" target="jeu/list"/>
            <f:task number="${numberMissions}" title="Missions" icon="newspaper-o" type="yellow" target="mission/list"/>
            <f:task number="${numberObjectifs}" title="Objectifs" icon="bullseye" type="red" target="objectif/list"/>
            <f:task number="${numberActions}" title="Actions" icon="gear" type="info" target="action/list"/>
        </div>
        <p>Ci-dessous, vous pouvez accéder à la page qui vous permet de gérer vos jeux</p>
        <a href="/apprenant/current" class="btn btn-lg btn-success"><span class="glyphicon glyphicon-star-empty"></span> Gérer mes jeux</a>
    </jsp:body>
</t:generic_page>
