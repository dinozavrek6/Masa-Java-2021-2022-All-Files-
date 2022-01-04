package Lesson6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ProxyHttpClient extends Thread 
{

  public void run()
  {
    // Create a client:
    HttpClient httpClient = HttpClient.newHttpClient();

    // Create a request:
    HttpRequest httpReq = HttpRequest.newBuilder(URI.create("http://example.com"))
        .header("accept", "*/*").build();

    // Use the client to send the request:
    HttpResponse<String> httpRes = null;    


    try {
      httpRes = httpClient.send(httpReq, BodyHandlers.ofString());
    } catch (InterruptedException interruptedException) {
      System.out.println("InterruptedException!");
    }
    catch (IOException ioException)
    {
      System.out.println("IOException!");
    }
    
    String resBody = httpRes.body();

    // the response:
    System.out.println(resBody);
  }
  
}