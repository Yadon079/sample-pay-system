package com.grace.pay.userservice.service;

import com.grace.pay.userservice.domain.Exchange;
import com.grace.pay.userservice.domain.PayUser;
import com.grace.pay.userservice.repository.ExchangeRepository;
import com.grace.pay.userservice.repository.PayUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor
public class UserInformationService {

  private final ExchangeRepository exchangeRepository;
  private final PayUserRepository payUserRepository;

  // 0. 유저 데이터 조회
  public PayUser showUserInfo(String userId) {
    return payUserRepository.findById(userId).orElseThrow(NoSuchElementException::new);
  }

  // 1. 한 유저의 모든 거래 기록 가져오기
  @Cacheable(value = "exchange", key = "#userId")
  public List<Exchange> findAllExchanges(String userId) {
    return exchangeRepository.findAllByMyId(userId)
        .stream()
        .sorted(Comparator.comparing(Exchange::getExchangeDate, Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }

  // 2. 한 유저의 결제 목록 가져오기
  @Cacheable(value = "exchange", key = "#userId")
  public List<Exchange> findAllPayments(String userId) {
    return exchangeRepository.findAllByMyId(userId)
        .stream()
        .filter(exchange -> exchange.getExchangeType().equals(Exchange.EXCHANGE_TYPE.PAYMENT))
        .sorted(Comparator.comparing(Exchange::getExchangeDate, Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }

  // 3. 한 유저의 송금 목록 가져오기
  @Cacheable(value = "exchange", key = "#userId")
  public List<Exchange> findAllSends(String userId) {
    return exchangeRepository.findAllByMyId(userId)
        .stream()
        .filter(exchange -> exchange.getExchangeType().equals(Exchange.EXCHANGE_TYPE.SEND))
        .sorted(Comparator.comparing(Exchange::getExchangeDate, Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }

  // 4. 한 유저의 송금 발신 목록 가져오기
  @Cacheable(value = "exchange", key = "#userId")
  public List<Exchange> findAllSendsByOnlySend(String userId) {
    return exchangeRepository.findAllByMyId(userId)
        .stream()
        .filter(exchange -> exchange.getExchangeType().equals(Exchange.EXCHANGE_TYPE.SEND))
        .filter(exchange -> exchange.getMoney() < 0)
        .sorted(Comparator.comparing(Exchange::getExchangeDate, Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }

  // 5. 한 유저의 송금 수신 목록 가져오기
  @Cacheable(value = "exchange", key = "#userId")
  public List<Exchange> findAllSendsByOnlyReceive(String userId) {
    return exchangeRepository.findAllByMyId(userId)
        .stream()
        .filter(exchange -> exchange.getExchangeType().equals(Exchange.EXCHANGE_TYPE.SEND))
        .filter(exchange -> exchange.getMoney() > 0)
        .sorted(Comparator.comparing(Exchange::getExchangeDate, Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }


}
