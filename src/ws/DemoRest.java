package ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import model.Couponbook;
import beans.CouponsEJB;
@Stateless
@Path("/demo")
public class DemoRest {

@Inject CouponsEJB cejb;
	@GET
	@Path("allCoupons")
	//@Produces(MediaType.TEXT_PLAIN)
	public List<Couponbook>  allCoupons() {
		List<Couponbook> list = cejb.getAllCoupons();
		String ret = null;
		for(Couponbook bez : list) {
			ret  = bez.getDescription();
		}
		return list;
	}

	@Path("greetings")
	@GET
	public String  hallo() {
		return "Hallo Zaitschik!";
	}
}
