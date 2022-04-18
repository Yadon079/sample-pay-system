package com.grace.pay.userservice.service.register.card;

import com.grace.pay.userservice.domain.charge.RegisterForm;
import lombok.extern.java.Log;

@Log
public class BDCardRegisterHandler implements CardRegisterHandler {

  @Override
  public boolean isValidCard(RegisterForm registerForm) {
    log.info("this BDCard is valid");
    return true;
  }

  @Override
  public boolean registerCard(RegisterForm registerForm) {
    log.info("BDCard is registerd!");
    return true;
  }

}
