package com.gofar.web.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.gofar.domain.Account;

@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	
	public String query(){
		jsonList  = accountService.findAll();
		return "jsonList";
	}
	
}
