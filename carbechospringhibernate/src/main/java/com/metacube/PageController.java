package com.metacube;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "/page")
public class PageController {

	 @RequestMapping(value="/index", method = RequestMethod.GET)
	    public String indexPage() {
	        return "index";
	    }
	
    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String errorPage() {
        return "error";
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String listPage() {
        return "list";
    }
}
