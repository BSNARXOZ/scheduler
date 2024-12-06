package org.bsn.scheduler.mapper;

import org.bsn.scheduler.dto.request.AuditoriumRequest;
import org.bsn.scheduler.model.Auditorium;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuditoriumMapper {
    AuditoriumMapper mapper = Mappers.getMapper(AuditoriumMapper.class);

    @Mapping(target = "id", ignore = true)
    Auditorium toEntity(AuditoriumRequest auditoriumRequest);

}
