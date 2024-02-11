package ua.com.poseal.dataanalyzermicroservice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import ua.com.poseal.dataanalyzermicroservice.config.LocalDateTimeDeserializer;
import ua.com.poseal.dataanalyzermicroservice.model.Data;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiverImpl implements KafkaDataReceiver {

    private final KafkaReceiver<String, Object> kafkaReceiver;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final KafkaDataService kafkaDataService;

    @PostConstruct
    private void init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, localDateTimeDeserializer)
                .create();
        kafkaReceiver.receive()
                .subscribe(r -> {
                    Data data = gson.fromJson(r.value().toString(), Data.class);
                    kafkaDataService.handle(data);
                    r.receiverOffset().acknowledge();
                });
    }
}
