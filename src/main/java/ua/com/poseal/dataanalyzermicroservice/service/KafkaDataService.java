package ua.com.poseal.dataanalyzermicroservice.service;

import ua.com.poseal.dataanalyzermicroservice.model.Data;

public interface KafkaDataService {

    void handle(Data data);

}
