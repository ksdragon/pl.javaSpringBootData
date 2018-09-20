/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javaSpringBootData.course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.javaSpringBootData.topic.Topic;

/**
 *
 * @author HP ProDesk
 */
@RestController
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }
    
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{id}")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }
    
     @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.updateCourse(course);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}" )
    public void deleteCourse(@PathVariable String id){
       courseService.deleteCourse(id);
}

}
