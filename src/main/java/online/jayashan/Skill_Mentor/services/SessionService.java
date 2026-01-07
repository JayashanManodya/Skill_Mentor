package online.jayashan.Skill_Mentor.services;

import online.jayashan.Skill_Mentor.dto.SessionDTO;
import online.jayashan.Skill_Mentor.entities.Session;

import java.util.List;

public interface SessionService {

    Session createNewSession(SessionDTO sessionDTO);
    List<Session> getAllSessions();
    Session getSessionById(Long id);
    Session updateSessionById(Long id, SessionDTO updatedSessionDTO);
    void deleteSession(Long id);
}
