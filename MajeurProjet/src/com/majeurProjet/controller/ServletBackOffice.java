package com.majeurProjet.controller;

import java.io.IOException;

import javax.servlet.ServletException;

public class ServletBackOffice extends UtilHttpServlet {
	
	
	public void Home()
	{
		super.displayView(null);
	}
	
	protected void displayView(Object model)
	{
		if(model != null)
		{
			req.setAttribute("model", model);
		}
		String controller = this.getClass().getSimpleName();
		controller = controller.substring(controller.lastIndexOf("Servlet") +7).toLowerCase();
		
		String viewName = action.substring(1);
		System.out.println(viewName);
		final String pathcomplet = path + "backoffice/" + controller + "/" + viewName + ".jsp";
		try {
			this.getServletContext().getRequestDispatcher(pathcomplet).forward(req, resp);
		} catch (ServletException e) {
			try {
				resp.sendError(405,"La vue " + viewName + " est introuvable");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	protected void displayView(final String viewName, final String controllerName)
	{
		
		String controller = controllerName!=null ? controllerName : null;
		if(controller == null) 
		{
			controller = this.getClass().getSimpleName();
		}
			controller = controller.substring(controller.lastIndexOf("Servlet") +7).toLowerCase();
		
		final String pathcomplet = path + "backoffice/" + controller + "/" + viewName + ".jsp";
		try {
			this.getServletContext().getRequestDispatcher(pathcomplet).forward(req, resp);
		} catch (ServletException e) {
			try {
				resp.sendError(405,"La vue " + viewName + " est introuvable");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
