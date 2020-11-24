package com.example.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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
    //String metthod
    /*@RequestMapping("/customers")
    @ResponseBody
    public String getCustomers(){

        return customerRepository.findAll().toString();
    }

    @RequestMapping("/customers/{cid}")
    @ResponseBody
    public String getCustomers2(@PathVariable("cid") Long cid){

        return customerRepository.findById(cid).toString();
    }*/

    //Chang the string method to a list method
    @RequestMapping("/customers")
    @ResponseBody
    public List<Customers> getCustomers(){

        return customerRepository.findAll();
    }

    @RequestMapping("/customers/{cid}")
    @ResponseBody
    public Optional<Customers> getCustomers2(@PathVariable("cid") Long cid){

        return customerRepository.findById(cid);
    }

    @PostMapping("/customers")
    public Customers getCustomers3(@RequestBody Customers customers){

        customerRepository.save(customers);
        return customers;
    }

    @DeleteMapping("/customers/{cid}")
    public Customers getCustomers4(@PathVariable("cid") Long cid){

        Customers c = customerRepository.getOne(cid);
        customerRepository.delete(c);
        return c;
    }

    @PutMapping(path="/customers", consumes = {"application/json"})
    public Customers getCustomers5(@RequestBody Customers customers){

        customerRepository.save(customers);
        return customers;
    }

}
