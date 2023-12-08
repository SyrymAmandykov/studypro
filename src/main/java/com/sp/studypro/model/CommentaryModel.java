package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "commentary")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentaryModel extends BaseModel {

    @Column(name = "commentary_title", nullable = false)
    private String title;

    @Column(name = "commentary_text", nullable = false)
    private String text;


    @ManyToOne(fetch = FetchType.EAGER)
    private UniversitiesModel universitiesModel;

    @ManyToOne(fetch = FetchType.EAGER)
    private LanguageCoursesModel languageCoursesModel;

    @ManyToOne(fetch = FetchType.EAGER)
    private UsersModel usersModel;

}
