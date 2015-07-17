package com.mum.edu.happycart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author Ketia
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
@RequestMapping(value="",method=RequestMethod.GET)
public String adminShow(){
	return "admin";
}
}
