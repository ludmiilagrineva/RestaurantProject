package com.ludagrineva.restaurantproject.service;




import com.ludagrineva.restaurantproject.entity.RestaurantInfo;

import java.util.List;

public interface RestaurantService {

    RestaurantInfo saveRestaurantInfo(RestaurantInfo restaurantInfo);//сохраняет данные о ресторане в БД

    List<RestaurantInfo> getAllRestaurantInfo(); // Получает из БД данные о всех ресторанах

    void deleteRestaurantInfo(int id); //Удаляет данные о ресторане, указанном в id

    RestaurantInfo getRestaurantInfo(int id); //Получает данные о ресторане, указанном в id
}
