package com.smartequip.verification.api.service;

import com.smartequip.verification.api.service.dto.QuestionDto;

public interface QuestionService {
    public QuestionDto getQuestion();
    public QuestionDto findById();
    public void deleteById();
}
