package com.ludagrineva.restaurantproject.dao;




import com.ludagrineva.restaurantproject.entity.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends JpaRepository<RestaurantInfo, Integer> {


    }


