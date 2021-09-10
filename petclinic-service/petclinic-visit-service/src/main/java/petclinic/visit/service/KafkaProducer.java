package petclinic.visit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import petclinic.visit.entity.Visit;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public void send(String topic, Visit visit) throws JsonProcessingException {
        String jsonString = mapper.writeValueAsString(visit);
        kafkaTemplate.send(topic, jsonString);
        log.info("Kafka Producer send data the Visit microservice: {}", visit);
    }
}
