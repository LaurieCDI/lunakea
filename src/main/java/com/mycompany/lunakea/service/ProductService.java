package com.mycompany.lunakea.service;

import com.mycompany.lunakea.model.Product;
import com.mycompany.lunakea.DAO.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.regex.Pattern;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductService() {
    }
    
    //Enregistrement dans la base de données
    public void saveProductsFromRest (List<Product> products){
        
        for (Product product : products) {
         System.out.println(product);
         productRepository.saveProduct(product);   
        }
    }

    // Méthode de recherche 
    public List<Product> searchByKeywords(String attributeSearch, String keywords) {

        List<Product> products = new ArrayList();
        //Appel de la méthode de recherche DAO correspondant au type de recherche choisi
        if (attributeSearch.equals("texte")) {
            products = productRepository.findByKeyword(keywords);
        }
        if (attributeSearch.equals("ean")) {
            products = productRepository.findByEan(keywords);
        }
        if (attributeSearch.equals("id")) {
            products = productRepository.findById(Long.parseLong(keywords));
        } else {
            return products;
        }

        return products;
    }

    //Méthode de tri de la liste de produits
    public List<Product> trisProduct(List<Product> products, String choice) {

        if (choice.equals("prix")) {
            Collections.sort(products, Product.ComparatorPrice);
        }
        if (choice.equals("assembled")) {
            for (Product product : products) {
                if (!product.isAssembled()) {
                    products.remove(product);
                }
            }
        }

        return products;
    }

    //Compte du nombre d'occurrences dans la recherche
    public int occurrences(Product product, String keyword) {
        String str1 = product.getDescription();
        String str2 = product.getName();

        int count = ((str1.split(Pattern.quote(keyword), -1).length) - 1)+
                ((str2.split(Pattern.quote(keyword), -1).length) - 1);

        return count;
    }

}
