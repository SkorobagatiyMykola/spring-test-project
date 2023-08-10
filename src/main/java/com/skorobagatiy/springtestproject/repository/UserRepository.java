package com.skorobagatiy.springtestproject.repository;

import com.skorobagatiy.springtestproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    @Transactional
//    @Modifying
//    @Query("UPDATE User u SET u.name = :name, u.userName = :userName, u.preferredAccountId = :preferredAccountId WHERE u.id = :userId")
//    User updateUser(@Param("userId") Long id,
//                    @Param("name") String name,
//                    @Param("userName") String userName,
//                    @Param("preferredAccountId") String preferredAccountId);
}
