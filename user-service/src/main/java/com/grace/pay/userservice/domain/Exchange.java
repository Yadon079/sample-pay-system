package com.grace.pay.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Exchange {

  public enum EXCHANGE_TYPE {
    PAYMENT, SEND
  }

  @Id
  private long paymentId;               // 자동 생성 id

  private EXCHANGE_TYPE exchangeType;   // 결제 or 송금

  private String myId;                  // 나의 id

  private String otherId;               // PAYMENT : 가게 id, SEND : 유저 id

  private long money;                   // 음수 : 송금, 양수 : 받음

  private LocalDateTime exchangeDate;   // 거래일자

  private boolean isComplete;           // 상대방이 송금을 받았는가

}
