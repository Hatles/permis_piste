<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="actions" scope="request" type="java.util.ArrayList<com.polytech.permis_piste.model.ActionEntity>"/>

<t:generic_page>
    <jsp:attribute name="title">
      <i class="fa fa-gear fa-fw"></i> Liste des Actions
    </jsp:attribute>
	<jsp:body>
		<div class="panel panel-default">
			<div class="panel-heading">
				Tableau des Actions
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
						<c:forEach items="${actions}" var="item">
							<tr>
								<td>${item.numaction}</td>
								<td>${item.libaction}</td>
								<td>
									<a href="/action/${item.numaction}" class="btn btn-sm btn-flat btn-info"
									   title="Accéder"><i class="fa fa-caret-square-o-right"></i> Plus d'infos</a>
										<a href="/action/edit/${item.numaction}" class="btn btn-sm btn-flat btn-primary"
										   title="Modifier"><i class="fa fa-edit"></i></a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<a class="btn btn-block btn-primary" href="/jeu/add">Ajouter un jeu</a>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
	</jsp:body>
</t:generic_page>