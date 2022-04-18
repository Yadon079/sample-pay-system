# User Service Module

## API

1. GET /user/{id} : 유저 정보 조회   

2. GET /user/exchanges/all/{id} : 유저의 모든 거래내역 조회

3. GET /user/exchanges/payment/{id} : 유저의 결제 내역 조회

4. GET /user/exchanges/send/{id} : 유저의 송금 내역 조회

5. GET /user/exchanges/send/to/{id} : 유저의 송금 발신 조회

6. GET /user/exchanges/send/from/{id} : 유저의 송금 수신 조회

7. GET /user/exchanges/send/not-completed/{id} : 아직 완료되지 않은 송금 조회

8. POST /user/register/card/{id} : 유저의 카드 등록

9. POST /user/register/bank/{id} : 유저의 계좌 등록

10. POST /user/charge/card/{id} : 카드로 잔액 충전

11. POST /user/charge/bank/{id} : 계좌로 잔액 충전

12. GET /shop/{id} : 매장의 정보 조회