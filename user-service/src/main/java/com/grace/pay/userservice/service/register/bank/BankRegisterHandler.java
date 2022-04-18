package com.grace.pay.userservice.service.register.bank;

import com.grace.pay.userservice.domain.charge.RegisterForm;

public interface BankRegisterHandler {

  boolean isValidAccount(RegisterForm registerForm);

  boolean registerAccount(RegisterForm registerForm);

}