<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

<%--<%@tag description="Navbar Include" pageEncoding="UTF-8"%>--%>

<ul class="nav navbar-top-links navbar-right">

    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="/apprenant/current"><i class="fa fa-user fa-fw"></i> Vos jeux</a>
            </li>
            <li class="divider"></li>
            <sec:authorize access="isAuthenticated()">
                <li>
                    <a href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </sec:authorize>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
</ul>
