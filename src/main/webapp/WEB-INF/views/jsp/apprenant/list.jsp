<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<jsp:useBean id="apprenants" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.ApprenantEntity>"/>

<t:generic_page>
    <jsp:attribute name="title">
      Liste des Apprenants
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
							<th>Nom</th>
							<th>Prénom</th>
							<th>Action</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${apprenants}" var="item">
							<tr>
								<td>${item.numapprenant}</td>
								<td>${item.nomapprenant}</td>
								<td>${item.prenomapprenant}</td>
								<td>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<a href="/apprenant/edit/${item.numapprenant}" class="btn btn-sm btn-flat btn-primary"
										   title="Modifier"><i class="fa fa-edit"></i></a>
										<c:set var="modalId">modal_delete_${item.numapprenant}</c:set>
										<button type="button" title="Supprimer" class="btn btn-sm  btn-flat btn-danger" data-toggle="modal" data-target="#${modalId}">
											<i class="fa fa-trash"></i>
										</button>
										<f:modal id="${modalId}" title="Supprimer" button="Supprimer" link="/apprenant/delete/${item.numapprenant}">
											Etes vous sur de vouloir supprimer l'apprenant "${item.nomapprenant} ${item.prenomapprenant}" ?
										</f:modal>
									</sec:authorize>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<a class="btn btn-block btn-primary" href="/apprenant/add">Ajouter un apprenant</a>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
	</jsp:body>
</t:generic_page>