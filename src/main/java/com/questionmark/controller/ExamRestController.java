package com.questionmark.controller;

import com.questionmark.model.Exam;
import com.questionmark.model.dto.ExamCreatingDTO;
import com.questionmark.model.dto.ExamUpdateDTO;
import com.questionmark.persistence.ExamRepository;
import com.questionmark.util.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exams-new")
public class ExamRestController {
    private ExamRepository examRepository;

    public ExamRestController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @GetMapping
    public List<Exam> getExams() {
        return examRepository.findAll();
    }

    @PostMapping
    public void newExam(@DTO(ExamCreatingDTO.class) Exam exam) {
        examRepository.save(exam);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editExam(@DTO(ExamUpdateDTO.class) Exam exam) {
        examRepository.save(exam);
    }
}