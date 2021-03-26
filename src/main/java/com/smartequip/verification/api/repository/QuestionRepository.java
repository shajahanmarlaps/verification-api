package com.smartequip.verification.api.repository;

import com.smartequip.verification.api.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    Question findAllById(int id);
    void deleteById(int id);
}
