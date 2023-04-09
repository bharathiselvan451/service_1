package com.phaseii.demo;






import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;




@Controller
public class homeController {
	
	static model obj;
	
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("log_email") String email,@RequestParam("log_password") String password,Model model) {
		RestTemplate resttemplate = new RestTemplate();
		
		try {
		obj = resttemplate.getForObject("http://localhost:8091/rest/"+email, model.class);
		//System.out.println(obj.toString());
		if(password.equals(obj.getPassword())) {
			return "redirect:/dashboard";
		}
		else {
		//	model.addAttribute("message","login failed");
			return "redirect:/home";
		}
		
		}
		catch(Exception e) {
			
		}
		// model.addAttribute("message","login failed");
		return "redirect:/home";
	   
	}
	    
	    @GetMapping("dashboard")
		public String enter_dashboard(Model m) {
	    	try {
	    	System.out.println(obj.getBudget()+" "+obj.getExpense());
	    	m.addAttribute("budget", obj.getBudget() );
	    	m.addAttribute("expense", obj.getExpense());
			return "dashboard";}
	    	catch(Exception e) {
	    		m.addAttribute("budget", 0);
		    	m.addAttribute("expense", 0);
	    		return "dashboard";
	    	}
	    }
	    
	 @PostMapping("/register")
	 public String register(@RequestParam("reg_email") String email,@RequestParam("reg_password") String password,@RequestParam("reg_name")String name) throws JsonMappingException, JsonProcessingException {
		 //System.out.println(email+" "+password+" "+name);
		 RestTemplate resttemplate = new RestTemplate();
		 
		 
		 try {
			 
		 model obj = resttemplate.getForObject("http://localhost:8091/rest/"+email, model.class);
		 System.out.println(obj.toString());
		 System.out.println(email+" = "+obj.getDmail());
		
		     if(email.equals(obj.getDmail())) {
		    	 System.out.println("failed");
		    	 return "redirect:/home";
		     }
		 
		 }
		 catch(Exception e){
			 }
		 
		 HttpHeaders headers = new HttpHeaders();
		    JSONObject personJsonObject = new JSONObject();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		   
		    personJsonObject.put("email", email);
		    personJsonObject.put("name", name);
		    personJsonObject.put("password", password);
		    personJsonObject.put("dmail", email);
		    
		    
		    HttpEntity<String> request = 
		    	      new HttpEntity<String>(personJsonObject.toString(), headers);
		    
		     obj = 
		    	      resttemplate.postForObject("http://localhost:8091/rest", request, model.class);
		    
		    
		    return "redirect:/dashboard";
	 }
	 
	 
	 @PostMapping("setexpense")
	 public String expenses(@RequestParam("TExpenses") int expenses,Model m) {
		 System.out.println(expenses);
		 
		
		
		 if(obj.getBudget()==0) {
			 //m.addAttribute("message","set budget before proceeding with expenses");
			 return "redirect:/dashboard";
		 }
		 
		
		 
		
		 JSONObject personJsonObject = new JSONObject();
		    HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			
		   
		    personJsonObject.put("email", obj.getDmail());
		    personJsonObject.put("name", obj.getName());
		    personJsonObject.put("password", obj.getPassword());
		    personJsonObject.put("dmail", obj.getDmail());
		    personJsonObject.put("date", obj.getDate().toString());
		    personJsonObject.put("budget", obj.getBudget());
		    
		   RestTemplate resttemplate = new RestTemplate();
			 obj = resttemplate.getForObject("http://localhost:8091/rest/"+obj.getDmail(), model.class);
		
			 if(expenses>obj.getBudget()) {
				 //m.addAttribute("message", "budget exceeded");
				 return "redirect:/dashboard";
			 }
			 
		    personJsonObject.put("expense", expenses+obj.getExpense());
		    
		    HttpEntity<String> request = 
		    	      new HttpEntity<String>(personJsonObject.toString(), headers);
	    
		
		 
		 System.out.println("here-----------------7");
		 
		 obj = 
	    	      resttemplate.postForObject("http://localhost:8091/rest", request, model.class);
		 //service_2
		 System.out.println("here-----------------8");
		 try {
		 service2(expenses);}
		 catch(Exception e) {
			 
		 }
		 return "redirect:/dashboard";
	 }
	 
	 @GetMapping("setbudget")
	 public String budgetpage() {
		 return "budgetsetter";
	 }
	 
	 
	 @PostMapping("budget")
	 public String budgetsetter(@RequestParam("budget") int budget) {
		 System.out.println(budget);
		 System.out.println(obj.getDate());
		if(obj.getDate()==null||java.time.LocalDate.now().compareTo(obj.getDate())>0||java.time.LocalDate.now().compareTo(obj.getDate())==0) {
			 long millis = System.currentTimeMillis();
		        LocalDate date = java.time.LocalDate.now();
			 JSONObject personJsonObject = new JSONObject();
			    HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
			    personJsonObject.put("email", obj.getDmail());
			    personJsonObject.put("name", obj.getName());
			    personJsonObject.put("password", obj.getPassword());
			    personJsonObject.put("dmail", obj.getDmail());
			    personJsonObject.put("expense",obj.getExpense());
			    personJsonObject.put("budget",budget);
			    date  = date.plusDays(30);
			    System.out.println(date);
			    personJsonObject.put("date" , date.toString());
			    RestTemplate resttemplate = new RestTemplate();
			    HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
			     obj = resttemplate.postForObject("http://localhost:8091/rest", request, model.class);
		 
		}
		else {
			System.out.println("nope here");
		}
		
		 return "redirect:/setbudget";
	 }
	 
	 public void service2(int expenses) {
		 
		 JSONObject personJsonObject = new JSONObject();
		    HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			System.out.println(obj.getDmail());
			System.out.println(obj.getName());
			System.out.println(java.time.LocalDate.now());
			System.out.println(obj.getBudget());
			System.out.println(expenses);
		   
		    personJsonObject.put("mail", obj.getDmail());
		    personJsonObject.put("name", obj.getName());
		    personJsonObject.put("date", java.time.LocalDate.now().toString());
		    personJsonObject.put("budget", obj.getBudget());
		    personJsonObject.put("expense", expenses);
		    
		    HttpEntity<String> request = 
		    	      new HttpEntity<String>(personJsonObject.toString(), headers);
		    RestTemplate resttemplate = new RestTemplate();
		    
		    System.out.println("here------------10");
		    
 Service2_model obj_0 =      resttemplate.postForObject("http://localhost:8092/rest_2", request, Service2_model.class);
		 
	 }
	 
	 @GetMapping("getexpense")
	 public ModelAndView get_budget(@RequestParam("date") String date) {
		 
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("dashboard");
		 mv.addObject("message","not found");
		 
		 RestTemplate resttemplate = new RestTemplate();
		 
		Service2_model[] entity  =  resttemplate.getForObject("http://localhost:8092/find/bharathiselvan451@gmail.com", Service2_model[].class);
		
		for(Service2_model x : entity) {
			if(x.getDate().toString().equals(date)) {
				 mv.addObject("message","you spent "+x.getExpense()+" on "+date);
			}
		}
		mv.addObject("budget", obj.getBudget() );
    	mv.addObject("expense", obj.getExpense());
		 return mv;
		 
	 }
	    
	    

}
