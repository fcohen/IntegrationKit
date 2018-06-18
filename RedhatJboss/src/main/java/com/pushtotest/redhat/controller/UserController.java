package com.pushtotest.redhat.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class UserController {
    //@Autowired
    //private UserService userService;
    
    //@Autowired
    //private LoginRepository loginRepository;

    //@Autowired
    //private SecurityService securityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        //model.addAttribute("userForm", new Login());
        //return "register";
    	model.addAttribute("message", "Welcome to Spring MVC");
		return "hello";
    }

   /* @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Login userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        userForm.setBalance(Utils.randomBalance());
        userService.save(userForm);

        securityService.autologin(userForm.getUserId(), userForm.getPassword());

        return "redirect:/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "profile";
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") Login userForm, Model model,
    		HttpServletRequest request, 
            HttpServletResponse response) {
    	boolean hasError = false;
    	
    	try{
    		securityService.autologin(userForm.getUserId(), userForm.getPassword());
    	} catch(Exception e){
    		e.printStackTrace();
    		hasError = true;
    	}
    	
        if (hasError){
        	model.addAttribute("showError", true);
            model.addAttribute("errorMessage", "Either your username and password are not invalid.");
            return "profile";
        } else {
        	HttpSession session = request.getSession();
        	Login user = loginRepository.findByUserId(userForm.getUserId());
            session.setAttribute("user", user);
            return "redirect:/index";
        }
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model,
    		HttpServletRequest request, 
            HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	if(session != null && session.getAttribute("user") != null){
	    	Login user = (Login) session.getAttribute("user");
	    	model.addAttribute("userId", user.getId());
	    	model.addAttribute("userName", user.getFirstName());
	        model.addAttribute("balance", user.getBalance());
	        return "index";
    	} else {
    		return "profile";
    	}
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(Model model,
    		HttpServletRequest request, 
            HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	Login user = (Login) session.getAttribute("user");
    	model.addAttribute("userId", user.getId());
    	model.addAttribute("userName", user.getFirstName());
        model.addAttribute("balance", user.getBalance());
        return "index";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model,
    		HttpServletRequest request, 
            HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	Login user = (Login) session.getAttribute("user");
    	model.addAttribute("userId", user.getId());
    	model.addAttribute("userName", user.getFirstName());
    	model.addAttribute("userEmail", user.getUserId());
        model.addAttribute("balance", user.getBalance());
        return "profile";
    }
    
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String getMessage(Model model,
    		HttpServletRequest request, 
            HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	Login user = (Login) session.getAttribute("user");
    	model.addAttribute("userId", user.getId());
    	model.addAttribute("userName", user.getFirstName());
        model.addAttribute("balance", user.getBalance());
        return "message";
    }
    
    @RequestMapping(value = "/share", method = RequestMethod.GET)
    public String getShare(Model model,
    		HttpServletRequest request, 
            HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	Login user = (Login) session.getAttribute("user");
    	model.addAttribute("userId", user.getId());
    	model.addAttribute("userName", user.getFirstName());
    	model.addAttribute("userEmail", user.getUserId());
        model.addAttribute("balance", user.getBalance());
        return "share";
    }
    
    @RequestMapping(value = "/redeem", method = RequestMethod.GET)
    public String getRedeem(Model model,
    		HttpServletRequest request, 
            HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	Login user = (Login) session.getAttribute("user");
    	model.addAttribute("userId", user.getId());
    	model.addAttribute("userName", user.getFirstName());
        model.addAttribute("balance", user.getBalance());
        return "redeem";
    }*/
}