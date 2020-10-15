package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ua.lviv.lgs.dao.MagazineUsersDao;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.MagazineUsers;
import ua.lviv.lgs.shared.FactoryManadger;

public class MagazineUsersDaoImpl implements MagazineUsersDao{
	
	private EntityManager em = FactoryManadger.getEntityManager();

	@Override
	public MagazineUsers create(MagazineUsers magazineUsers) {
		
		try {
			em.getTransaction().begin();
			em.persist(magazineUsers);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return magazineUsers;
	}

	@Override
	public MagazineUsers read(Integer id) {		
		return null;
	}	

	@Override
	public MagazineUsers update(MagazineUsers magazineUsers) {		
		throw new IllegalStateException("there is not update for bucket");
	}

	@Override
	public void delete(Integer id) {
	}
	
	public void delete(Integer userId, Integer magazine_id) {
	}

	@Override
	public List<MagazineUsers> readAll() {
	    CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<MagazineUsers> cq = cb.createQuery(MagazineUsers.class);
	    Root<MagazineUsers> rootEntry = cq.from(MagazineUsers.class);
	    CriteriaQuery<MagazineUsers> all = cq.select(rootEntry);
	 
	    TypedQuery<MagazineUsers> allQuery = em.createQuery(all);
	    
	    return allQuery.getResultList();
	}

	@Override
	public MagazineUsers read(String id) {
		MagazineUsers bucket = null;
		try {
			bucket = em.find(MagazineUsers.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return bucket;
	}

	@Override
	public void delete(String id) {
		
		try {
			MagazineUsers bucket = read(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
