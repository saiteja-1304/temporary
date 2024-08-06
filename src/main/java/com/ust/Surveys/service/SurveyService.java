package com.ust.Surveys.service;

//import com.ust.Surveys.client.SetInfo;
import com.ust.Surveys.feign.AssessmentClient;
import com.ust.Surveys.model.SetInfo;
import com.ust.Surveys.model.Survey;
import com.ust.Surveys.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AssessmentClient assessmentClient;



    public Survey addSurvey(Survey survey) {
//        Survey sur=new Survey();
//        sur.setSetName(survey.getSetName());
//        SetInfo setInfos=assessmentClient.getAssessmentBySetName(sur.getSetName());
//        sur.setEmail(survey.getEmail());
//        sur.setDomain(survey.getDomain());
//        sur.setStatus(survey.getStatus());
//        sur.setCompanyName(survey.getCompanyName());
//        sur.setSetinfos(setInfos);
//        return surveyRepository.save(sur);
        return surveyRepository.save(survey);
    }


    public Survey getSurvey(String surveyId) {
        Optional<Survey> survey = surveyRepository.findById(surveyId);
        if(survey.isPresent()){
            Survey survey1=survey.get();
            //SetInfo setInfos=assessmentClient.getAssessmentBySetName(survey1.getSetName()).getBody();
            Survey res= new Survey();
            res.setSetName(survey1.getSetName());
            res.setEmail(survey1.getEmail());
            res.setDomain(survey1.getDomain());
            res.setStatus(survey1.getStatus());
            res.setCompanyName(survey1.getCompanyName());
            SetInfo setInfos=assessmentClient.getAssessmentBySetName(survey1.getSetName());
           // res.setResponses(setInfos.getResponses());

            res.setSetInfo(setInfos);
            return res;
        }
        return null;
    }

    public List<Survey> getAllSurveys() {
        List<Survey> fullResponses=new ArrayList<>();
        List<Survey> surveys = surveyRepository.findAll();
        for (Survey survey : surveys) {
                SetInfo setInfos=assessmentClient.getAssessmentBySetName(survey.getSetName());
                Survey res= new Survey();
                res.setSetName(survey.getSetName());
                res.setEmail(survey.getEmail());
                res.setDomain(survey.getDomain());
                res.setStatus(survey.getStatus());
                res.setCompanyName(survey.getCompanyName());
                res.setSetInfo(setInfos);
                fullResponses.add(res);
            }
        return fullResponses;
    }
}
