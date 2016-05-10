package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import model.Coupon;
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
    public List<Coupon> getAllCoupons() {
    	List<Coupon> results = new ArrayList<Coupon>();
 	   EntityManager entityManager = entityManagerFactory.createEntityManager();
	    TypedQuery<Coupon> query = entityManager.createNamedQuery("Coupon.findAll", Coupon.class);
	    results = query.getResultList();
    	return results;
    }
    
    public List<Coupon> getLocaleCoupons(String city) {
    	List<Coupon> results = new ArrayList<Coupon>();
 	   EntityManager entityManager = entityManagerFactory.createEntityManager();
	    TypedQuery<Coupon> query = entityManager.createNamedQuery("Coupon.findLocale", Coupon.class).setParameter("city", city);
	    results = query.getResultList();
    	return results;
    }

    public void addNewCoupon(String... params) {
    	Coupon newCoupon = new Coupon();
    	newCoupon.setName(params[0]);
    	newCoupon.setDescription(params[1]);
    	newCoupon.setLocation(params[2]);	   
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    //	EntityTransaction   tx = entityManager.getTransaction();
    //	tx.begin();   
    	entityManager.persist(newCoupon);
   // 	tx.commit();
    }
}
