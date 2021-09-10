package petclinic.visit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("petclinic.kafka.producer")
public class KafkaProducerProperties {
    private String bootstrapServer;
}
