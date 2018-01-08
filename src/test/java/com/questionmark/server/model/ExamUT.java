package com.questionmark.server.model;

import com.questionmark.model.Exam;
import com.questionmark.model.dto.ExamCreatingDTO;
import com.questionmark.model.dto.ExamUpdateDTO;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import static org.junit.Assert.assertEquals;


public class ExamUT {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void checkExamMapping() {
        ExamCreatingDTO creation = new ExamCreatingDTO();
        creation.setTitle("Testing title");
        creation.setDescription("Testing description");

        Exam exam = modelMapper.map(creation, Exam.class);
        assertEquals(creation.getTitle(), exam.getTitle());
        assertEquals(creation.getDescription(), exam.getDescription());
        assertEquals(creation.getCreatedAt(), exam.getCreatedAt());
        assertEquals(creation.getEditedAt(), exam.getEditedAt());

        ExamUpdateDTO update = new ExamUpdateDTO();
        update.setTitle("New title");
        update.setDescription("New description");

        modelMapper.map(update, exam);
        assertEquals(update.getTitle(), exam.getTitle());
        assertEquals(update.getDescription(), exam.getDescription());
        assertEquals(creation.getCreatedAt(), exam.getCreatedAt());
        assertEquals(update.getEditedAt(), exam.getEditedAt());
    }
}