package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "programs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramsModel extends BaseModel {

    @Column(name = "underGraduate",nullable = false)
    private String underGraduate;

    @Column(name = "postGraduate",nullable = false)
    private String postGraduate;

}
