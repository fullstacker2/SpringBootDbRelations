package com.example.springbootdbrelations.Service;

import com.example.springbootdbrelations.Entity.Course;
import com.example.springbootdbrelations.Entity.Learner;
import com.example.springbootdbrelations.Repository.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnerRepo learnerRepo;

    public Learner createLearner(Learner learner) {
        return learnerRepo.save(learner);
    }

    public Learner getLearnerById(int id) {
        return learnerRepo.findById(id).get();
    }

    //get all learners
    public List<Learner> getAllLearners() {
        return learnerRepo.findAll();
    }

    // get number of learners
    public int countLearners() {
        return learnerRepo.findAll().size();
    }

    //remove learner
    public void removeLearnerById(int id) {
        Optional<Learner> tempLearner = learnerRepo.findById(id);
        if(tempLearner.isEmpty()) {
            throw new RuntimeException("learner id" + id + "doesn't exist");
        }
        learnerRepo.deleteById(id);
    }

    // check if id exists
    public boolean CheckIdExists(int id) {
        Optional<Learner> tempLearner = learnerRepo.findById(id);
        return tempLearner.isPresent();
    }

    // assign course
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
