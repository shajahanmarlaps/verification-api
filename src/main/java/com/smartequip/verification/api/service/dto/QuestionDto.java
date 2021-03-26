package com.smartequip.verification.api.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class QuestionDto implements Serializable {
    private String question;
    private int numbers[];
    public QuestionDto(String question, int[] numbers) {
        this.question = question;
        this.numbers = numbers;
    }

    public QuestionDto() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
