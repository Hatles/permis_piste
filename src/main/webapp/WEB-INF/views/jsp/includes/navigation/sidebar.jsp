<%--
  Created by IntelliJ IDEA.
  User: kifkif
  Date: 10/02/2017
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>--%>
<%--<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>

<%--<%@tag description="Sidebar Include" pageEncoding="UTF-8"%>--%>

<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                </div>
                <!-- /input-group -->
            </li>
            <li>
                <a href="/"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-users fa-fw"></i> Apprenants<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/apprenant/list">Liste des Apprenants</a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="/apprenant/add">Ajouter un Apprenant</a>
                        </li>
                    </sec:authorize>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-gamepad fa-fw"></i> Jeux<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/jeu/list">Liste des Jeux</a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="/jeu/add">Ajouter un Jeu</a>
                        </li>
                    </sec:authorize>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-newspaper-o fa-fw"></i> Missions<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/mission/list">Liste des Missions</a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="/mission/add">Ajouter une Mission</a>
                        </li>
                    </sec:authorize>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-bullseye fa-fw"></i> Objectifs<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/objectif/list">Liste des Objectifs</a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="/objectif/add">Ajouter un Objectif</a>
                        </li>
                    </sec:authorize>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-gear fa-fw"></i> Actions<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/action/list">Liste des Actions</a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="/action/add">Ajouter une Action</a>
                        </li>
                    </sec:authorize>
                </ul>
                <!-- /.nav-second-level -->
            </li>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>

