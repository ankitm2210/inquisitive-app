package com.inquisitive.datawrite.repository;

import com.inquisitive.datawrite.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ankitmishra on 27/01/20.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
