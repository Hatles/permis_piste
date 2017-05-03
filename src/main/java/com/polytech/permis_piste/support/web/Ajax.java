package com.polytech.permis_piste.support.web;

import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

public class Ajax {

	private Ajax() {
	}

	public static boolean isAjaxRequest(String requestedWith) {
		return requestedWith != null && "XMLHttpRequest".equals(requestedWith);
	}

	public static boolean isAjaxRequest(WebRequest request) {
		return isAjaxRequest(request.getHeader("X-Requested-With"));
	}

	public static boolean isAjaxRequest(HttpServletRequest request) {
		return isAjaxRequest(request.getHeader("X-Requested-With"));
	}
}
