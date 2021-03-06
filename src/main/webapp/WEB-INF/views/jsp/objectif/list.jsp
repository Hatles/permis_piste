<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<jsp:useBean id="objectifs" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.ObjectifEntity>"/>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-newspaper-o fa-fw"></i> Liste des Objectifs
    </jsp:attribute>
	<jsp:body>
		<div class="panel panel-default">
			<div class="panel-heading">
				Tableau des Objectifs
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
						<c:forEach items="${objectifs}" var="item">
							<tr>
								<td>${item.numobjectif}</td>
								<td>${item.libobjectif}</td>
								<td>
									<a href="/objectif/${item.numobjectif}" class="btn btn-sm btn-flat btn-info"
									   title="Accéder"><i class="fa fa-caret-square-o-right"></i> Plus d'infos</a>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<a href="/objectif/edit/${item.numobjectif}" class="btn btn-sm btn-flat btn-primary"
										   title="Modifier"><i class="fa fa-edit"></i></a>
										<c:set var="modalId">modal_delete_${item.numobjectif}</c:set>
										<button type="button" title="Supprimer" class="btn btn-sm  btn-flat btn-danger" data-toggle="modal" data-target="#${modalId}">
											<i class="fa fa-trash"></i>
										</button>
										<f:modal id="${modalId}" title="Supprimer" button="Supprimer" link="/objectif/delete/${item.numobjectif}">
											Etes vous sur de vouloir supprimer l'objectif "${item.libobjectif}" ?
										</f:modal>
									</sec:authorize>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<a class="btn btn-block btn-primary" href="/objectif/add">Ajouter un objectif</a>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
	</jsp:body>
</t:generic_page>