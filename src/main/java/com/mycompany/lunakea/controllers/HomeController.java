package com.mycompany.lunakea.controllers;
 
import com.mycompany.lunakea.common.ViewConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    public HomeController() {
    }
        
    
 @RequestMapping(value = ViewConst.HOME, method = RequestMethod.GET)
    public String viewHome(){
        return "home";
    }
    
 

}