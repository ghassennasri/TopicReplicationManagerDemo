package org.example.controller;

import org.example.model.KafkaTopic;
import org.example.service.TopicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicRestController {

    @Autowired
    private TopicManager topicManager;




    @PostMapping
    public ResponseEntity<?> createTopic(@RequestBody TopicRequest topicRequest) {
        try{
            topicManager.addTopic(topicRequest.getTopicName(), topicRequest.getTtlHours());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<KafkaTopic> getActiveTopics() {
        return topicManager.getActiveTopics();
    }

    @DeleteMapping
    public void removeTopic(@RequestParam String topicName) {
        topicManager.removeTopic(topicName);
    }
}
