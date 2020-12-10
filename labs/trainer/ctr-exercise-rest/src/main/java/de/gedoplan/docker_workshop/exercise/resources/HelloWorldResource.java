package de.gedoplan.docker_workshop.exercise.resources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path("hello")
public class HelloWorldResource {

  @GET
  public String hello() {
    return "Hello World";
  }

}
