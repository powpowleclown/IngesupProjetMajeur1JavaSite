package com.majeurProjet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.majeurProjet.db.HibernateUtil;

public class FilterHibernate implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HibernateUtil.getSession();
		arg2.doFilter(arg0, arg1);
		if(HibernateUtil.getSession().getTransaction().isActive()) {
			try
			{
				HibernateUtil.getSession().getTransaction().commit();
				
			}
			catch(Exception e)
			{
				HibernateUtil.getSession().getTransaction().rollback();
			}
			finally
			{
				if(HibernateUtil.getSession().isOpen())
				{
					HibernateUtil.getSession().close();
				}
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
