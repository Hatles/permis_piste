<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>

<t:generic_page>
    <jsp:attribute name="title">
        Home
    </jsp:attribute>
    <jsp:attribute name="javascripts">
        <script type="text/javascript">
            /* Fill in modal with content loaded with Ajax */
            $(document).ready(function () {
                $('#signup').on('click', function () {
                    $("#signup-modal").modal();
                    $("#signup-modal-body").text("");
                    $.ajax({
                        url: "signup",
                        cache: false
                    }).done(function (html) {
                        $("#signup-modal-body").append(html);
                    });
                })
            });
        </script>
    </jsp:attribute>
    <jsp:attribute name="foot_area">
        <f:modal id="signup-modal" title="Signup"/>
    </jsp:attribute>
    <jsp:body>
        <p class="lead">
Connectez vous pour accéder à l'application
        </p>
        <p>
            <a class="btn btn-success btn-lg" id="signup">Sign up</a>
        </p>
    </jsp:body>
</t:generic_page>
