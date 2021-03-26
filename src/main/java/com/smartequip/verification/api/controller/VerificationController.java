package com.smartequip.verification.api.controller;

import com.smartequip.verification.api.service.dto.QuestionDto;
import com.smartequip.verification.api.service.dto.QuestionRequestDto;
import com.smartequip.verification.api.service.QuestionService;
import com.smartequip.verification.api.util.QuestionDtoRW;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VerificationController {

    private final QuestionService questionService;
    private final QuestionDtoRW questionDtoRW;

    public VerificationController(QuestionService questionService, QuestionDtoRW questionDtoRW) {
        this.questionService = questionService;
        this.questionDtoRW = questionDtoRW;
    }

    @GetMapping(value = "/")
    public ResponseEntity<QuestionDto> serviceOne() throws Exception{
        QuestionDto questionDto = questionService.getQuestion();
        //questionDtoRW.toSerialize(questionDto);
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> serviceTwo(@RequestBody QuestionRequestDto questionRequestDto) throws Exception{
        QuestionDto questionDto = questionService.findById();
       // questionService.deleteById();
       // QuestionDto questionDto = questionDtoRW.deSerialize();
        boolean isCorrect = isPreviousRequest(questionRequestDto.getNumbers(), questionDto.getNumbers());
        if(!isCorrect)
           return new ResponseEntity<>(new String("Invalid Question! "),HttpStatus.BAD_REQUEST);
       int num[] = questionRequestDto.getNumbers();
        int sumNum = getSum(num);
        if(questionRequestDto.getAnswer() == sumNum){
            return new ResponseEntity<>(new String("Correct Answer"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new String("Wrong Answer. Try Again "), HttpStatus.BAD_REQUEST);
    }

    private boolean isPreviousRequest(int[] previous, int[] current) {
        if(previous.length==current.length){
            for(int i=0; i<previous.length;i++){
                if(previous[i]!=current[i])
                    return false;
            }
            return true;
        }
        return false;

    }

    private int getSum(int[] num) {
        int sum = 0;
        for(int n: num){
            sum = sum + n;
        }
        return sum;
    }


}
