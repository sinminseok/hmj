

## Service 계층 테스트

## Repository 계층 테스트
- @DataJpaTest : 데이터 접근 계층(Data Access Layer)을 테스트하기 위한 애노테이션이고, JPA 관련 구성을 자동으로 로드한다.
- @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) : 테스트용 데이터 베이스를 자동으로 구성하지 않고, 실제 데이터베이스를 사용하도록 설정
- @Import(TestConfig.class) : QueryDsl 은 JPAQueryFactory 를 통해 구현되는데 테스트를 할때 JPAQueryFactory 빈을 스프링 컨테이너에 올려놔야 주입됨
