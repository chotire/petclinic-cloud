package petclinic.veterinarian.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("petclinic.kafka.consumer")
public class KafkaConsumerProperties {
    private String bootstrapServer;

    private String groupId;
}
