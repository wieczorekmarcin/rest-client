package com.marcinwieczorek.studentmanagment.repositories;

import com.marcinwieczorek.studentmanagment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
