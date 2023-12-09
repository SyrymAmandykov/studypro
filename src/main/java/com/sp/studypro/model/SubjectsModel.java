package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectsModel extends BaseModel {

    @Column(name = "subjects", nullable = false)
    private String name;

}
