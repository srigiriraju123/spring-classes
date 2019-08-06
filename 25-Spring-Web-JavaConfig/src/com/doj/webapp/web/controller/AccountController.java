/**
 * 
 */
package com.doj.webapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doj.webapp.model.Account;
import com.doj.webapp.service.TransferService;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class AccountController {
	
	@Autowired
	TransferService transferService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.initDirectFieldAccess();
		//binder.setDisallowedFields("id");
		binder.setRequiredFields("name", "balance");
	}
	
	@ModelAttribute("account")
	public Account account() {
		Account account = new Account();
		account.setName("Dinesh");
		return account;
	}
	
	@RequestMapping(value = "/open-account", method = RequestMethod.GET)
	public String create (){
		return "account";
	}
	
	@RequestMapping(value = "/open-account", method = RequestMethod.POST)
	public String save (ModelMap model, @Valid @ModelAttribute("account") Account account, Errors errors){
		if(errors.hasErrors()){
			return "account";
		}
		account = transferService.open(account);
		model.put("account", account);
		//errors.hasErrors()
		return "account";
	}
	
	@RequestMapping(value = "/all-accounts", method = RequestMethod.GET)
	public String all (ModelMap model){
		List<Account> accounts = transferService.findAllAccounts();
		model.put("accounts", accounts);
		return "accounts";
	}
}
