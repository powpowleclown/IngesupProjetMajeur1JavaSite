package com.majeurProjet.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.sql.Timestamp;
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

public class MulticastSender implements Runnable {
	
	Thread mythread;
    DatagramSocket socket;
    DatagramPacket outPacket;
    DatagramPacket inPacket ;
    byte[] outBuf;
    byte[] inBuf;
    final int PORT = 8888;
    InetAddress address;

	public MulticastSender() 
	{
	    socket = null;
	    outPacket = null;
	    inPacket = null;
	    outBuf = new byte[1000];
	    inBuf = new byte[1000];
	    address = null;
	    mythread = new Thread(this,"MulticastSender");
	    mythread.start(); 
	  }

	@Override
	public void run() {
		// TODO Auto-generated method stub
      List<Computer> computers = ComputerDAO.ListComputer();
        for(Computer computer : computers)
        {
		 try {
		      socket = new DatagramSocket();
		      socket.setSoTimeout(60000);
		      String outmsg;
		      
		      while (true) 
		      {
		    	  	outmsg = "PING";
		    	  	System.out.println("OUT "+outmsg);
		            //Send to multicast IP address and port
			        address = InetAddress.getByName(computer.getIp());
			        outBuf = outmsg.getBytes();
			        outPacket = new DatagramPacket(outBuf, outBuf.length, address, PORT);
			        socket.send(outPacket);	 
			        
			        inPacket = new DatagramPacket(inBuf, inBuf.length);
			        socket.receive(inPacket);   
			        String inmsg = new String(inBuf, 0, inPacket.getLength());
		            String[] inmsgsplit = inmsg.split("-");
			        switch(inmsgsplit[0].toUpperCase())
			        {
			        	case "PING":
			        		System.out.println("TEST "  +inmsgsplit[1] + " " + inmsgsplit[2]);
			        		if(!(computer.getIp().equals(inmsgsplit[1]) && computer.getMac().equals(inmsgsplit[2])))
			        		{
			        			throw new Exception("Wrong combinaison IP/MAC");
			        		}
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
		    	
		      int incidentCount = IncidentDAO.ListIncident().size();
		      System.out.println(ioe);
		      Incident incident = new Incident();
	  		  HistoricalIncident historical = new HistoricalIncident();
			  historical.setIncident(incident);
			  Date date = new Date();
			  historical.setDate(new Timestamp(date.getTime()));
			  State state = StateDAO.getStateByNameAndTable("Offline", "Computer");
			  historical.setState(state);
			  incident.getHistoricals_i().add(historical);		
			  incident.setNumber("Number "+incidentCount);
			  incident.setDescription(ioe.getMessage());
			  //Computer computer = ComputerDAO.getComputerByIp(address.toString());
			  incident.setComputer(computer);
			  
			  IncidentDAO.SaveUpdateIncident(incident);
		    } 
        }
	}
}
