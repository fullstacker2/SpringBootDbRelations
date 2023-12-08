package com.example.springbootdbrelations.Service;

import com.example.springbootdbrelations.Entity.Course;
import com.example.springbootdbrelations.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    // create course
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    //get course by id
    public Course getCourseById(int id) {
        return courseRepo.findById(id).get();
    }

    //get all courses
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    // get number of courses
    public int countCourses() {
        return courseRepo.findAll().size();
    }

    //remove course
    public void removeCourseById(int id) {
        Optional<Course> tempCourse = courseRepo.findById(id);
        if(tempCourse.isEmpty()) {
            throw new RuntimeException("Course id" + id + "doesn't exist");
        }
        courseRepo.deleteById(id);
    }

    // check if course id exists
    public boolean CheckIdExists(int id) {
        Optional<Course> tempCourse = courseRepo.findById(id);
        return tempCourse.isPresent();
    }

    // updating course
    public void updateCourse(Course course) {
        var tempCourse = courseRepo.findById(course.getCourse_id());
        if(tempCourse.isEmpty()) {
            throw new RuntimeException("given course doesn't exist");
        }
        var courseRec = tempCourse.get();
        if (course.getCourse_name() != null)
            courseRec.setCourse_name(course.getCourse_name());

        if (course.getCourse_description() != null)
            courseRec.setCourse_description(course.getCourse_description());

        courseRepo.save(courseRec);
    }

}
