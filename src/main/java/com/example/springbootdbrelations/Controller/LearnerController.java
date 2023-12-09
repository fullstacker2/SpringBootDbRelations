package com.example.springbootdbrelations.Controller;

import com.example.springbootdbrelations.Entity.Course;
import com.example.springbootdbrelations.Entity.Learner;
import com.example.springbootdbrelations.Repository.LearnerRepo;
import com.example.springbootdbrelations.Service.LearnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learner")
public class LearnerController {
    LearnerService learnerService;

    //Create learner
    @PostMapping("/add")
    public Learner createLearner(@RequestBody Learner learner) {
        return learnerService.createLearner(learner);
    }

    @GetMapping("/{id}")
    public Learner getLearnerById(@PathVariable int id) {
        return learnerService.getLearnerById(id);
    }

    @GetMapping("/getAll")
    public List<Learner> getAllLearners() {
        return learnerService.getAllLearners();
    }

    @GetMapping("/count")
    public int countLearners() {
        return learnerService.countLearners();
    }

    @GetMapping("/del/{id}")
    public void removeLearnerById(@PathVariable int id) {
        learnerService.removeLearnerById(id);
    }

    @GetMapping("/check/{id}")
    public boolean CheckIdExists(@PathVariable int id) {
        return learnerService.CheckIdExists(id);
    }

    @PutMapping("/assign/{id}")
    public Learner assignProfile(@PathVariable int id, @RequestBody Course course) {
        return learnerService.assignProfile(id, course);
    }
}
