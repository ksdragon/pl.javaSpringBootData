/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javaSpringBootData.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP ProDesk
 */
@Service
public class TopicService {
    
    @Autowired
    private TopicRepository topicRepository;
    
//    List<Topic> topics = new ArrayList<>(Arrays.asList(
//        new Topic("spring","Spring Framework","Description Spring Framework"),
//        new Topic("java","Java Core","Java Core descryption"),
//        new Topic("javascript","JavaScript ","JavaScript descryption")
//        ));
    
    public List<Topic>  getAllTopics(){
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }
    
    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    void addTopic(Topic topic) {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    void updateTopic(String id, Topic topic) {
//        for (int i=0; i<topics.size(); i++ ){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
    topicRepository.save(topic);
    }

    void deleteTopic(String id) {
    //topics.removeIf(t -> t.getId().equals(id));
    topicRepository.deleteById(id);
}

}
