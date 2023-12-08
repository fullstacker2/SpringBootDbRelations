package com.example.springbootdbrelations.Service;

import com.example.springbootdbrelations.Entity.Course;
import com.example.springbootdbrelations.Entity.Learner;
import com.example.springbootdbrelations.Repository.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnerRepo learnerRepo;

    public Learner assignProfile(int id, Course course) {
        Optional<Learner> ap = learnerRepo.findById(id);
        if(ap.isEmpty()) {
            throw new RuntimeException("Learner id " + id + " doesn't exist");
        }
        Learner learnerCourse = ap.get();
        learnerCourse.setCourse(course);
        return learnerRepo.save(learnerCourse);
    }

}
