package petclinic.veterinarian.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import petclinic.veterinarian.entity.MedicalReport;
import petclinic.veterinarian.repository.MedicalReportRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private final MedicalReportRepository repository;
    private final ObjectMapper mapper;

    @KafkaListener(topics = "petclinic-visit-topic")
    public void processMessage(String message) throws JsonProcessingException {
        log.info("Kafka received message: {}", message);
        Map<String, Object> data = mapper.readValue(message, new TypeReference<Map<String, Object>>() {});
        log.info("Kafka message deserialized: {}", data);

        MedicalReport medicalReport = MedicalReport.builder()
                .diagnosis(data.get("description").toString())
                .veterinarianId(Integer.parseInt(data.get("veterinarianId").toString()))
                .petId(Integer.parseInt(data.get("petId").toString()))
                .build();
        repository.save(medicalReport);
    }
}
