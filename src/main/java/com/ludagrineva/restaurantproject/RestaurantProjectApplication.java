package com.ludagrineva.restaurantproject;


import com.ludagrineva.restaurantproject.entity.RestaurantInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.ludagrineva.restaurantproject")
public class RestaurantProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantProjectApplication.class, args);
    }

}
