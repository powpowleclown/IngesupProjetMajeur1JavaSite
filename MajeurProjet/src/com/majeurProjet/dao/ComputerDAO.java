package com.majeurProjet.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.majeurProjet.db.HibernateUtil;
import com.majeurProjet.metier.Computer;

public class ComputerDAO {

	public static void SaveUpdateComputer(Computer computer)
	{
		HibernateUtil.getSession().saveOrUpdate(computer);
	}
	
	public static void DeleteComputer(Computer computer)
	{
		HibernateUtil.getSession().delete(computer);
	}
	
	public static void DeleteComputerById(int id_computer)
	{
		Computer computer = getComputer(id_computer);
		HibernateUtil.getSession().delete(computer);
	}
	
	public static List<Computer> ListComputer()
	{
		return HibernateUtil.getSession().createQuery("from Computer").getResultList();
	}
	
	public static Computer getComputer(int id_computer)
	{
		Computer computer;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Computer C WHERE C.id=?");
			query.setParameter(0, id_computer);
			computer = (Computer) query.getSingleResult();
		}
		catch(Exception e)
		{
			computer = null;
		}

		return computer;
	}
	public static Computer getComputerByIp(String ip_computer)
	{
		Computer computer;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Computer C WHERE C.ip=?");
			query.setParameter(0, ip_computer);
			computer = (Computer) query.getSingleResult();
		}
		catch(Exception e)
		{
			computer = null;
		}

		return computer;
	}
	
	public static Computer getComputerByName(String name) {
		Computer computer;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Computer C WHERE C.name=?");
			query.setParameter(0, name);
			computer = (Computer) query.getSingleResult();
		}
		catch(Exception e)
		{
			computer = null;
		}

		return computer;
	}
	
	public static Computer getComputerByMac(String mac) {
		Computer computer;
		try
		{
			Query query = HibernateUtil.getSession().createQuery("FROM Computer C WHERE C.mac=?");
			query.setParameter(0, mac);
			computer = (Computer) query.getSingleResult();
		}
		catch(Exception e)
		{
			computer = null;
		}

		return computer;
	}
	
	public static boolean computerNameAlreadyExists(String name) {
		if(getComputerByName(name) != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean computerIpAlreadyExists(String ip) {
		if(getComputerByIp(ip) != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean computerMacAlreadyExists(String mac) {
		if(getComputerByMac(mac) != null) {
			return true;
		}else {
			return false;
		}
	}
}
