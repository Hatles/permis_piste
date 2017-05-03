package com.polytech.permis_piste.error;

import com.polytech.permis_piste.support.web.Ajax;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

/**
 * General error handler for the application.
 */
@ControllerAdvice
class ExceptionHandler {

	/**
	 * Handle exceptions thrown by handlers.
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)	
	public ModelAndView exception(Exception exception, WebRequest request) {
		String view = "error/general";
		if(Ajax.isAjaxRequest(request))
			view = "error/generalAjax";
		ModelAndView modelAndView = new ModelAndView(view);
		modelAndView.addObject("errorMessage", Throwables.getRootCause(exception));
		return modelAndView;
	}
}