package com.ust.Surveys.model;

//import com.ust.Surveys.client.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class SetInfo {
    @Id
    private Integer setId;
    private String setName;
    private String createdBy;
    private Date createdAt;
    private Date modifiedAt;
    private String status;
    private String domain;
    @OneToMany
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "set_id")
    private List<Question> questions;
}
