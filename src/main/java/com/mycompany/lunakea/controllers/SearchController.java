package com.mycompany.lunakea.controllers;

import com.mycompany.lunakea.common.SearchConst;
import com.mycompany.lunakea.model.Product;
import com.mycompany.lunakea.common.ViewConst;
import com.mycompany.lunakea.service.ProductService;
import com.mycompany.lunakea.service.RestConsumerService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SearchController {
    
    private static final String urlRs = "https://luna-factory.cleverapps.io/products";
    private static final String keyRs = "X-API-LunaFactory";
    private static final String valueRs = "lauriecoquillat:3ef8b347ca507e12";
    private static final String choice = null;

    @Autowired
    private RestConsumerService restConsumerService;

    @Autowired
    private ProductService productService;
    
    

    public SearchController() {
    }

    
    @RequestMapping(value = ViewConst.SEARCH_PRODUCT, method = RequestMethod.GET)
    public String searchProduct(Map<String, Object> model, @RequestParam(defaultValue = "", value = "keywords") String searchKeywords,
            @RequestParam(defaultValue = "", value = "attributeSearch") String attributeSearch,
            @RequestParam(defaultValue ="", value ="choice") String choice) {
                
        //Affichage de la liste de produits à partir du webService
        try {
            List<Product> rProducts = Arrays.asList(restConsumerService.consumeService(urlRs, keyRs, valueRs));
            System.out.println("liste venant du webService>>>>>"+rProducts);
            if (rProducts.isEmpty()) {
                model.put("infoMessage", "No product on display");
            } else {
                model.put("rProducts", rProducts);
                try {
                  productService.saveProductsFromRest(rProducts);   
                }catch (Exception e){
                  model.put("errorMessage", "Impossible d'enregistrer en base");
                  System.out.println("DB ERROR ENTITY MANAGER");
                }                               
            }
            
        } catch (Exception e) {
            model.put("errorMessage", "Impossible d'accéder au webService");
        }
        
        
        //Récupération de la saisie utilisateur
        if (StringUtils.isNotBlank(searchKeywords)) {
            searchKeywords = searchKeywords.trim();
        }
        model.put("keywords", searchKeywords);

        //Gestion des restrictions saisie utilisateur
        boolean doIt = true;

        if (StringUtils.isBlank(searchKeywords)) {
            model.put("search", false);
            doIt = false;
        } else if (searchKeywords.trim().length() < SearchConst.SEARCH_PRODUCTS_MIN_CHARACTERS_KEYWORDS) {
            model.put("error", "keywords length too short");
            doIt = false;
        }

        if (doIt) {
            //Récupération des utilisateurs selon la saisie
            List<Product> products = productService.searchByKeywords(attributeSearch, searchKeywords.trim());
            model.put("maxResult", SearchConst.SEARCH_OBJECTS_MAX_RESULTS + 1);
            model.put("products", products);
            model.put("attributeSearch", attributeSearch);
            model.put("search", true);
            
        }
        boolean doIt2 = true;
        //gestion de l'espace dédié aux tris dans la recherche
        if (StringUtils.isBlank(choice)){
            model.put("tri",false);
            doIt2 = false;
        }else{
            model.put("choice", choice);
            List<Product> products2 = productService.trisProduct((List) model.get("products"), choice);
            model.put("products",products2);
        }

        return "searchProduct";
    }

}
