package org.bsn.scheduler.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.bsn.scheduler.dto.request.AuditoriumRequest;
import org.bsn.scheduler.mapper.AuditoriumMapper;
import org.bsn.scheduler.model.Auditorium;
import org.bsn.scheduler.repository.AuditoriumRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditoriumService {
    private final AuditoriumRepository auditoriumRepository;
    private final AuditoriumMapper auditoriumMapper;

    public Auditorium findById(UUID id) {
        return auditoriumRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Failed to find auditorium with id: " + id));
    }

    public Auditorium create(AuditoriumRequest request) {
        Auditorium auditorium = auditoriumMapper.toEntity(request);
        return auditoriumRepository.save(auditorium);
    }

    public Auditorium update(AuditoriumRequest request, UUID id) {
        Auditorium auditorium = findById(id);
        auditorium.setId(id);
        return auditoriumRepository.save(auditorium);
    }

    public void delete(UUID id) {
        auditoriumRepository.deleteById(id);
    }
}
