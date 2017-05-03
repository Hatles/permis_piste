<%@tag description="User Page template" pageEncoding="UTF-8"%>
<%@attribute name="type" required="true" type="java.lang.String"%>
<%@attribute name="message" required="true" type="java.lang.String"%>

<div class="alert alert-dismissable alert-${type}">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <span>${message}</span>
</div>