package ua.com.poseal.dataanalyzermicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.poseal.dataanalyzermicroservice.model.Data;
import ua.com.poseal.dataanalyzermicroservice.repository.DataRepository;

/**
 * This class allows to read and process data
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final DataRepository dataRepository;

    @Override
    public void handle(Data data) {
        Data saved = dataRepository.save(data);
        log.info("Data object {} was saved", saved);
    }
}
