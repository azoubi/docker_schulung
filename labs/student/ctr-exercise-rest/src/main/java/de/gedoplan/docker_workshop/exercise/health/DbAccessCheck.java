package de.gedoplan.docker_workshop.exercise.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
@Liveness
@Readiness
public class DbAccessCheck implements HealthCheck {

  // @Inject
  // PersonenRepository personenRepository;

  @Override
  public HealthCheckResponse call() {
    boolean dbIsAvailable = false;
    try {
      // this.personenRepository.countAll();
      dbIsAvailable = true;
    } catch (Exception e) {
      // ignore
    }

    return HealthCheckResponse
        .named("dbIsAvailable")
        .state(dbIsAvailable)
        .build();
  }

}
