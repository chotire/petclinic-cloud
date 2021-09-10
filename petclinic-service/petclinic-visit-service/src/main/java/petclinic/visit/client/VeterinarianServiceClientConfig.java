package petclinic.visit.client;

//import feign.Feign;
//import io.github.resilience4j.circuitbreaker.CircuitBreaker;
//import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
//import io.github.resilience4j.feign.FeignDecorators;
//import io.github.resilience4j.feign.Resilience4jFeign;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

// https://github.com/spring-cloud/spring-cloud-circuitbreaker/issues/3
@RequiredArgsConstructor
public class VeterinarianServiceClientConfig {
//    private final CircuitBreakerRegistry registry;
//
//    @Bean
//    public Feign.Builder feignBuilder() {
//        CircuitBreaker circuitBreaker = registry.circuitBreaker(VeterinarianServiceClient.CIRCUIT_BREAKER_NAME);
//        FeignDecorators decorators = FeignDecorators.builder()
//                .withCircuitBreaker(circuitBreaker)
//                .withFallback(new VeterinarianServiceClient.Fallback())
//                .build();
//        return Resilience4jFeign.builder(decorators);
//    }
}
