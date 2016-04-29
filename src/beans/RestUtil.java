package beans;

import java.io.IOException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


/**
 * Session Bean implementation class RestUtil
 */
@Stateless
@LocalBean
public class RestUtil {

    /**
     * Default constructor. 
     */
    public RestUtil() {
        // TODO Auto-generated constructor stub
    }
    public String getData() {
    	final HttpClient httpClient = HttpClientBuilder.create().build();
//    	HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 10000);
    	HttpGet httpget = new HttpGet("http://localhost:8080/LuxuryApp/rest/demo/allCoupons");
    	HttpResponse response = null;
		try {
			response = httpClient.execute(httpget);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			return EntityUtils.toString(response.getEntity());
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "Fehler";
    }

}
