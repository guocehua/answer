package com.chris.guo.respository;

import com.chris.guo.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRespository extends JpaRepository<Answer,Long> {
}
