/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javaSpringBootData.course;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP ProDesk
 */
public interface CourseRepository extends CrudRepository<Course, String> {    
    public List<Course> findAllByTopicId(String topicId);
}
