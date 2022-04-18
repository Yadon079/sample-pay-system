package com.grace.pay.userservice.service.register.bank;

import com.grace.pay.userservice.domain.charge.RegisterForm;
import lombok.extern.java.Log;

@Log
public class WooriBankRegisterHandler implements BankRegisterHandler {

  @Override
  public boolean isValidAccount(RegisterForm registerForm) {
    log.info("this WooriBank Account is valid");

    return true;
  }

  @Override
  public boolean registerAccount(RegisterForm registerForm) {
    log.info("WooriBank Account is registered!");

    return true;
  }

}
