<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:useBean id="jeux" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.JeuEntity>"/>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-gamepad fa-fw"></i> Liste des Apprenants
    </jsp:attribute>
	<jsp:body>
		<div class="panel panel-default">
			<div class="panel-heading">
				Tableau des Apprenants
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
						<tr>
							<th>#</th>
							<th>Libellé</th>
							<th>Actions</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${jeux}" var="item">
							<tr>
								<td>${item.numjeu}</td>
								<td>${item.libellejeu}</td>
								<td>
									<a href="/jeu/${item.numjeu}" class="btn btn-sm btn-flat btn-info"
									   title="Accéder"><i class="fa fa-caret-square-o-right"></i> Plus d'infos</a>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<a href="/jeu/edit/${item.numjeu}" class="btn btn-sm btn-flat btn-primary"
										   title="Modifier"><i class="fa fa-edit"></i></a>
									</sec:authorize>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a class="btn btn-block btn-primary" href="/jeu/add">Ajouter un jeu</a>
				</sec:authorize>

				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
	</jsp:body>
</t:generic_page>