package org.example.repository;

import org.example.model.KafkaTopic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KafkaTopicRepository extends CrudRepository<KafkaTopic, Long> {

    KafkaTopic findByTopicName(String topicName);

    @Query(value = "SELECT * FROM KAFKA_TOPIC as kt WHERE CURRENT_TIMESTAMP < DATEADD(HOUR, kt.TTL_HOURS, kt.START_TIME)", nativeQuery = true)
    List<KafkaTopic> findActiveTopics();
}
