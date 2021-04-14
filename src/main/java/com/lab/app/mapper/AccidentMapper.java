package com.lab.app.mapper;

import com.lab.app.dto.AccidentDto;
import com.lab.app.model.Accident;
import org.mapstruct.Mapper;

@Mapper
public interface AccidentMapper {

    Accident mapAccidentDtoToAccident(AccidentDto accidentDto);

    AccidentDto mapAccidentToAccidentDto(Accident accident);
}
