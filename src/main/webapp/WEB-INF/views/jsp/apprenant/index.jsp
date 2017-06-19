<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:generic_page>
    <jsp:attribute name="title">
     <i class="fa fa-gear fa-fw"></i> Votre compte : ${apprenant.prenomapprenant} ${apprenant.nomapprenant}
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Vos jeux</h2>
                        <c:forEach items="${apprenant.jeux}" var="jeu">
                            ${jeu.libellejeu} <a class="btn btn-primary"
                               href="/apprenant/jeu/${jeu.numjeu}">Accéder au jeu </a>
                            <br />
                            <br />
                        </c:forEach>
                        <c:if test="${empty apprenant.jeux}">
                            <i>Vous n'êtes inscrit à aucun jeu</i>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Les jeux disponibles</h2>
                        <c:forEach items="${jeux}" var="j">
                            ${j.libellejeu} <a class="btn btn-primary"
                               href="/apprenant/inscrire/${j.numjeu}">S'inscrire à ce jeu</a>
                            <br />
                            <br />
                        </c:forEach>
                        <c:if test="${empty jeux}">
                            <i>Aucun jeu disponible</i>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:generic_page>