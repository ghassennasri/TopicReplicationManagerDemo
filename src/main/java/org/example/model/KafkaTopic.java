package org.example.model;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "KAFKA_TOPIC")
public class KafkaTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String topicName;
    private LocalDateTime startTime;
    private long ttlHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public long getTtlHours() {
        return ttlHours;
    }

    public void setTtlHours(long ttlHours) {
        this.ttlHours = ttlHours;
    }

}
