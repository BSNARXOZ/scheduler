package org.bsn.scheduler.model;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bsn.scheduler.enums.AuditoriumType;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auditoriums")
public class Auditorium {
    @Id
    private UUID id;
    private String name;
    private Integer capacity;
    private AuditoriumType type;

    @PostConstruct
    public void init() {
        this.id = UUID.randomUUID();
    }
}
