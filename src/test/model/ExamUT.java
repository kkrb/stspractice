package com.questionmark.model;

import com.questionmark.model.dto.ExamCreatingDTO;
import com.questionmark.model.dto.ExamUpdateDTO;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import static org.junit.Assert.assertArrayEquals;


public class ExamUT {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void checkExamMapping() {
        ExamCreationDTO creation = new ExamCreationDTO();
        creation.setTitle("Testing title");
        creation.setDescription("Testing description");

        Exam exam = modelMapper.map(creation, Exam.class);
        assertArrayEquals(creation.getTitle(), exam.getTitle());
        assertArrayEquals(creation.getDescription(), exam.getDescription());
        assertArrayEquals(creation.getCreatedAt(), exam.getCreatedAt());
        assertArrayEquals(creation.getEditedAt(), exam.getEditedAt());

        ExamUpdateDTO update = new ExamUpdateDTO();
        update.setTitle("New title");
        update.setDescription("New description");

        modelMapper.map(update, exam);
        assertArrayEquals(update.getTitle(), exam.getTitle());
        assertArrayEquals(update.getDescription(), exam.getDescription());
        assertArrayEquals(creation.getCreatedAt(), exam.getCreatedAt());
        assertArrayEquals(update.getEditedAt(), exam.getEditedAt());
    }
}