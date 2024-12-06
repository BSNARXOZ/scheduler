package org.bsn.scheduler.repository;

import org.bsn.scheduler.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditoriumRepository  extends JpaRepository<Auditorium, UUID> {
}
