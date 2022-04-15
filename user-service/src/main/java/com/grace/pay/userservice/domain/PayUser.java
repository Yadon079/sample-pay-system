package com.grace.pay.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class PayUser {

  public enum ChargeMethod {
    CARD, BANK_ACCOUNT
  }

  @Id
  private String userId;

  private String email;

  private Set<ChargeMethod> chargeMethods;    // 등록된 결제 수단 목록

  private Set<String> cardCompanyNames;       // 등록된 카드 회사 이름

  private Set<String> bankCompanyNames;       // 등록된 계좌의 은행 이름

  private long payMoney;                      // 현재 페이머니 잔액

}
