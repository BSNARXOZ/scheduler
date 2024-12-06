package org.bsn.scheduler.contoller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bsn.scheduler.dto.request.AuditoriumRequest;
import org.bsn.scheduler.model.Auditorium;
import org.bsn.scheduler.service.AuditoriumService;
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

import java.util.UUID;

@Validated
@RestController
@RequestMapping("api/v1/auditorium")
@RequiredArgsConstructor
public class AuditoriumController {
    private final AuditoriumService auditoriumService;

    @GetMapping("{id}")
    public Auditorium findAuditorim(@PathVariable("id") UUID id) {
        return auditoriumService.findById(id);
    }

    @PostMapping
    public Auditorium createAuditorium(@RequestBody @Valid AuditoriumRequest request) {
        return auditoriumService.create(request);
    }

    @PutMapping("{id}")
    public Auditorium updateAuditorium(@RequestBody @Valid AuditoriumRequest request, @PathVariable UUID id) {
        return auditoriumService.update(request, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAuditorium(@PathVariable("id") UUID id) {
        auditoriumService.delete(id);
        return ResponseEntity.ok().build();
    }
}
