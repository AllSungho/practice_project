package org.example.practiceproject3.repository;

import org.example.practiceproject3.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
