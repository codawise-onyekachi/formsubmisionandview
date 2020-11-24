package com.example.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @RequestMapping("/home")
    public String educate(){
        //return "educate.jsp";
        return "index.html";
    }

    @PostMapping("/details")
    public String viewdetails(@RequestParam("cid") Long cid,
                              @RequestParam("cname") String cname,
                              @RequestParam("cemail") String cemail,
                              ModelMap modelMap){
        modelMap.put("cid", cid);
        modelMap.put("cname", cname);
        modelMap.put("cemail", cemail);

        return "viewCustomerPage.html";
    }
}
