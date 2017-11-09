package com.majeurProjet.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.majeurProjet.dao.ComputerDAO;
import com.majeurProjet.dao.IncidentDAO;
import com.majeurProjet.dao.StateDAO;
import com.majeurProjet.metier.Computer;
import com.majeurProjet.metier.HistoricalIncident;
import com.majeurProjet.metier.Incident;
import com.majeurProjet.metier.Rapport;
import com.majeurProjet.metier.State;

public class MulticastSender {
	
	public static void MulticastSenderMain() 
	{
	    DatagramSocket socket = null;
	    DatagramPacket outPacket = null;
	    DatagramPacket inPacket = null;
	    byte[] outBuf = new byte[1000];
	    byte[] inBuf = new byte[1000];
	    final int PORT = 8888;
	    InetAddress address = null;
	    try {
	      socket = new DatagramSocket();
	      socket.setSoTimeout(60000);
	      String outmsg;
	 
	      while (true) 
	      {
	    	  outmsg = "PING";
	        List<Computer> computers = ComputerDAO.ListComputer();
	        for(Computer computer : computers)
	        {
	            //Send to multicast IP address and port
		        address = InetAddress.getByName(computer.getIp());
		        outBuf = outmsg.getBytes();
		        outPacket = new DatagramPacket(outBuf, outBuf.length, address, PORT);
		        socket.send(outPacket);	 
	        } 
	        
	        inPacket = new DatagramPacket(inBuf, inBuf.length);
	        socket.receive(inPacket);
	        
	        String inmsg = new String(inBuf, 0, inPacket.getLength());
            String[] inmsgsplit = inmsg.split("-");
	        switch(inmsgsplit[0])
	        {
	        	case "PING":
	        		System.out.println(inmsgsplit[1]);
	        		break;
	        	case "DATA":
	        		ObjectMapper mapper = new ObjectMapper();
	        		Rapport rapport = mapper.readValue(inmsgsplit[1], Rapport.class);
	        		break;
	        	default:
	        		System.out.println("ERROR");
	        		break;
	        }
	   
	        try 
	        {
	          Thread.sleep(60000);
	        } 
	        catch (InterruptedException ie) 
	        {
	        }
	      }
	    } 
	    catch (Exception ioe) 
	    {
	      System.out.println(ioe);
	      Incident incident = new Incident();
  		  HistoricalIncident historical = new HistoricalIncident();
		  historical.setIncident(incident);
		  Calendar calendar = Calendar.getInstance();
		  historical.setDate(new Date(calendar.getTime().getTime()));
		  State state = StateDAO.getStateByNameAndTable("Offline", "Computer");
		  historical.setState(state);
		  incident.getHistoricals_i().add(historical);		
		  incident.setNumber("Test");
		  incident.setDescription(ioe.getMessage());
		  Computer computer = ComputerDAO.getComputerByIp(address.toString());
		  incident.setComputer(computer);
		  
		  IncidentDAO.SaveUpdateIncident(incident);
	    } 
     
	  }
	
	
	public static void MulticastSenderUser(String msg) 
	{
	    DatagramSocket socket = null;
	    DatagramPacket outPacket = null;
	    DatagramPacket inPacket = null;
	    byte[] outBuf = new byte[1000];
	    byte[] inBuf = new byte[1000];
	    final int PORT = 8888;
	    InetAddress address = null;
	    try {
	      socket = new DatagramSocket();
	      socket.setSoTimeout(60000);
	      String outmsg;
	 
	      while (true) 
	      {
	    	  outmsg = msg;
	        List<Computer> computers = ComputerDAO.ListComputer();
	        for(Computer computer : computers)
	        {
	            //Send to multicast IP address and port
		        address = InetAddress.getByName(computer.getIp());
		        outBuf = outmsg.getBytes();
		        outPacket = new DatagramPacket(outBuf, outBuf.length, address, PORT);
		        socket.send(outPacket);	 
	        } 
	        
	        inPacket = new DatagramPacket(inBuf, inBuf.length);
	        socket.receive(inPacket);
	        
	        String inmsg = new String(inBuf, 0, inPacket.getLength());
            String[] inmsgsplit = inmsg.split("-");
	        switch(inmsgsplit[0])
	        {
	        	case "PING":
	        		System.out.println(inmsgsplit[1]);
	        		break;
	        	case "DATA":
	        		ObjectMapper mapper = new ObjectMapper();
	        		Rapport rapport = mapper.readValue(inmsgsplit[1], Rapport.class);
	        		break;
	        	default:
	        		System.out.println("ERROR");
	        		break;
	        }
	   
	        try 
	        {
	          Thread.sleep(60000);
	        } 
	        catch (InterruptedException ie) 
	        {
	        }
	      }
	    } 
	    catch (Exception ioe) 
	    {
	      System.out.println(ioe);
	      Incident incident = new Incident();
  		  HistoricalIncident historical = new HistoricalIncident();
		  historical.setIncident(incident);
		  Calendar calendar = Calendar.getInstance();
		  historical.setDate(new Date(calendar.getTime().getTime()));
		  State state = StateDAO.getStateByNameAndTable("Offline", "Computer");
		  historical.setState(state);
		  incident.getHistoricals_i().add(historical);		
		  incident.setNumber("Test");
		  incident.setDescription(ioe.getMessage());
		  Computer computer = ComputerDAO.getComputerByIp(address.toString());
		  incident.setComputer(computer);
		  
		  IncidentDAO.SaveUpdateIncident(incident);
	    } 
     
	  }
}
