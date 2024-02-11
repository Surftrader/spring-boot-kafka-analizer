package ua.com.poseal.dataanalyzermicroservice.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfig {

    /**
     * This method describes the Kafka consumer configuration
     * from the file consumer.xml
     *
     * @return XMLDocument
     */
    @SneakyThrows
    @Bean
    public XML consumerXML() {
        return new XMLDocument(
                new File("src/main/resources/kafka/consumer.xml")
        );
    }
}
