 package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.Employee;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll",Employee.class);
		return query.getResultList();
		
	}

	@Override
	public Employee findOne(String id) {
		return em.find(Employee.class, id);
		
	}

	@Override
	public Employee findByEmail(String email)
	{
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findByEmail",Employee.class);
		query.setParameter("pEmail", email);
		List<Employee> employee = query.getResultList();
		if(employee != null &&  employee.size() == 1)
		{
			return employee.get(0);
		}
		else
		return null;
			
		
	}
	
	@Override
	public Employee Create(Employee e) {
		em.persist(e);
		return e;
	}

	@Override
	public Employee update(Employee e) {
		
		return em.merge(e);
	}

	@Override
	public void delete(Employee e) {
	
		em.remove(e);
	}

}
