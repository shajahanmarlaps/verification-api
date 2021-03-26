package com.smartequip.verification.api.util;

import com.smartequip.verification.api.service.dto.QuestionDto;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
@Component
public class QuestionDtoRW {
    String fileName = "question.ser";
    public void toSerialize(QuestionDto questionDto) throws Exception{
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(out);
        out.close();
        file.close();
    }

    public QuestionDto deSerialize() throws Exception{
        QuestionDto questionDto = new QuestionDto();
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);
        questionDto = (QuestionDto) in.readObject();
        in.close();
        file.close();
        return questionDto;
    }
}
