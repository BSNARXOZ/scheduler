package org.bsn.scheduler.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bsn.scheduler.enums.AuditoriumType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriumRequest {
    @NotBlank
    private String name;
    @NotNull
    @Min(value = 1)
    private Integer capacity;
    @NotNull
    private AuditoriumType type;
}
