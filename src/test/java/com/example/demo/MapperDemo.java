package com.example.demo;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarDTO;
import com.example.demo.mapper.CarMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapperDemo {




    private void test(){
//        Car car = new Car( "Morris", 5);
//        CarDTO carDto = CarMapper.INSTANCE.carToCarDto( car );
//        log.info("car:{}",car);
//        log.info("carDTO:{}", carDto);

    }

    public static void main(String[] args) {

        new MapperDemo().test();
    }
}
