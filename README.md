# Pet Clinic Cloud
* Github: https://github.com/spring-petclinic/
* Demo: https://spring-petclinic-community.herokuapp.com/

# Spring Boot
## Properties
* [2.4 부터 변경된 구성파일 처리방식 살펴보기](http://honeymon.io/tech/2021/01/16/spring-boot-config-data-migration.html)
* [Properties with Spring and Spring Boot](https://www.baeldung.com/properties-with-spring)

# Spring Cloud
## Eureka
* [서비스 디스커버리](https://xzio.tistory.com/1439)

# JPA
* [OSIV와 성능 최적화](https://catsbi.oopy.io/eedf92ff-8834-458d-86e4-0ed2e01b5971)

# 강의
* [Spring Cloud Gateway - Custom Filter 적용](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/lecture/68419?tab=curriculum&speed=1.5)
  * 필터 적용하고 게이트웨이 url 들도 java config에서?
* [Users Microservice - Spring Security 연동](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/lecture/68513?tab=curriculum&speed=1.5)
  * 시큐리티도 적용해야 하는데 petclinic 에서는 어디가 적당할까나...
  * 게이트웨이에서만 시큐리티를 적용하면 각각의 서비스에서는 시큐리티 적용이 안되고 또 토큰도 꺼내고오고 해야하는데 신인사제도처럼 하는 게 맞는건지?