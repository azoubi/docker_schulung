package de.gedoplan.docker_workshop.rest_demo.resources;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@RequestScoped
@Path("modifiableFile")
public class ModifiableFileResource {

  @Inject
  @ConfigProperty(name = "MODIFIABLE_FILE", defaultValue = "/tmp/modifiablefile")
  private String filename;

  @GET
  public String get() throws IOException {
    java.nio.file.Path path = Paths.get(this.filename);
    if (!Files.exists(path)) {
      Files.write(path, ("Hello from " + InetAddress.getLocalHost()).getBytes());
    }
    return new String(Files.readAllBytes(path));
  }

  @PUT
  public void put(String content) throws IOException {
    Files.write(Paths.get(this.filename), content.getBytes());
  }
}
