package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import com.sp.studypro.enum_package.Intake;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "total_clients", nullable = false)
    private Integer totalClients;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ProgramsModel> programsModelList;

    @ManyToOne(fetch = FetchType.EAGER)
    private CountriesModel countries;

    @Enumerated(EnumType.STRING)
    private Intake intake;

}
