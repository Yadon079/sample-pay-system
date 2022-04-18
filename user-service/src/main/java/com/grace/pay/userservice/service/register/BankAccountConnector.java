package com.grace.pay.userservice.service.register;

import com.grace.pay.userservice.domain.charge.RegisterForm;
import com.grace.pay.userservice.service.register.bank.BankRegisterHandler;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class BankAccountConnector implements Connector {

  private BankRegisterHandler bankRegisterHandler;

  public void setCompany(RegisterForm registerForm) {

  }

  public boolean isValid(RegisterForm registerForm) {
    return false;
  }

  public boolean registerCard(RegisterForm registerForm) {
    return false;
  }
}
