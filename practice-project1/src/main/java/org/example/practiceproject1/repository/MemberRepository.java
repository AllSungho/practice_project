package org.example.practiceproject1.repository;

import org.example.practiceproject1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
