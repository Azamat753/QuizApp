package com.lawlett.quizapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {
    private String category;

    private EType type;

    private String difficulty;

    private String question;

    @SerializedName("correct_answer")
    private String correctAnswer;

    @SerializedName("incorrect_answers")
    private List<String> incorrectAnswer;

    private String selectedAnswer;

    private List<String>answers;

    private Integer selectedAnswersPosition ;


    public Question(String category, EType type, String difficulty, String question, String correctAnswer, List<String> incorrectAnswer, String selectedAnswer, List<String> answers, Integer selectedAnswersPosition) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
        this.selectedAnswer = selectedAnswer;
        this.answers = answers;
        this.selectedAnswersPosition = selectedAnswersPosition;
    }


    public Integer getSelectedAnswersPosition() {
        return selectedAnswersPosition;
    }

    public void setSelectedAnswersPosition(Integer selectedAnswersPosition) {
        this.selectedAnswersPosition = selectedAnswersPosition;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public void setIncorrectAnswer(List<String> incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }
}
