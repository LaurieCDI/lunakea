
package com.mycompany.lunakea.DAO;

import com.mycompany.lunakea.model.Product;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepository extends AbstractPersistenceRepo {
    
    
    public void saveProduct(Product product){
        em.persist(product);
        em.flush();
    }
    
    
    public List<Product> findById(Long id){

        Query qr = em.createNamedQuery("model.Product.findById");
        qr.setParameter("paramId", "%"+id+"%");
        List<Product> products = qr.getResultList();

        return products;
    }
    
    public List<Product> findByEan(String ean){

        Query qr = em.createNamedQuery("model.Product.findByEan");
        qr.setParameter("paramEan", "%"+ean+"%");
        List<Product> products = qr.getResultList();
        
        return products;
    }
    
    public List<Product> findByKeyword(String keyword){
       
        Query qr = em.createNamedQuery("model.Product.findByKeyword");
        qr.setParameter("paramKey", "%"+keyword+"%");
        List<Product> products = qr.getResultList();
        
        return products;
    }
        
}
