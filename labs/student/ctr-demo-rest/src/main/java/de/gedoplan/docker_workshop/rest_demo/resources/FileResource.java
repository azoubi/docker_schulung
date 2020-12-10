package de.gedoplan.docker_workshop.rest_demo.resources;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path("textFile")
public class FileResource {

    @GET
    public String hello() throws Exception {
        return new String(Files.readAllBytes(Paths.get(System.getenv("DEMO_TEXT_FILE"))));
    }

}
