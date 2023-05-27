package servlet_login_validation.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import servlet_login_validation.dto.EmpDto;

public class EmpDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public String create(EmpDto d1) {
		et.begin();
		em.persist(d1);
		et.commit();
		return "registration successfull";
	}

	public EmpDto login(String email) {
		EmpDto dt = em.find(EmpDto.class, email);
		return dt;
	}
}
