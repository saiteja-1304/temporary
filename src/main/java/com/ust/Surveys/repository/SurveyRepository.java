package com.ust.Surveys.repository;

//import com.ust.Surveys.client.FullResponse;
import com.ust.Surveys.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, String> {
    //FullResponse addSurvey(FullResponse fullResponse);
}
