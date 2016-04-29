package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import model.Couponbook;

/**
 * Session Bean implementation class couponsEJB
 */
@PersistenceContext(
	    name="persistence/LuxuryAppMgr",
	    unitName="LuxuryAppDB"  
	)
@Stateless
@LocalBean
public class CouponsEJB {
	EJBContext ejbContext;
	   @PersistenceUnit(unitName = "LuxuryAppDB")
	    private EntityManagerFactory entityManagerFactory;
//    @PersistenceContext(unitName = "LuxuryAppDB")
//    private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public CouponsEJB() {
        // TODO Auto-generated constructor stub
    }
    public List<Couponbook> getAllCoupons() {
    	List<Couponbook> results = new ArrayList<Couponbook>();
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
	    TypedQuery<Couponbook> query = entityManager.createNamedQuery("Couponbook.findAll", Couponbook.class);
	    results = query.getResultList();
    	return results;
    }

}
