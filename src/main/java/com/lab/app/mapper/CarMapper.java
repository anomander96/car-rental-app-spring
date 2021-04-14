package com.lab.app.mapper;

import com.lab.app.dto.CarDto;
import com.lab.app.model.Car;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper {

    Car mapCarDtoToCar(CarDto carDto);

    CarDto mapCarToCarDto(Car car);
}
