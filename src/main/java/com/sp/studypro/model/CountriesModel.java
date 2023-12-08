package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "countries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountriesModel extends BaseModel {

    @Column(name = "countries",nullable = false)
    private String countries;

}
