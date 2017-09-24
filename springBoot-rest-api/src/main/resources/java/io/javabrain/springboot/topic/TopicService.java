package io.javabrain.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

  @Autowired
  private TopicRepository topicRepository;

  /*private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic(
      "i1", "Spring", "Spring Test Application"), new Topic("i2", "Java",
      "Java Test Application"), new Topic("i3", "Script",
      "Script Test Application")));*/

  public List<Topic> getAllTopics(){
    //return topics;
    List<Topic> topics = new ArrayList<Topic>();
    //topicRepository.findAll().forEach(topics::add);
    Iterator<Topic> i = topicRepository.findAll().iterator();
    while(i.hasNext()){
      topics.add(i.next());
    }
    return topics;
  }

  public Topic getTopic(String id){
    /*for(Topic topic : topics){
      if(topic.getId().equals(id)){
        return topic;
      }
    }
    return null;*/

    //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

    return topicRepository.findOne(id);
  }

  public void addTopic(Topic topic){
    //topics.add(topic);
    topicRepository.save(topic);
  }

  public void updateTopic(Topic topic, String id){
   /*for(int i = 0; i < topics.size(); i++){
     Topic temp = topics.get(i);
     if(temp.getId().equals(id)){
      topics.set(i, topic);
       break;
     }
   }*/
    topicRepository.save(topic);
  }

  public void deleteTopic(String id){
   /* for(int i = 0; i < topics.size(); i++){
      Topic temp = topics.get(i);
      if(temp.getId().equals(id)){
        topics.remove(i);
      }
    }*/
    topicRepository.delete(id);
  }

}
