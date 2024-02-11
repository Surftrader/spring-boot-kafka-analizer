package ua.com.poseal.dataanalyzermicroservice.service;

import org.springframework.stereotype.Service;
import ua.com.poseal.dataanalyzermicroservice.model.Data;

/**
 * This class allows to read and process data
 */
@Service
public class KafkaDataServiceImpl implements KafkaDataService {

    @Override
    public void handle(Data data) {
        System.out.println("Data object is received: " + data.toString());
    }
}
