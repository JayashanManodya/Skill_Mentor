package online.jayashan.Skill_Mentor.exceptions;

import org.springframework.http.HttpStatus;

public class SkillMentorException extends RuntimeException{
    private final HttpStatus status;

    public SkillMentorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
