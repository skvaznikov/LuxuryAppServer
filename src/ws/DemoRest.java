package ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.Coupon;
import model.Couponbook;
import beans.CouponsEJB;
@Stateless
@Path("/demo")
public class DemoRest {

@Inject CouponsEJB cejb;
	@GET
	@Path("allCoupons")
	//@Produces(MediaType.WILDCARD)
	public JsonArray  allCoupons() {
		List<Coupon> list = cejb.getAllCoupons();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Coupon coup : list) {
			jab.add(Json.createObjectBuilder()
	            .add("name", coup.getName())
	            .add("bezeichnung", coup.getDescription())
	            .add("location", coup.getLocation())
			    .add("bezeichnung_lang", coup.getDescription_long()==null?"":coup.getDescription_long()));
	    }
		JsonArray ja = jab.build();
		return ja;
	}
	
	@GET
	@Path("localeCoupons")
	public JsonArray  getLocaleCoupons(@QueryParam("city") String city) {
		List<Coupon> list = cejb.getLocaleCoupons(city);
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for(Coupon coup : list) {
			jab.add(Json.createObjectBuilder()
	            .add("name", coup.getName())
	            .add("bezeichnung", coup.getDescription())
	            .add("location", coup.getLocation())
			    .add("bezeichnung_lang", coup.getDescription_long()==null?"":coup.getDescription_long()));
	    }
		JsonArray ja = jab.build();
		return ja;
	}
	
	@PUT
	@Path("addCoupon")
	public void  addCoupon(@QueryParam("name") String name, @QueryParam("bezeichnung") String bez, @QueryParam("location") String loc) {
		cejb.addNewCoupon(name, bez, loc);
	}

	@Path("greetings")
	@GET
	public String  hallo() {
		return "Hallo Zaitschik!";
	}
}
