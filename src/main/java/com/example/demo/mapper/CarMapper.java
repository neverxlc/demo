package com.example.demo.mapper;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

//    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(Car car);
}
