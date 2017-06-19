<%@tag description="User Task template" pageEncoding="UTF-8"%>
<%@attribute name="number" required="true" type="java.lang.Integer"%>
<%@attribute name="title" type="java.lang.String"%>
<%@attribute name="type" required="false" type="java.lang.String"%>
<%@attribute name="icon" required="false" type="java.lang.String"%>
<%@attribute name="target" required="false" type="java.lang.String"%>

<div class="col-lg-3 col-md-6">
    <div class="panel panel-${(empty type) ? "primary" : type}">
        <div class="panel-heading">
            <div class="row">
                <div class="col-xs-3">
                    <i class="fa fa-${(empty icon) ? "comments" : icon} fa-5x"></i>
                </div>
                <div class="col-xs-9 text-right">
                    <div class="huge">${number}</div>
                    <div>${title}</div>
                </div>
            </div>
        </div>
        <a href="${(empty target) ? "#" : target}">
            <div class="panel-footer">
                <span class="pull-left">Voir détails</span>
                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                <div class="clearfix"></div>
            </div>
        </a>
    </div>
</div>