package com.smartequip.verification.api.service.mappers;

import com.smartequip.verification.api.service.dto.QuestionDto;
import com.smartequip.verification.api.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

   public QuestionDto toQuestionDto(Question question){
       QuestionDto dto = new QuestionDto();
       //dto.setId(question.getId());
       dto.setQuestion(question.getQues());
       //dto.setAnswer(question.getAnswer());
       String numbers[] = question.getNumbers().split(",");
           int num[] = new int[numbers.length];
           int count = 0;
           for (String n: numbers) {
               num[count] = Integer.parseInt(n);
               count++;
           }
           dto.setNumbers(num);
           return dto;
    }

    public Question toEntity(QuestionDto questionDto) {
       Question question = new Question();
       question.setQues(questionDto.getQuestion());
       question.setNumbers(getString(questionDto.getNumbers()));
       return question;
    }

    private String getString(int[] numbers) {
       StringBuilder sb = new StringBuilder();
        for (int n: numbers
             ) {
                sb.append(n+",");
        }
        String s = sb.toString();

        return s.substring(0,s.length()-1);
    }
}
