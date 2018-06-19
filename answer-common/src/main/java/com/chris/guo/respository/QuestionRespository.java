package com.chris.guo.respository;

import com.chris.guo.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRespository extends JpaRepository<Question,Long> {
}
