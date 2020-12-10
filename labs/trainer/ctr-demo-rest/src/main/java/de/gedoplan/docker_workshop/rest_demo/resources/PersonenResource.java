package de.gedoplan.docker_workshop.rest_demo.resources;

import de.gedoplan.docker_workshop.rest_demo.domain.Person;
import de.gedoplan.docker_workshop.rest_demo.service.PersonenRepository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/personen")
@Produces(value=MediaType.APPLICATION_JSON)
@Consumes(value=MediaType.APPLICATION_JSON)
public class PersonenResource {

	@Inject
	private PersonenRepository personenRepository;
	
	@GET
	public List<Person> findAll() {
		return personenRepository.findAll();
	}
	
	@POST
	public void save(Person person) {
		personenRepository.persist(person);
	}
}
