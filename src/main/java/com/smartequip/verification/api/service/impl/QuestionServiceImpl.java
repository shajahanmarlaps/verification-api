package com.smartequip.verification.api.service.impl;

import com.smartequip.verification.api.entity.Question;
import com.smartequip.verification.api.service.dto.QuestionDto;
import com.smartequip.verification.api.service.mappers.MapperUtil;
import com.smartequip.verification.api.repository.QuestionRepository;
import com.smartequip.verification.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final int questionSize;
    private final MapperUtil mapperUtil;
    @Value("${array.size}")
    private int validationArraySize;

    private int lastSavedId;

    public QuestionServiceImpl(QuestionRepository questionRepository, MapperUtil mapperUtil) {
        this.questionRepository = questionRepository;
        this.questionSize=(int) questionRepository.count();
        this.mapperUtil = mapperUtil;
    }

    @Override
    public QuestionDto getQuestion() {
//        Question question = (Question) questionRepository.findAllById(getRandNum(this.questionSize+1));
//        QuestionDto questionDto = mapperUtil.toQuestionDto(question);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestion("Please sum the numbers ");
        int arraySize = getRandNum(validationArraySize);
        int num[] = new int[arraySize];
        for(int i = 0; i<arraySize; i++)
            num[i] = getRandNum(10);
        questionDto.setNumbers(num);

        Question question = mapperUtil.toEntity(questionDto);
        questionRepository.save(question);
        this.lastSavedId = question.getId();
        return questionDto;
    }

    @Override
    public QuestionDto findById() {
        Question question = questionRepository.findAllById(lastSavedId);
        QuestionDto questionDto = mapperUtil.toQuestionDto(question);
        //deleteById();
        return questionDto;
    }

    @Override
    public void deleteById() {
        questionRepository.deleteById(lastSavedId);
        lastSavedId=0;
    }


    private int getRandNum(int size) {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(size);
            if(rand != 0 && rand != 1 ) break;
        }
        return rand;

    }
}
