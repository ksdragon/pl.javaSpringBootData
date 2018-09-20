/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javaSpringBootData.course;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP ProDesk
 */
@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;
    
   
    public List<Course> getAllCourses(String topicId){
        List<Course> course = new ArrayList<>();
        courseRepository.findAllByTopicId(topicId)
                .forEach(course::add);
        return course;
    }
    
    public Course getCourse(String id){
        return courseRepository.findById(id).get();
    }

    void addCourse(Course course) {
        //courses.add(course);
        courseRepository.save(course);
    }

    void updateCourse(Course course) {
    courseRepository.save(course);
    }

    void deleteCourse(String id) {
    courseRepository.deleteById(id);
}

}
