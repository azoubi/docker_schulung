package de.gedoplan.docker_workshop.exercise.resources;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("systemInfo")
@Produces(MediaType.APPLICATION_JSON)
public class SystemInfoResource {

  @PersistenceUnit(unitName = "exercise")
  EntityManagerFactory entityManagerFactory;

  @GET
  public JsonObject info() {
    return Json.createObjectBuilder()
        .add("java.vendor", System.getProperty("java.vendor"))
        .add("java.version", System.getProperty("java.version"))
        .add("os", System.getProperty("os.name") + " " + System.getProperty("os.version"))
        .add("user.name", System.getProperty("user.name"))
        .add("env.DATASOURCE", getEnvDatasource())
        .add("DB", getDbInfo())
        .build();
  }

  private String getEnvDatasource() {
    String envvar = System.getenv("DATASOURCE");
    return envvar != null ? envvar : "(unset)";
  }

  private String getDbInfo() {
    Connection connection = null;
    try {
      DataSource dataSource = (DataSource) this.entityManagerFactory.getProperties().getOrDefault("javax.persistence.jtaDataSource", "java:comp/DefaultDataSource");

      connection = dataSource.getConnection();
      if (connection == null) {
        return "(none)";
      }

      DatabaseMetaData metaData = connection.getMetaData();

      String url = "";
      try {
        url = metaData.getURL();
      } catch (Exception e) {
        // ignore
      }

      return metaData.getDatabaseProductName() + " " + metaData.getDatabaseProductVersion() + " " + url;
    } catch (Exception e) {
      return e.toString();
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
        // ignore
      }
    }
  }

}
