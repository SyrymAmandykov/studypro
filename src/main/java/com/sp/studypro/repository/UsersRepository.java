package com.sp.studypro.repository;

import com.sp.studypro.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel,Long> {

    UsersModel findByEmail(String email);
    UsersModel findUsersModelById(Long userId);

}
