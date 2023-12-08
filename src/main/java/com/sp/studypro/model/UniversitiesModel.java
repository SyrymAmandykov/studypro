package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import com.sp.studypro.enum_package.Intake;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "universities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UniversitiesModel extends BaseModel {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "countOfStudents", nullable = false)
    private Integer countOfStudents;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ProgramsModel> programsModelList;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<SubjectsModel> subjectsModelList;

    @ManyToOne(fetch = FetchType.EAGER)
    private CountriesModel countries;

    @Enumerated(EnumType.STRING)
    private Intake intake;

}
