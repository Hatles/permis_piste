<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:generic_page>
    <jsp:attribute name="title">
     <i class="fa fa-newspaper-o fa-fw"></i> Détail de la mission: ${mission.libmission}
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Jeu lié:</h2>
                        <a href="/jeu/${mission.jeu.numjeu}">${mission.jeu.libellejeu}</a><br />
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Objectif liés :</h2>
                        <c:forEach items="${mission.objectifs}" var="objectif">
                            <a href="/objectif/${objectif.numobjectif}">${objectif.libobjectif}</a><br />
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:generic_page>