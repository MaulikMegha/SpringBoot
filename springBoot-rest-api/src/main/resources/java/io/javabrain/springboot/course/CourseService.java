package io.javabrain.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  /*private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic(
      "i1", "Spring", "Spring Test Application"), new Topic("i2", "Java",
      "Java Test Application"), new Topic("i3", "Script",
      "Script Test Application")));*/

  public List<Course> getAllCourse(String topicId){
    List<Course> course = new ArrayList<Course>();
    Iterator<Course> i = courseRepository.findByTopicId(topicId).iterator();
    while(i.hasNext()){
      course.add(i.next());
    }
    return course;
  }

  public Course getCourse(String id){
    /*for(Topic topic : topics){
      if(topic.getId().equals(id)){
        return topic;
      }
    }
    return null;*/
    //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    return courseRepository.findOne(id);
  }

  public void addCourse(Course course){
    //topics.add(topic);
    courseRepository.save(course);
  }

  public void updateCourse(Course course){
   /*for(int i = 0; i < topics.size(); i++){
     Topic temp = topics.get(i);
     if(temp.getId().equals(id)){
      topics.set(i, topic);
       break;
     }
   }*/
    courseRepository.save(course);
  }

  public void deleteCourse(String id){
   /* for(int i = 0; i < topics.size(); i++){
      Topic temp = topics.get(i);
      if(temp.getId().equals(id)){
        topics.remove(i);
      }
    }*/
    courseRepository.delete(id);
  }

}
