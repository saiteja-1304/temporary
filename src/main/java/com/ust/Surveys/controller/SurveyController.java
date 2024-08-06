package com.ust.Surveys.controller;

import com.ust.Surveys.feign.AssessmentClient;
import com.ust.Surveys.model.Survey;
import com.ust.Surveys.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")

public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private AssessmentClient assessmentFeignClient;


    @PostMapping("/addSurvey")
    public Survey addSurvey(@RequestBody Survey survey) {
        return surveyService.addSurvey(survey);
    }

    @GetMapping("/Survey/{surveyId}")
    public Survey getSurvey(@PathVariable String surveyId) {
        return surveyService.getSurvey(surveyId);
    }

    @GetMapping("/surveys")
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }
}
