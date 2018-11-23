package mypackage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class FirstController {
	
	@RequestMapping("/hello")
	public ModelAndView index() {
		String msg = "hi this is jagadish varma";
		return new ModelAndView("hellopage", "message", msg);
	}
	
	@RequestMapping("/sampleform")
	public ModelAndView sampleform() {
		return  new ModelAndView("sampleform");
	}
	
	@RequestMapping("/addemp")
	public ModelAndView addemp() {
		return  new ModelAndView("addemp");
	}
	
	@RequestMapping("/submitform")
	public ModelAndView submitdetails(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		ModelAndView mav = new ModelAndView("submit");
		mav.addObject("uname", name);
		mav.addObject("pass", pass);
		return mav;
		
	}
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Employee emp) {
		return new ModelAndView ("view");
	}
	
	@RequestMapping("viewdetails")
	public ModelAndView viewdetails() {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		
		emp1.setUsername("varma");
		emp1.setPassword("123");
		emp2.setUsername("jaggu");
		emp2.setPassword("456");
		emp3.setUsername("alluri");
		emp3.setPassword("789");
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		
		return new ModelAndView("viewdetails", "details", list);
	
	}

}
