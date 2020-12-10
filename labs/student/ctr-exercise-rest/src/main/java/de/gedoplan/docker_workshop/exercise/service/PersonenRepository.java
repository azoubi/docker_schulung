package de.gedoplan.docker_workshop.exercise.service;

import de.gedoplan.docker_workshop.exercise.domain.Person;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PersonenRepository {

  @PersistenceContext
  private EntityManager em;

  public long countAll() {
    return this.em.createQuery("select count(p) from Person p", Long.class).getSingleResult();
  }

  public List<Person> findAll() {
    return this.em.createQuery("select p from Person p", Person.class).getResultList();
  }

  public void persist(Person person) {
    this.em.persist(person);
  }

}
