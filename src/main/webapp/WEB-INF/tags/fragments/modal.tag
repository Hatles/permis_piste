<%@tag description="User Page template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="id" required="true" type="java.lang.String"%>
<%@attribute name="title" required="true" type="java.lang.String"%>
<%@attribute name="button" required="false" type="java.lang.String"%>
<%@attribute name="link" required="false" type="java.lang.String"%>
<%@attribute name="type" required="false" type="java.lang.String"%>

<div class="modal fade" id="${id}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabel">${title}</h4>
            </div>
            <div class="modal-body" id="${id}-body">
                <jsp:doBody/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <c:if test="${not empty button and not empty link}">
                    <a href="${link}" type="button" class=" btn btn-${(not empty type) ? type : "danger"}">${button}</a>
                </c:if>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->