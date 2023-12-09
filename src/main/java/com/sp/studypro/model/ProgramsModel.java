package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.enum_package.ProgramType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "programs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramsModel extends BaseModel {

    @Column(name = "program_title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    private ProgramType programType;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<SubjectsModel> subjectsModel;

}
