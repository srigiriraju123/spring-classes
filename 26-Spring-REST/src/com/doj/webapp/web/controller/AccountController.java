/**
 * 
 */
package com.doj.webapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doj.webapp.model.Account;
import com.doj.webapp.model.AccountVO;
import com.doj.webapp.service.TransferService;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class AccountController {
	
	@Autowired
	TransferService transferService;
	
	@GetMapping("/open-account")
	public String create (){
		return "account";
	}
	
	@PostMapping("/open-account")
	public String save (Account account, ModelMap model){
		account = transferService.open(account);
		model.put("account", account);
		return "account";
	}
	
	@GetMapping("/all-accounts")
	public List<Account>  all (){
		return transferService.findAllAccounts();
	}
	@GetMapping("/accounts/{id}")
	public Account  one (@PathVariable Long id){
		return transferService.findById(id);
	}
	@GetMapping("/accounts")
	public AccountVO  allXML (){
		AccountVO accountVO = new AccountVO();
		accountVO.setAccount(transferService.findAllAccounts());
		return accountVO;
	}
}