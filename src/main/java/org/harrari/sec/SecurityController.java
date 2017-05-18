package org.harrari.sec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nobody on 5/11/2017.
 */
@Controller
public class SecurityController  {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/")
    public String home(){
        return "redirect:/operations";
    }
    @RequestMapping(value = "/403")
    public String accesDinied(){
        return "403";
    }

}
