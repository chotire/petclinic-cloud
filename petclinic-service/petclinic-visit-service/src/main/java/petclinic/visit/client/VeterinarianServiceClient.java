package petclinic.visit.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "petclinic-veterinarian-service/veterinarian", fallback = VeterinarianServiceClient.Fallback.class)
public interface VeterinarianServiceClient {
    String CIRCUIT_BREAKER_NAME = "veterinarianCircuitBreaker";

    @GetMapping("/veterinarians/{id}")
    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME)
    VeterinarianResponse getVeterinarian(@PathVariable("id") Integer id);

    @Component("veterinarianServiceClientFallback")
    class Fallback implements VeterinarianServiceClient {
        @Override
        public VeterinarianResponse getVeterinarian(Integer id) {
            return new VeterinarianResponse();
        }
    }
}
