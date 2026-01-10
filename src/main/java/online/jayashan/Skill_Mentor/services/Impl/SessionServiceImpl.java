package online.jayashan.Skill_Mentor.services.Impl;

import lombok.AllArgsConstructor;
import online.jayashan.Skill_Mentor.dto.SessionDTO;
import online.jayashan.Skill_Mentor.entities.Session;
import online.jayashan.Skill_Mentor.repositories.SessionRepository;
import online.jayashan.Skill_Mentor.services.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final ModelMapper modelMapper;


    @Override
    public Session createNewSession(SessionDTO sessionDTO) {
        Session session = modelMapper.map(sessionDTO, Session.class);
        return sessionRepository.save(session);
    }

    @Override
    public Page<Session> getAllSessions(Pageable pageable) {
        return sessionRepository.findAll(pageable);
    }

    @Override
    public Session getSessionById(Long id) {
        return sessionRepository.getReferenceById(id);
    }

    @Override
    public Session updateSessionById(Long id, SessionDTO updatedSessionDTO) {
        return null;
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}
