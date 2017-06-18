<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="jeux" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.JeuEntity>"/>

<t:generic_page>
    <jsp:attribute name="title">
      ${typeForm} une Mission
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                            ${typeForm} une Mission
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form:form method="post" action="/mission/save" modelAttribute="mission">
                                    <form:input type="text" path="nummission" hidden="true"/>
                                    <div class="form-group">
                                        <label>Nom de la mission</label>
                                        <form:input class="form-control" type="text" path="libmission" placeholder="Enter text" />
                                    </div>
                                    <div class="form-group">
                                        <label>Appartenant au jeu...</label>
                                        <form:select class="form-control" path="numjeu" itemValue="numjeu" itemLabel="libellejeu" items="${jeux}"></form:select>
                                    </div>
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