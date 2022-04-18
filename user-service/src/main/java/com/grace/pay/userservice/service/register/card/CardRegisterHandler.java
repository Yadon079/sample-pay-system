package com.grace.pay.userservice.service.register.card;

import com.grace.pay.userservice.domain.charge.RegisterForm;

public interface CardRegisterHandler {

  boolean isValidCard(RegisterForm registerForm);

  boolean registerCard(RegisterForm registerForm);

}
