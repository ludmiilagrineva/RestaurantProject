package com.ludagrineva.restaurantproject.service;


import com.ludagrineva.restaurantproject.dao.RestaurantDao;
import com.ludagrineva.restaurantproject.entity.RestaurantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    //сохраняет данные о ресторане в БД
    @Override
    @Transactional
    public RestaurantInfo saveRestaurantInfo(RestaurantInfo restaurantInfo) {
    return restaurantDao.save(restaurantInfo);
 }
    // Получает из БД данные о всех ресторанах
    @Override
    public List<RestaurantInfo> getAllRestaurantInfo() {
        return restaurantDao.findAll();
    }

    //Удаляет данные о ресторане, указанном в id
    @Override
    public void deleteRestaurantInfo(int id) {
    restaurantDao.deleteById(id);

    }
    //Получает данные о ресторане, указанном в id
   @Override
    @Transactional
    public RestaurantInfo getRestaurantInfo(int id) {
        RestaurantInfo restaurantInfo=null;
        Optional<RestaurantInfo> optional= restaurantDao.findById(id);
        if(optional.isPresent()){
            restaurantInfo=optional.get();
        }
        return restaurantInfo;
    }

}
