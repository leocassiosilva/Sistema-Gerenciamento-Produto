package com.exemplo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	/*Para chmar o metodo da pagina inicial*/
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
