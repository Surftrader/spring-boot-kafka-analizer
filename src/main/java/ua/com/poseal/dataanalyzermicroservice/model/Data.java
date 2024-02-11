package ua.com.poseal.dataanalyzermicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Data {

    // sensor id
    private Long sensorId;
    // time of sending information
    private LocalDateTime timestamp;
    // sensor parameters
    private double measurement;
    // sensor type
    private MeasurementType measurementType;

    public enum MeasurementType {
        TEMPERATURE,
        VOLTAGE,
        POWER
    }
}
