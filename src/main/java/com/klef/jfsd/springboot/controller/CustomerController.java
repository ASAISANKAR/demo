package com.klef.jfsd.springboot.controller;

import java.time.LocalDateTime;


import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Log;
import com.klef.jfsd.springboot.model.React;
import com.klef.jfsd.springboot.service.CustomerService;
import com.klef.jfsd.springboot.service.LogService;
import com.klef.jfsd.springboot.service.ReactService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@CrossOrigin
@Controller
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LogService logser;
	
	@Autowired
	private ReactService reactser;
	
	
	
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request, 
            @RequestHeader(value = "User-Agent") String userAgent)
	{
		 String ipAddress = getClientIp(request);
		 LocalDateTime currentDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);
		 Log log=new Log();
		 log.setIp(ipAddress);
		 log.setDatetime(formattedDateTime);
	     logser.LogRegistration(log);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	 private String getClientIp(HttpServletRequest request) {
	        String ipAddress = request.getHeader("X-Forwarded-For");
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("Proxy-Client-IP");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getRemoteAddr();
	        }
	        // If multiple IPs are present (common in X-Forwarded-For), take the first one
	        if (ipAddress != null && ipAddress.contains(",")) {
	            ipAddress = ipAddress.split(",")[0];
	        }
	        return ipAddress;
	    }
	 
	 @PostMapping("signup")
	 public ResponseEntity<String> registerUser(@RequestBody React user) {
	     reactser.ReactRegistration(user);  
	     return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
	 }

	 
	
	 
	 
	@GetMapping("customerreg")
	public ModelAndView customerreg()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerreg");
		return mv;
	}
	
	@GetMapping("customerprofile")
	public ModelAndView customerprofile()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerprofile");
		return mv;
	}
	
	@GetMapping("customerhome")
	public ModelAndView customerhome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerhome");
		return mv;
	}
	@GetMapping("customerlogin")
	public ModelAndView customerlogin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerlogin");
		return mv;
	}
	
	@GetMapping("customerlogout")
	public ModelAndView customerlogout()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customerlogin");
		return mv;
	}
	
	
	@PostMapping("insertcustomer")
	public ModelAndView insertcustomer(HttpServletRequest request)
	{
		String name = request.getParameter("cname");
		String gender = request.getParameter("cgender");
		String dob= request.getParameter("cdob");
		String email= request.getParameter("cemail");
		String location= request.getParameter("clocation");
		String contact = request.getParameter("ccontact");
		String password= request.getParameter("cpassword");
		
		
		Customer customer =new Customer();
		customer.setName(name);
		customer.setGender(gender);
		customer.setDateofbirth(dob);
		customer.setEmail(email);
		customer.setLocation(location);
		customer.setContact(contact);
		customer.setPassword(password);
		
		String msg=customerService.customerRegistration(customer);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("regsuccess");
		mv.addObject("message",msg);
		
		return mv;
		
		
	}
	
	
	@PostMapping("checkcustomerlogin")
	public ModelAndView checkcustomerlogin(HttpServletRequest request)
	{
		
		ModelAndView mv=new ModelAndView();
		
		String cemail=request.getParameter("cemail");
		String cpwd=request.getParameter("cpwd");
		Customer customer=customerService.checkCustomerLogin(cemail, cpwd);
		if(customer!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("customer", customer);
			mv.setViewName("customerhome");
		}
		else
		{
			mv.setViewName("customerlogin");
			mv.addObject("message","Login Failed");
		}
		return mv;
	}
}
