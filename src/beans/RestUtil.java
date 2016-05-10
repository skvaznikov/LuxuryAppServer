package beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import model.Coupon;


/**
 * Session Bean implementation class RestUtil
 */
@ManagedBean(name = "couponController")
@RequestScoped
public class RestUtil {

    /**
     * Default constructor. 
     */
	private HttpClient httpClient = null;
	public Coupon coupon = null;
	private String file = new String();
	
    public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public RestUtil() {
    	httpClient = HttpClientBuilder.create().build();
    	coupon = new Coupon();
    }
    public String getData() {
    	
    	HttpGet httpget = new HttpGet("http://localhost:8080/LuxuryApp/rest/demo/allCoupons");
    	List<Coupon> coupons = new ArrayList<Coupon>();
        URL url;
		try {
			url = new URL("http://localhost:8080/LuxuryApp/rest/demo/allCoupons");
		
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			httpClient.execute(httpget);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            JSONArray jArray = new JSONArray(bufferedReader.readLine());
            int i;
            for(i=0; i < jArray.length(); i++) {

                JSONObject jObject = jArray.getJSONObject(i);
                Coupon coupon = new Coupon();
                coupon.setName(jObject.getString("name"));
                coupon.setDescription(jObject.getString("bezeichnung"));
                coupons.add(coupon);

            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
    		return coupons.get(0).getName();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return coupons.get(0).getName();
    }
    
    public void createCoupon() {
    	 HttpPut putRequest = new HttpPut("http://localhost:8080/LuxuryApp/rest/demo/addCoupon?name=" + coupon.getName() + "&bezeichnung=" + coupon.getDescription() + "&location=" + coupon.getLocation());
		try {

			httpClient.execute(putRequest);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

}
