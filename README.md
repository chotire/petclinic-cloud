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

## Config
* [Add spring-cloud-config-server ability to share common configuration across applications](https://github.com/spring-cloud/spring-cloud-config/issues/32)
* [loading multiple properties with config-server](https://stackoverflow.com/questions/35555232/loading-multiple-properties-with-config-server)

다음과 같은 형태로 property를 조회
http://localhost:8888/petclinic-service-common/defalut

## Circuit Breaker & Resilience4J
* [Spring Boot에 Resilience4j (CircuitBreaker) 적용하기](https://leejongchan.tistory.com/100)
* [Spring Cloud Circuit Breaker & Resilience4J 란](https://happycloud-lee.tistory.com/219)

## Zipkin & Sleuth
* https://engineering.linecorp.com/ko/blog/line-ads-msa-opentracing-zipkin/

# JPA
* [OSIV와 성능 최적화](https://catsbi.oopy.io/eedf92ff-8834-458d-86e4-0ed2e01b5971)

# 강의
* [Spring Cloud Gateway - Custom Filter 적용](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/lecture/68419?tab=curriculum&speed=1.5)
  * 필터 적용하고 게이트웨이 url 들도 java config에서?
* [Users Microservice - Spring Security 연동](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/lecture/68513?tab=curriculum&speed=1.5)
  * 시큐리티도 적용해야 하는데 petclinic 에서는 어디가 적당할까나...
  * 게이트웨이에서만 시큐리티를 적용하면 각각의 서비스에서는 시큐리티 적용이 안되고 또 토큰도 꺼내고오고 해야하는데 신인사제도처럼 하는 게 맞는건지?

# Keytool
Private 키 생성
```shell
keytool -genkeypair -alias PetclinicEncryptionKey -keyalg RSA -dname "CN=Chotire, OU=Petclinic O=cloud, L=Seoul, C=KR" -keypass "test1234" -keystore PetclinicEncryptionKey.jks -storepass "test1234"
```
- CN: Company Name
- OU: Organization Uint
- O: Organization
- L: Location
- C: Country

Key 정보 보기
```shell
keytool -list -keystore PetclinicEncryptionKey.jks -v
```

Spring Cloud Config에서는 공개키 없이 개인키(PetclinicEncryptionKey.jks)만으로 작업해도 무방

개인키로 인증서 생성
```shell
keytool -export -alias PetclinicEncryptionKey -keystore PetclinicEncryptionKey.jks -rfc -file trustServer.cer
```

인증서로 공개키 생성
```shell
keytool -import -alias trustServer -file trustServer.cer -keystore PetclinicKey.jks
```

yaml 파일에 적용
  * POST http://localhost:8888/encrypt
  * secret: '{cipher}암호화 스트링'

# TODO
* Config Server 설정 정보의 암호화 처리
  * 시큐리티 붙일 때 토큰 secret 값을 암호화하면 될 듯
* Feign client 적용
  * [Feign client 로깅](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/lecture/69927?tab=note&speed=1.5)
  * Error decode를 통해서 서킷브레이커와 유사한 형태의 디코더 작성
  * Access Token Header 붙이기
* Actuator 붙이기

# Kafka 실행
kafka는 zookeeper 위에서 돌아가므로 zookeeper를 먼저 실행한다.
```shell
petclinic-kafka/bin/zookeeper-server-start.sh petclinic-kafka/config/zookeeper.properties
```
다음은 kafka를 실행
```shell
petclinic-kafka/bin/kafka-server-start.sh petclinic-kafka/config/server.properties 
```
Kafka 관리 콘솔 실행
```shell
petclinic-kafka/cmak-3.0.0.5/bin/cmak
```
http://locahost:9000 접속

## Kafka 명령들
토픽 생성
```shell
kafka-topics.sh --bootstrap-server localhost:9091 --create --topic quicsktart-events --partitions 1
```

생성된 토픽 리스트
```shell
kafka-topics.sh --bootstrap-server localhost:9091 --list
```

토픽 정보 자세히 보기
```shell
kafka-topics.sh --bootstrap-server localhost:9091 --describe quickstart-events
```

Consumer 생성
```shell
kafka-console-consumer.sh --bootstrap-server localhost:9091 --topic quickstart-events --from-beginning
```

Producer 생성
```shell
kafka-console-producer.sh --broker-list localhost:9091 --topic quickstart-events
```

# Kafka Connect
## Kafka Connect 설치
curl -O http://packages.confluent.io/archive/6.2/confluent-community-6.2.0.tar.gz

tar xvf confluent-community-6.1.0.tar.gz

cd  $KAFKA_CONNECT_HOME

## Kafka Connect 실행
./bin/connect-distributed ./etc/kafka/connect-distributed.properties

## JDBC Connector 설치
- https://docs.confluent.io/5.5.1/connect/kafka-connect-jdbc/index.html

- confluentinc-kafka-connect-jdbc-10.2.2.zip

**etc/kafka/connect-distributed.properties 파일 마지막에 아래 plugin 정보 추가**
- plugin.path=[confluentinc-kafka-connect-jdbc-10.0.1 폴더]

**JdbcSourceConnector에서 MariaDB 사용하기 위해 mariadb 드라이버 복사**
./share/java/kafka/ 폴더에 mariadb-java-client-2.7.2.jar  파일 복사

# Zipkin
Zipkin 실행
```shell
java -jar petclinic-zipkin/zipkin.jar
```