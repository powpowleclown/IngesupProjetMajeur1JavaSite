package com.majeurProjet.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.majeurProjet.dao.RoleDAO;
import com.majeurProjet.dao.RoomDAO;
import com.majeurProjet.metier.Role;
import com.majeurProjet.metier.Room;




@Path("/room_rest")
public class RoomRest {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMesRessources() {
		// le service retourne une liste de ressoure List et un code HTTP 200
		GenericEntity< List< Room > > entity = new GenericEntity< List< Room > >(RoomDAO.ListRoom()) {};
		return Response.ok(entity).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaRessourceParId(@PathParam("id") String id) {
		
		// le service retourne une ressoure : MaRessource et un code HTTP 200
		return Response.ok((RoomDAO.getRoom(Integer.parseInt(id)))).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMaRessource(Room room) {
		// le service cr�e une ressoure MaRessource, retourne l'ID de la ressource et un code HTTP 201
		RoomDAO.SaveUpdateRoom(room);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
    @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMaRessource(@PathParam("id") String id, Room room) {
		// le service met � jour une ressoure MaRessource, retourne la ressource et un code HTTP 200
		RoomDAO.SaveUpdateRoom(room);
		return Response.ok(room).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMaRessource(@PathParam("id") String id) {
		// le service supprime une ressoure MaRessource et retourne un code HTTP 204
		RoomDAO.DeleteRoomById(Integer.parseInt(id));
		return Response.status(Status.NO_CONTENT).build();
	}

	
}