<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="actions" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.ActionEntity>"/>

<t:generic_page>
    <jsp:attribute name="title">
      ${typeForm} une Action
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                            ${typeForm} une Action
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form:form method="post" action="/action/save" modelAttribute="action">
                                    <form:input type="text" path="numaction" hidden="true"/>
                                    <div class="form-group">
                                        <label>Nom de l'action</label>
                                        <form:input class="form-control" type="text" path="libaction" placeholder="Enter text" />
                                    </div>
                                    <div class="form-group">
                                        <label>Act de l'action</label>
                                        <form:select class="form-control" path="actNumaction" >
                                            <form:option  value="" />
                                            <form:options items="${actions}" itemValue="numaction" itemLabel="libaction"/>
                                            <form:errors  path="actNumaction" cssClass="error"/>
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <label>Min de l'action</label>
                                        <form:input class="form-control" type="text" path="scoremin" placeholder="Enter number" />
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