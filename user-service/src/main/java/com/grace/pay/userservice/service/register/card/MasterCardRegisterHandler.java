package com.grace.pay.userservice.service.register.card;

import com.grace.pay.userservice.domain.charge.RegisterForm;
import lombok.extern.java.Log;

@Log
public class MasterCardRegisterHandler implements CardRegisterHandler {

  @Override
  public boolean isValidCard(RegisterForm registerForm) {
    log.info("this MasterCard is valid");
    return true;
  }

  @Override
  public boolean registerCard(RegisterForm registerForm) {
    log.info("MasterCard is registerd!");
    return true;
  }

}
