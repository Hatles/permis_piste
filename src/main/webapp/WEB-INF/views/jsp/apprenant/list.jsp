<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
										<a href="/apprenant/edit/${item.numapprenant}" class="btn btn-sm btn-flat btn-primary"
										   title="Modifier"><i class="fa fa-edit"></i></a>
										<a class="btn btn-sm  btn-flat btn-danger"
										   title="Supprimer" data-toggle="modal" data-target="#modal_confirm"
										   data-apprenant="<c:out value="${apprenant.prenomapprenant}"/> <c:out value="${apprenant.nomapprenant}"/>"
										   data-id="<c:out value="${item.numapprenant}"/>">
											<i class="fa fa-trash"></i></a>
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