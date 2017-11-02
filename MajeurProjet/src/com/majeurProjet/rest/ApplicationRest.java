package com.majeurProjet.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ApplicationRest extends Application {

	private Set<Class<?>> ressources = new HashSet<Class<?>>();
	private Set<Object> singletons = new HashSet<Object>();
	
	public ApplicationRest()
	{
		ressources.add(RoleRest.class);
		ressources.add(ComputerRest.class);
		ressources.add(IncidentRest.class);
		ressources.add(RoomRest.class);
		ressources.add(StateRest.class);
		ressources.add(UserRest.class);
	}
	
	@Override
	public Set<Class<?>> getClasses(){
		return ressources;
	}
	@Override
	public Set<Object> getSingletons()
	{
		return singletons;
	}
}
