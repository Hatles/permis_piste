<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<jsp:useBean id="missions" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.MissionEntity>"/>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-newspaper-o fa-fw"></i> Liste des Missions
    </jsp:attribute>
	<jsp:body>
		<div class="panel panel-default">
			<div class="panel-heading">
				Tableau des Missions
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
						<c:forEach items="${missions}" var="item">
							<tr>
								<td>${item.nummission}</td>
								<td>${item.libmission}</td>
								<td>
									<a href="/mission/${item.nummission}" class="btn btn-sm btn-flat btn-info"
									   title="Accéder"><i class="fa fa-caret-square-o-right"></i> Plus d'infos</a>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<a href="/mission/edit/${item.nummission}" class="btn btn-sm btn-flat btn-primary"
										   title="Modifier"><i class="fa fa-edit"></i></a>
										<c:set var="modalId">modal_delete_${item.nummission}</c:set>
										<button type="button" title="Supprimer" class="btn btn-sm  btn-flat btn-danger" data-toggle="modal" data-target="#${modalId}">
											<i class="fa fa-trash"></i>
										</button>
										<f:modal id="${modalId}" title="Supprimer" button="Supprimer" link="/mission/delete/${item.nummission}">
											Etes vous sur de vouloir supprimer la mission "${item.libmission}" ?
										</f:modal>
									</sec:authorize>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a class="btn btn-block btn-primary" href="/mission/add">Ajouter une mission</a>
				</sec:authorize>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
	</jsp:body>
</t:generic_page>