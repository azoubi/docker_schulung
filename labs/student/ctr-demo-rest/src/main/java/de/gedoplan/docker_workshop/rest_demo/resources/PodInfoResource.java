package de.gedoplan.docker_workshop.rest_demo.resources;

import de.gedoplan.docker_workshop.rest_demo.domain.PodInfo;

import java.net.InetAddress;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@RequestScoped
@Path("/podInfo")
@Produces(value=MediaType.APPLICATION_JSON)
@Consumes(value=MediaType.APPLICATION_JSON)
public class PodInfoResource {

    @Inject @ConfigProperty(name = "NODE_NAME", defaultValue = "-")
    private String nodename;
    @Inject @ConfigProperty(name = "NAMESPACE", defaultValue = "-")
    private String namespace;
    @Inject @ConfigProperty(name = "POD_IP", defaultValue = "-")
    private String ip;
    @Inject @ConfigProperty(name = "POD_NAME", defaultValue = "-")
    private String podname;

    @GET
    public PodInfo getPodInfo() throws Exception {
        return new PodInfo(
            InetAddress.getLocalHost().getHostName(),
            nodename,
            namespace,
            ip,
            podname);
    }

}
