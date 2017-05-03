<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>--%>
<%--<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>
<%--<%@ taglib prefix="f" tagdir="/WEB-INF/tags/fragments" %>--%>

<%--<t:generic_page>--%>
    <%--<jsp:attribute name="title">--%>
        <%--Welcome to the Spring MVC Quickstart application! Get started quickly by signing up!--%>
    <%--</jsp:attribute>--%>
    <%--<jsp:body>--%>
        <%--<f:panel title="Test">--%>
            <%--<jsp:body>--%>
                <%--<p class="lead">--%>
                    <%--Welcome to the Spring MVC Quickstart application!--%>
                    <%--Get started quickly by signing up.--%>
                <%--</p>--%>
                <%--<p>--%>
                    <%--<a class="btn btn-success btn-lg" id="signup">Sign up</a>--%>
                <%--</p>--%>
            <%--</jsp:body>--%>
        <%--</f:panel>--%>
    <%--</jsp:body>--%>
    <%--&lt;%&ndash;<jsp:attribute name="javascripts">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<script type="text/javascript">&ndash;%&gt;--%>
            <%--&lt;%&ndash;/* Fill in modal with content loaded with Ajax */&ndash;%&gt;--%>
            <%--&lt;%&ndash;$(document).ready(function () {&ndash;%&gt;--%>
                <%--&lt;%&ndash;$('#signup').on('click', function () {&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$("#signup-modal").modal();&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$("#signup-modal-body").text("");&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$.ajax({&ndash;%&gt;--%>
                        <%--&lt;%&ndash;url: "signup",&ndash;%&gt;--%>
                        <%--&lt;%&ndash;cache: false&ndash;%&gt;--%>
                    <%--&lt;%&ndash;}).done(function (html) {&ndash;%&gt;--%>
                        <%--&lt;%&ndash;$("#signup-modal-body").append(html);&ndash;%&gt;--%>
                    <%--&lt;%&ndash;});&ndash;%&gt;--%>
                <%--&lt;%&ndash;})&ndash;%&gt;--%>
            <%--&lt;%&ndash;});&ndash;%&gt;--%>
        <%--&lt;%&ndash;</script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</jsp:attribute>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<jsp:attribute name="foot_area">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<f:modal id="signup-modal" title="Signup"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</jsp:attribute>&ndash;%&gt;--%>
<%--</t:generic_page>--%>

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
            Welcome to the Spring MVC Quickstart application!
            Get started quickly by signing up.
        </p>
        <p>
            <a class="btn btn-success btn-lg" id="signup">Sign up</a>
        </p>
    </jsp:body>
</t:generic_page>
