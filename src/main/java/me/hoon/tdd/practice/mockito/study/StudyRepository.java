package me.hoon.tdd.practice.mockito.study;

import me.hoon.tdd.practice.mockito.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
