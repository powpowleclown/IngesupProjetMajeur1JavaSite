package com.majeurProjet.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.majeurProjet.dao.UserDAO;
import com.majeurProjet.metier.User;




@Path("/user_rest")
public class UserRest {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMesRessources() {
		// le service retourne une liste de ressoure List et un code HTTP 200
		return Response.ok(UserDAO.ListUser()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMaRessourceParId(@PathParam("id") String id) {
		
		// le service retourne une ressoure : MaRessource et un code HTTP 200
		return Response.ok((UserDAO.getUser(Integer.parseInt(id)))).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMaRessource(User user) {
		// le service crée une ressoure MaRessource, retourne l'ID de la ressource et un code HTTP 201
		UserDAO.SaveUpdateUser(user);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
    @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMaRessource(@PathParam("id") String id, User user) {
		// le service met à jour une ressoure MaRessource, retourne la ressource et un code HTTP 200
		UserDAO.SaveUpdateUser(user);
		return Response.ok(user).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMaRessource(@PathParam("id") String id) {
		// le service supprime une ressoure MaRessource et retourne un code HTTP 204
		UserDAO.DeleteUserById(Integer.parseInt(id));
		return Response.status(Status.NO_CONTENT).build();
	}

	
}