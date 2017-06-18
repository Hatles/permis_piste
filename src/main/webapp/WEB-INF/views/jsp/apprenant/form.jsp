<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:generic_page>
    <jsp:attribute name="title">
      ${typeForm} un Apprenant
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                            ${typeForm} un Apprenant
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form:form method="post" action="/apprenant/save" modelAttribute="apprenant">
                                    <form:input type="text" path="numapprenant" hidden="true"/>
                                    <div class="form-group">
                                        <label>Nom de l'apprenant</label>
                                        <form:input class="form-control" type="text" path="nomapprenant" placeholder="Enter text" />
                                    </div>
                                    <div class="form-group">
                                        <label>Prénom de l'apprenant</label>
                                        <form:input class="form-control" type="text" path="prenomapprenant" placeholder="Enter text" />
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