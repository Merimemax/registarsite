package edu.mum.registar.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class AdminHomeController {
	@GetMapping("/admin")
	public String displayHome() {
		
		return "/admin/home";
	}
	

}