package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.shared.FactoryManadger;

public class MagazineDaoImpl implements MagazineDao{
	
	private EntityManager em = FactoryManadger.getEntityManager();
	
	@Override
	public Magazine create(Magazine magazine) {		
		try {
			em.getTransaction().begin();
			em.persist(magazine);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
			return magazine;
	}

	@Override
	public Magazine read(Integer id) {		
		Magazine magazine = null;
		try {
			magazine = em.find(Magazine.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return magazine;
	}
	
	@Override
	public Magazine readByIsbn(String isbn) {		
		Magazine magazine = null;
		
		return magazine;
	}

	@Override
	public Magazine update(Magazine magazine) {
		
		return magazine;
	}

	@Override
	public void delete(Integer id){		
		
	}
	
	/*public List<Magazine> readAll() {			
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM magazine e");
			System.out.println(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		query.getResultList();			
		return (List<Magazine>) query.getResultList();
	}*/
	
	@Override
	public List<Magazine> readAll() {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Magazine> cq = cb.createQuery(Magazine.class);
	    Root<Magazine> rootEntry = cq.from(Magazine.class);
	    CriteriaQuery<Magazine> all = cq.select(rootEntry);
	 
	    TypedQuery<Magazine> allQuery = em.createQuery(all);
	    
	    return allQuery.getResultList();
	}

}
