package org.example.practiceproject4.repository;

import org.example.practiceproject4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
