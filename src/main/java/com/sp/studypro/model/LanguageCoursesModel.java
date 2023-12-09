package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import com.sp.studypro.enum_package.Intake;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LanguageCourses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCoursesModel extends BaseModel {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "total_clients", nullable = false)
    private Integer totalClients;

    @ManyToOne(fetch = FetchType.EAGER)
    private CountriesModel countries;

    @Enumerated(EnumType.STRING)
    private Intake intake;

}
