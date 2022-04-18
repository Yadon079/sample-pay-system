package com.grace.pay.userservice.service.register;

import com.grace.pay.userservice.domain.charge.RegisterForm;
import com.grace.pay.userservice.service.register.card.*;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class CardCompanyConnector implements Connector {

  private CardRegisterHandler cardRegisterHandler;

  @Override
  public void setCompany(RegisterForm registerForm) {
    switch (registerForm.getCompanyName()) {
      case "BD":
        this.cardRegisterHandler = new BDCardRegisterHandler();
        break;
      case "MASTAR":
        this.cardRegisterHandler = new MasterCardRegisterHandler();
        break;
      case "KAKAO":
        this.cardRegisterHandler = new KakaoCardRegisterHandler();
        break;
      case "TOSS":
        this.cardRegisterHandler = new TossCardRegisterHandler();
        break;
    }
  }

  public boolean isValid(RegisterForm registerForm) {
    log.info("Validating Card... 1s");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return cardRegisterHandler.isValidCard(registerForm);
  }

  public boolean registerCard(RegisterForm registerForm) {
    log.info("Registering Card... 1s");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return cardRegisterHandler.registerCard(registerForm);
  }

}
