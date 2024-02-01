### 어노테이션 사용방법 정리

-----

#### @GeneratedValue 란?

JPA에서 Entity의 Primary Key를 생성해주는 기능이다.

다른 설정없이 @GeneratedValue 만 사용한다면 기본적으로 AUTO 전략을 사용.(MYSQL 에서는 시퀀스 사용)

IDENTITY 사용 방법


기본 키 생성을 데이터베이스에 위임한다.  
Entity를 등록할때 DB 에서 AUTO_INREMENT 하여 PK 생성후 INSERT 한다.

```
@GeneratedValue(strategy = GenerationType.IDENTITY)
```


