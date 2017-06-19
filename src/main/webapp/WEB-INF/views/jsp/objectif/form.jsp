<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<jsp:useBean id="missions" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.MissionEntity>"/>--%>

<t:generic_page>
    <jsp:attribute name="title">
      ${typeForm} un Objectif
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                            ${typeForm} un Objectif
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form:form method="post" action="/objectif/save" modelAttribute="objectif">
                                    <form:input type="text" path="numobjectif" hidden="true"/>
                                    <div class="form-group">
                                        <label>Nom de l'objectif</label>
                                        <form:input class="form-control" type="text" path="libobjectif" placeholder="Enter text" />
                                    </div>
                                    <%--<div class="form-group">--%>
                                        <%--<label>Appartenant au jeu...</label>--%>
                                        <%--<form:select class="form-control" path="numjeu" itemValue="numjeu" itemLabel="libellejeu" items="${jeux}"></form:select>--%>
                                    <%--</div>--%>
                                    <button class="btn btn-block btn-primary">${typeForm}</button>
                                </form:form>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </jsp:body>
</t:generic_page>