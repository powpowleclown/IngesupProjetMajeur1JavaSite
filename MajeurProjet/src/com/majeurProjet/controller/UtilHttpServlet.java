package com.majeurProjet.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class UtilHttpServlet extends HttpServlet {

	private static String path = "/WEB-INF/views/";
	public String action ="";
	protected HttpServletRequest req = null;
	protected HttpServletResponse resp = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		this.req = req;
		this.resp = resp;
		this.action = req.getPathInfo();
		if(action == null && this.action.equals("/"))
		{
			action = "/Index";
		}
		try {
			this.getClass().getMethod(action.substring(1)).invoke(this);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			action = "/Index";
			try {
				this.getClass().getMethod(action.substring(1)).invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e1) {
				resp.sendError(404,"La methode " + action.substring(1) + " n'existe pas");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		this.req = req;
		this.resp = resp;
		this.action = req.getPathInfo();
		try {
			this.getClass().getMethod(action.substring(1)).invoke(this);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			resp.sendError(404,"La methode " + action.substring(1) + " n'existe pas");
		}
	}
	
	protected void displayView(Object model)
	{
		if(model != null)
		{
			req.setAttribute("model", model);
		}
		String controller = this.getClass().getSimpleName();
		controller = controller.substring(controller.lastIndexOf("Servlet") +7).toLowerCase();
		
		String viewName = action;
		System.out.println(viewName);
		final String pathcomplet = path + controller + "/" + viewName + ".jsp";
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
		
		final String pathcomplet = path + controller + "/" + viewName + ".jsp";
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
	
	protected String getParam(final String name)
	{
		return this.req.getParameter(name) != null ? req.getParameter(name).toString() : "";
	}
	
	protected Integer getParamAsInt(final String name)
	{
		final String param = getParam(name);
		try {
			return Integer.parseInt(param);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	protected Float getParamAsFloat(final String name)
	{
		final String param = getParam(name);
		try {
			return Float.parseFloat(param);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	protected Boolean isPostBack()
	{
	     return  "POST".equalsIgnoreCase(req.getMethod());
	}
	
	protected void redirect(String url)
	{
		url = req.getContextPath() + url;
		try {
			resp.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
