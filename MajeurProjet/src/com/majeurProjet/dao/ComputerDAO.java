package com.majeurProjet.dao;

import java.util.List;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Computer;

public class ComputerDAO {

	public void SaveUpdateComputer(Computer computer)
	{
		HibernateUtil.getSession().saveOrUpdate(computer);
	}
	
	public void DeleteComputer(Computer computer)
	{
		HibernateUtil.getSession().delete(computer);
	}
	
	public List<Computer> ListComputer()
	{
		return HibernateUtil.getSession().createQuery("from Computer").getResultList();
	}
}
