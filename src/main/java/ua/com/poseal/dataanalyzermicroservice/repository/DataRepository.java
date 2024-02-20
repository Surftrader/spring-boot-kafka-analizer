package ua.com.poseal.dataanalyzermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.poseal.dataanalyzermicroservice.model.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
