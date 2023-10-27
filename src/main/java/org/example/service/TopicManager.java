package org.example.service;

import org.example.model.KafkaTopic;
import org.example.repository.KafkaTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TopicManager {

    @Autowired
    private KafkaTopicRepository kafkaTopicRepository;

    public void addTopic(String topicName, long ttlHours) {
        KafkaTopic kafkaTopic = new KafkaTopic();
        kafkaTopic.setTopicName(topicName);
        kafkaTopic.setStartTime(LocalDateTime.now());
        kafkaTopic.setTtlHours(ttlHours);
        kafkaTopicRepository.save(kafkaTopic);
    }

    public void removeTopic(String topicName) {
        KafkaTopic kafkaTopic = kafkaTopicRepository.findByTopicName(topicName);
        if (kafkaTopic != null) {
            kafkaTopicRepository.delete(kafkaTopic);
        }
    }

    /*
     * Returns all topics that are still active
     * Logic is to get all topics from the database and filter out the ones that are still active
     * Could be improved by getting all topics from database
     * and connecting to Kafka and checking for last stable offset for each one
     * and check in MongoDB if the offset exists for each collection
     */
    public List<KafkaTopic> getActiveTopics() {
      /*  LocalDateTime now = LocalDateTime.now();
        return StreamSupport.stream(kafkaTopicRepository.findAll().spliterator(), false)
                .filter(kafkaTopic -> now.isBefore(kafkaTopic.getStartTime().plusHours(kafkaTopic.getTtlHours())))
                .collect(Collectors.toList());

    */
        return kafkaTopicRepository.findActiveTopics();
    }
}
