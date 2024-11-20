package serviceImpl.question;

import models.Question;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;

import static serviceImpl.question.QuestionServiceImpl.loggerForQuestion;

public class QuestionFileOperation {
    public static final java.lang.String QUESTIONS_FILE_PATH = "data/questions.txt";


    public static void writeQuestionToFile(Question question) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(QUESTIONS_FILE_PATH))) {
            objectOutputStream.writeObject(question);
        } catch (Exception e) {
            loggerForQuestion.log(Level.WARNING, "writeQuestionToFile", e);
//            throw new RuntimeException(e.getMessage() + "writeQuestionToFile");
        }
    }

    public static void appendQuestionToFile(Question question) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(QUESTIONS_FILE_PATH, true)) {
            @Override
            protected void writeStreamHeader() throws IOException {

            }
        }) {
            objectOutputStream.writeObject(question);
        } catch (Exception e) {
            loggerForQuestion.log(Level.WARNING, "appendQuestionToFile", e);
//            throw new RuntimeException(e.getMessage() + "appendQuestionToFile");
        }
    }

    public static void writeQuestionsListToFile(LinkedList<Question> questions) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(QUESTIONS_FILE_PATH))) {
            for (Question question : questions) {
                objectOutputStream.writeObject(question);
            }
        } catch (Exception e) {
            loggerForQuestion.log(Level.WARNING, "writeQuestionsListToFile", e);
//            throw new RuntimeException(e.getMessage() + "writeQuestionsListToFile");
        }
    }

    public static LinkedList<Question> readAllQuestionsFromFile() {
        LinkedList<Question> localQuestions = new LinkedList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(QUESTIONS_FILE_PATH))) {
            while (true) {
                try {
                    localQuestions.add((Question) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (Exception e) {
            loggerForQuestion.log(Level.WARNING, "readAllQuestionsFromFile", e);
//            throw new RuntimeException(e.getMessage() + "readAllQuestionsFromFile");
        }
        return localQuestions;
    }

}