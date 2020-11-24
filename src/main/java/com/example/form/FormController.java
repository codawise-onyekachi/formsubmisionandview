package com.example.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/home")
    public String educate(){
        //return "educate.jsp";
        return "index.html";
    }

    @RequestMapping("/details")
    public String details(Customers customers){
        //return "educate.jsp";
        customerRepository.save(customers);
        return "index.html";
    }

    @RequestMapping("/getdetails")
    public String getdetails(){
        //return "educate.jsp";
        return "viewCustomerPage.html";
    }


    @PostMapping("/getdetails")
    public ModelAndView getdetails(@RequestParam Long cid){

        ModelAndView mv = new ModelAndView("Retrieve.html");
        Customers customers = customerRepository.findById(cid).orElse(null);
        mv.addObject(customers);
        return mv;
    }
}
