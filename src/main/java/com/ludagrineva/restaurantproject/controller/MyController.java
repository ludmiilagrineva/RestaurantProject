package com.ludagrineva.restaurantproject.controller;


import com.ludagrineva.restaurantproject.entity.RestaurantInfo;
import com.ludagrineva.restaurantproject.excelExporter.ExcelFileExporter;
import com.ludagrineva.restaurantproject.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ExcelFileExporter excelFileExporter;

//возвращает главную страницу
    @RequestMapping("/")
    public String showFormForUpdate(@ModelAttribute RestaurantInfo restaurantInfo, Model model) {


        model.addAttribute("restaur", restaurantInfo);

        return "mainPage";

    }

//возвращает страницу со всеми ресторанами
    @GetMapping("/allRestaurantInfo")
    public String showAllRest(Model model) {
        List<RestaurantInfo> allRestaurantInfo = restaurantService.getAllRestaurantInfo();
        model.addAttribute("allRestaurantInfo", allRestaurantInfo);
        return "showAllRestaurant";
    }
//показывает подробныц расчет о выбранном ресторане по id
    @GetMapping("/show")
    public String showCalc(@RequestParam("showId") int id, Model model) {
        RestaurantInfo ri = restaurantService.getRestaurantInfo(id);
        model.addAttribute("ri", ri);
        return "showInfoRest";
    }

//сохраняет расчет и сразу же показывает результаты расчетов
    @PostMapping("/saveRest")
    public String newCalculate(@ModelAttribute("restaur") RestaurantInfo ri, Model model) {

        RestaurantInfo restaurantInfo = restaurantService.saveRestaurantInfo(ri);

        model.addAttribute("restInfoFromDb", restaurantInfo);
        return "showCalc";
    }

//удаляет расчет по id
    @RequestMapping("/delete")
    public String delete(@RequestParam("deleteId") int id) {
        restaurantService.deleteRestaurantInfo(id);
        return "redirect:/allRestaurantInfo";
    }


//метод сохраняет отчет с одним рестораном
    @GetMapping("/saveReport")
    public ResponseEntity<InputStreamResource> saveReport(@RequestParam("restInfoId") int id) throws FileNotFoundException {
        RestaurantInfo restaurantInfo = restaurantService.getRestaurantInfo(id);

String[]testHeaders=new String[]{"Название ресторана", "Дата расчета", "Затраты при открытии", "Расчет потенциальной прибыльности", "Расчет времени окупаемости(в месяцах)", "Расчет времени окупаемости(в годах)", "Тип недвижимости", "Стоимость помещения", "Затраты на материалы для ремонта помещения", "Оборудование и мебель", "Лицензии", "Реклама при открытии", "Затраты на рабочих, делающих ремонт", "Налоги", "Прочее", "Планируемый средний чек", "Средняя посещаемость ресторана (человек в месяц)", "Затраты на персонал", "Затраты на продукты", "Иные затраты(коммуналка, охрана, транспорт и пр.)"};

        String filePath = "src/main/java/com/ludagrineva/restaurantproject/excelExporter/report.xlsx";
        File file = new File(filePath);

        // Export Excel file
        ExcelFileExporter excelFileExporter = new ExcelFileExporter();
        excelFileExporter.exportExcelFile(restaurantInfo, testHeaders, filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" + "report.xlsx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
//метод сохраняет отчет со всеми сохраненными ресторанами
    @GetMapping("/saveAllReport")
    public ResponseEntity<InputStreamResource> saveAllReport () throws FileNotFoundException {
        List<RestaurantInfo> restaurantInfo = restaurantService.getAllRestaurantInfo();

        String[]testHeaders=new String[]{"Название ресторана", "Дата расчета", "Затраты при открытии", "Расчет потенциальной прибыльности", "Расчет времени окупаемости(в месяцах)", "Расчет времени окупаемости(в годах)", "Тип недвижимости", "Стоимость помещения", "Затраты на материалы для ремонта помещения", "Оборудование и мебель", "Лицензии", "Реклама при открытии", "Затраты на рабочих, делающих ремонт", "Налоги", "Прочее", "Планируемый средний чек", "Средняя посещаемость ресторана (человек в месяц)", "Затраты на персонал", "Затраты на продукты", "Иные затраты(коммуналка, охрана, транспорт и пр.)"};

        String filePath = "src/main/java/com/ludagrineva/restaurantproject/excelExporter/report.xlsx";
        File file = new File(filePath);

        // Export Excel file
        ExcelFileExporter excelFileExporter = new ExcelFileExporter();
        excelFileExporter.exportAllExcelFile(restaurantInfo, testHeaders, filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" + "report.xlsx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}




