package de.gedoplan.docker_workshop.rest_demo.service;

import de.gedoplan.docker_workshop.rest_demo.domain.Person;

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
	
	public List<Person> findAll() {
		return em.createQuery("select p from Person p",Person.class).getResultList();
	}
	
	public void persist(Person person) {
		em.persist(person);
	}

}
