package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/ms")
public class LoginController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository ur;
	
	
	@GetMapping("/login")
	public ModelAndView invoke()
	{
		ModelAndView mv=new ModelAndView("/login.jsp");
		return mv;
	}
	
	
	@GetMapping("/save")
	public void create(@RequestParam("t1")String name, @RequestParam("t2")String pwd)
	{
		User u=new User(name,pwd);
		
		ur.save(u);
	}
	
	@RequestMapping(value="/send",method=RequestMethod.GET)
	public String invokeService(@RequestParam("t1")String name, @RequestParam("t2")String pwd)
	{
		System.out.println(name+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(pwd);
		String url="http://AUTHENTICATION-SERVICE/send?"+"t1="+name+"&t2="+pwd;
		User a =new User("a","1");
		ur.save(a);
		a.setName("b");
		a.setPwd("2");
		ur.save(a);
		a.setName("c");
		a.setPwd("3");
		ur.save(a);
		
		Optional<User> u=ur.findById(name);
		
		User u1=u.get();
		System.out.println("111111111111111111    "+u1.getPwd());
		if(u1.getPwd().equals(pwd))
		{
			return "success";
		}
		
		else
		{
			return "error";
		}
		
		
		
		
		
		
	}
	

}
