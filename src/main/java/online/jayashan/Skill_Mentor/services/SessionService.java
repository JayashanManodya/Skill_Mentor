package online.jayashan.Skill_Mentor.services;

import online.jayashan.Skill_Mentor.dto.SessionDTO;
import online.jayashan.Skill_Mentor.entities.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SessionService {

    Session createNewSession(SessionDTO sessionDTO);
    Page<Session> getAllSessions(Pageable pageable);
    Session getSessionById(Long id);
    Session updateSessionById(Long id, SessionDTO updatedSessionDTO);
    void deleteSession(Long id);
}
