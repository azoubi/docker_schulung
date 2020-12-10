package de.gedoplan.docker_workshop.exercise.resources;

import de.gedoplan.docker_workshop.exercise.domain.Person;
import de.gedoplan.docker_workshop.exercise.service.PersonenRepository;

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
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class PersonenResource {

  @Inject
  private PersonenRepository personenRepository;

  @GET
  public List<Person> findAll() {
    return this.personenRepository.findAll();
  }

  @POST
  public void save(Person person) {
    this.personenRepository.persist(person);
  }
}
