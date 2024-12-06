package org.bsn.scheduler.contoller;

import lombok.RequiredArgsConstructor;
import org.bsn.scheduler.dto.request.ProgramRequest;
import org.bsn.scheduler.model.Program;
import org.bsn.scheduler.service.ProgramService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/program")
@RequiredArgsConstructor
@Validated
public class ProgramController {
    private final ProgramService programService;

    @GetMapping
    public List<Program> getAllPrograms() {
           return programService.getAllPrograms();
    }

    @GetMapping("{id}")
    public Program getProgramById(@PathVariable UUID id) {
        return programService.getProgramById(id);
    }

    @PostMapping
    public Program createProgram(@Validated @RequestBody ProgramRequest request) {
        return programService.createProgram(request);
    }

    @PutMapping("{id}")
    public Program updateProgram(@PathVariable UUID id, @Validated @RequestBody ProgramRequest request) {
        return programService.updateProgram(id, request);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProgram(@PathVariable UUID id) {
        programService.deleteProgram(id);
        return ResponseEntity.ok().build();
    }
}
