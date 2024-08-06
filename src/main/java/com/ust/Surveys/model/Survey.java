package com.ust.Surveys.model;

//import com.ust.Surveys.client.SetInfo;
import feign.Response;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="survey")
public class Survey {
    @Id
    private String surveyId;
    private String domain;
    private String status;
    private String email;
    private String companyName;
    private String setName;
    @OneToOne
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "set_id")
    private SetInfo setInfo;

}
