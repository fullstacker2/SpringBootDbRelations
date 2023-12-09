package com.example.springbootdbrelations.Controller;

import com.example.springbootdbrelations.Entity.Course;
import com.example.springbootdbrelations.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/getAll")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/count")
    public int countCourses() {
        return courseService.countCourses();
    }

    @GetMapping("/del/{id}")
    public void removeCourseById(@PathVariable int id) {
        courseService.removeCourseById(id);
    }

    @GetMapping("/check/{id}")
    public boolean CheckIdExists(@PathVariable int id) {
        return courseService.CheckIdExists(id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody Course course) {
        courseService.updateCourse(course);
    }

}