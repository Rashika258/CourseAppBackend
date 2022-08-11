package com.springrest.springrest.controller;


import com.springrest.springrest.entites.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class MyController {


    @Autowired
    private CourseService courseService;

// for testing
//    @GetMapping("/home")
//    public String home() {
//        return "this is home page";
//    }

//    get all courses

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

// get single course
    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        System.out.println("Course Id -------"+Long.parseLong(courseId));
        return  this.courseService.getCourse(Long.parseLong(courseId));
    }

// add new course
    @PostMapping(path = "/courses", consumes = "application/json")
    public Course addCourse(@RequestBody Course course) {

        return this.courseService.addCourse(course);
    }

//    updating course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return  this.courseService.updateCourse(course);

    }

//    delete the course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
