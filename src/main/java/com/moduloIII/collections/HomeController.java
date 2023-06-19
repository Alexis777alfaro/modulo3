package com.moduloIII.collections;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/crudPc.html")
    public String getCrudPcPage() {
        return "crudPc"; // nombre del archivo HTML sin la extensión
    }
	
	@GetMapping("/index.html")
	public String getLoginPage() {
	    return "index";
	}
	

	@GetMapping("/Crudusers.html")
	public String Crudusers() {
	    return "Crudusers";
	}


}
