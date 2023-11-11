package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
//import com.marketingapp.dto.LeadData;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.EmailService;
//import com.marketingapp.util.EmailServiceImpl;

@Controller       //this is spring annotation
public class LeadController {                                          //20.09.22
	
	@Autowired(required = false)
	private EmailService emailService;          //29.09.22
	
	
	@Autowired
	private LeadService leadService; //LeadServiceImpl obj address inject into it.
	
	
	
	
	
@RequestMapping("/viewLeadPage")   //this act like @webservlet
	public String viewCreateLeadPage() {     //to access view page create this method
		return "create_lead";  //return work as request dispatcher(RD).
		                    //RD - does, it redirect us to different survlet and jsp page
		                    //here load jsp page in the browser.
}
//--------------------------------------------------------------------------------------------------
@RequestMapping(value="/saveLead", method=RequestMethod.POST )    //1st Approch //21.09.22
public String saveLead(@ModelAttribute("lead") Lead l, ModelMap model ) {   //if form data and entity class matching then go with modelAttribute
   leadService.saveOneLead(l);
   //EmailServiceImpl email=new EmailServiceImpl();  
   emailService.sendSimpleMail(l.getEmail(), "Test", "Test Email");   //29.09.22
    model.addAttribute("msg","Lead is Saved!!");  //27.09.22
	
	return "create_lead";
	
}
//-------------------------------------------------------------------------------------------------
//@RequestMapping(value="/saveLead", method=RequestMethod.POST  ) //2nd Approch //22.09.22
//public String saveLead(@RequestParam("name") String fn,@RequestParam("lastName") String ln,@RequestParam("email") String email,@RequestParam("mobile") String mobile) {
//	//@RequestParam act like req.getParameter();
//	Lead lead=new Lead();
//	lead.setFirstName(fn);
//	lead.setLastName(ln);
//	lead.setEmail(email);
//	lead.setMobile(mobile);
//	
//	leadService.saveOneLead(lead);
//	return "create_lead";
//	
//}
//----------------------------------------------------------------------------------------------------
//@RequestMapping(value="/saveLead", method=RequestMethod.POST  )    //3rd Approch //22.09.22
//public String saveLead(LeadData data) {  //dto-Data Transfer Object.
//	Lead l=new Lead();
//	l.setFirstName(data.getFirstName());
//	l.setLastName(data.getLastName());
//	l.setEmail(data.getEmail());
//	l.setMobile(data.getMobile());
//	
//	leadService.saveOneLead(l);
//	
//	return "create_lead";
//	}
//----------------------------------------------------------------------------------------------------
   @RequestMapping("/listall")
    public String listAllLeads(ModelMap model) {
	   List<Lead> leads= leadService.listAllLeads();    //26.09.22
	   model.addAttribute("leads", leads);        //not work but i will do
	   return "list_leads";
   }
   //--------------------------------------------------------------------------------------
   @RequestMapping("/deleteLead")
public String deleteLead(@RequestParam("id") long id, ModelMap model) {    //27.09.22
	leadService.deleteOnelead(id);
	 List<Lead> leads= leadService.listAllLeads(); 
	 model.addAttribute("leads", leads);    //model. act like request.Setattribute
	return "list_leads";
}
   //---------------------------------------------------------------------------------------
   @RequestMapping("/updateLead")      //29.09.22
   public String updateLead (@RequestParam("id") long id,Model model) {
	   Lead lead = leadService.getById(id);
	   model.addAttribute("lead", lead);
	return "update_lead"; 
}
   @RequestMapping(value="/updateOneLead", method=RequestMethod.POST )   //29.09.22
   public String updateOneLead(@ModelAttribute("lead") Lead l, ModelMap model ) {
    leadService.saveOneLead(l);
    List<Lead> leads= leadService.listAllLeads(); 
	 model.addAttribute("leads", leads);   
   return "list_leads";
   }
 //----------------------------------------------------------------------------------
   
}
