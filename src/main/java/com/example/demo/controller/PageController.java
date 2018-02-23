package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class PageController<Public> 
{
	@RequestMapping("/hello")
	public String index ()
	{
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name",required=false,defaultValue="dunia") String name, Model model)
	{
		model.addAttribute ("name", name);
		return "greeting";
	}
	
	@RequestMapping("/greeting/{name}")
	public String greetingPath (@PathVariable String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}
	
//	@RequestMapping(value = {"/greeting","greeting/{name}"})
//	public String greetingPath(@PathVariable Optional<String> name, Model model)
//	{
//		if (name.isPresent()) {
//			model.addAttribute("name", name.get());
//		}else {
//			model.addAttribute("name", "apap");
//		}
//		return "greeting";
//	}
	
	@RequestMapping("/perkalian")
	public String doPerkalian 
		(@RequestParam (value = "bil1",required=false,defaultValue="0") Integer bil1,
		@RequestParam (value = "bil2",required=false,defaultValue="0") Integer bil2,		
				Model model)
	{
		model.addAttribute("bil1", bil1);
		model.addAttribute("bil2", bil2);
	
		model.addAttribute("hasil", bil1 * bil2);
		return "perkalian";
	}
}
