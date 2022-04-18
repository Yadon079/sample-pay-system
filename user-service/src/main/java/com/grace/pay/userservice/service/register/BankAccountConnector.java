package com.grace.pay.userservice.service.register;

import com.grace.pay.userservice.domain.charge.RegisterForm;
import com.grace.pay.userservice.service.register.bank.BankRegisterHandler;
import com.grace.pay.userservice.service.register.bank.KBBankRegisterHandler;
import com.grace.pay.userservice.service.register.bank.WooriBankRegisterHandler;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class BankAccountConnector implements Connector {

  private BankRegisterHandler bankRegisterHandler;

  public void setCompany(RegisterForm registerForm) {
    switch (registerForm.getCompanyName()) {
      case "KB":
        this.bankRegisterHandler = new KBBankRegisterHandler();
        break;
      case "WOORI":
        this.bankRegisterHandler = new WooriBankRegisterHandler();
        break;
    }
  }

  public boolean isValid(RegisterForm registerForm) {
    log.info("Validating Account... 1s");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return bankRegisterHandler.isValidAccount(registerForm);
  }

  public boolean registerCard(RegisterForm registerForm) {
    log.info("Registering Account... 1s");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return bankRegisterHandler.registerAccount(registerForm);
  }

}
