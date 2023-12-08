package com.sp.studypro.repository;

import com.sp.studypro.model.CommentaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository<CommentaryModel,Long> {
}
