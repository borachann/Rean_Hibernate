/**
 * 
 */
package com.boralovesahleak.spring.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author channboralovesahleak
 *
 */
@Controller
public class HomeController {
@RequestMapping(value={"", "/", "home", "/index"}, method= RequestMethod.GET)
public String getHome(Model model){
	
	return "home/index";
}
}
