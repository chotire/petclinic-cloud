package petclinic.service.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
// root package 에 있어야 하며, 그렇지 않은 경우 basePackages 또는 basePackageClasses 를 지정
@EnableFeignClients(basePackages = { "petclinic" })
public class FeignClientConfig {
}
