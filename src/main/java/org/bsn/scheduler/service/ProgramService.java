package org.bsn.scheduler.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.bsn.scheduler.dto.request.ProgramRequest;
import org.bsn.scheduler.model.Program;
import org.bsn.scheduler.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ProgramRepository programRepository;

    public Program getProgramById(UUID id) {
        return programRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Failed to find program with id: " + id));
    }

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Program createProgram(ProgramRequest request) {
        Program program = Program.builder()
                .name(request.getName())
                .build();
        return programRepository.save(program);
    }

    public Program updateProgram(UUID id, ProgramRequest request) {
        Program program = getProgramById(id);
        program.setName(request.getName());
        return programRepository.save(program);
    }

    public void deleteProgram(UUID id) {
        programRepository.deleteById(id);
    }
}
