package com.grace.pay.userservice.service.register;

import com.grace.pay.userservice.domain.charge.RegisterForm;

public interface Connector {

  void setCompany(RegisterForm registerForm);

  boolean isValid(RegisterForm registerForm);

  boolean registerCard(RegisterForm registerForm);

}
