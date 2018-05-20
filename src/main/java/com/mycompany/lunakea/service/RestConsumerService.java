
package com.mycompany.lunakea.service;

import com.mycompany.lunakea.DAO.ProductRepository;
import com.mycompany.lunakea.model.Product;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestConsumerService {
    
    
    @Autowired
    private ProductRepository productRepository;

    public RestConsumerService() {
    }
    
    
    
    public static Product[] consumeService (String url, String key, String value){
        Client client = ClientBuilder.newClient();
        
        Response response = client.target(url).request().header(key, value).get();
        Product[] products = response.readEntity(Product[].class);
        
        response.close();
        client.close();
        
        return products;
    }
    
    
    
}
