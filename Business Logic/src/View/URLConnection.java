package View;
import java.io.*; 
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class URLConnection {
  
  private static String url = "http://52.36.156.222:3000/user/signin";
  
  public static void main(String[] args) throws Exception{
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try{
        HttpGet httpGet = new HttpGet(url);
        System.out.println("executing request " + httpGet.getURI());
        
        ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
        
        public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException{
          int status = response.getStatusLine().getStatusCode();
          if (status >= 200 && status <300){
            HttpEntity entity = response.getEntity();
            return entity !=null ? EntityUtils.toString(entity) : null;
          } 
          else {
            throw new ClientProtocolException("Unexpected response status: " + status);
          }
        }
      };
      String responseBody = httpclient.execute(httpGet,responseHandler);
      System.out.println("-------------------------------------------");
      System.out.println(responseBody);
      System.out.println("-------------------------------------------");
    }
    finally{
      httpclient.close();
    }
  }
}
