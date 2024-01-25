package com.ludagrineva.restaurantproject.excelExporter;
import com.ludagrineva.restaurantproject.entity.RestaurantInfo;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Excel File Exporter
 */
@Service
public class ExcelFileExporter {


    public void exportExcelFile(RestaurantInfo restaurantInfo, String[] headers, String fileName) {
        // create a new Workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a new Sheet named "Contacts"
        Sheet sheet = workbook.createSheet("report");

        // Create header row
        createHeaderRow(workbook, sheet, headers);



            int rowIndex = 1;
            createNewRow(workbook, sheet, rowIndex, restaurantInfo);


        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(6);
        sheet.autoSizeColumn(7);
        sheet.autoSizeColumn(8);
        sheet.autoSizeColumn(9);
        sheet.autoSizeColumn(10);
        sheet.autoSizeColumn(11);
        sheet.autoSizeColumn(12);
        sheet.autoSizeColumn(13);
        sheet.autoSizeColumn(14);
        sheet.autoSizeColumn(15);
        sheet.autoSizeColumn(16);
        sheet.autoSizeColumn(17);
        sheet.autoSizeColumn(18);
        sheet.autoSizeColumn(19);

        // Write to file
        try (OutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHeaderRow(Workbook workbook, Sheet sheet, String[] headers) {
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setRightBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setLeftBorderColor(IndexedColors.BLACK.index);

        for(int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }


    public void createNewRow(Workbook workbook, Sheet sheet, int rowIndex, RestaurantInfo restaurantInfo) {
        Row row = sheet.createRow(rowIndex);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.index);

        Cell cell = row.createCell(0);
        cell.setCellValue(restaurantInfo.getRestaurantName());
        cell.setCellStyle(cellStyle);


        cell = row.createCell(1);
        cell.setCellValue(RestaurantInfo.formatDate(restaurantInfo.getDateCalculation()));
        cell.setCellStyle(cellStyle);

        cell = row.createCell(2);
        cell.setCellValue(restaurantInfo.costsOpening(restaurantInfo.getCostRoom(), restaurantInfo.getCostRenovation(), restaurantInfo.getCostEquipment(), restaurantInfo.getLicense(), restaurantInfo.getAbvertising(), restaurantInfo.getCostWorkers(), restaurantInfo.getTaxes(), restaurantInfo.getOther()));
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        cell.setCellValue(restaurantInfo.profit(restaurantInfo.getFutureProceed(), restaurantInfo.getCostsPersonnel(), restaurantInfo.getCostsProducts(), restaurantInfo.getOtherCosts(), restaurantInfo.getCostRent()));
        cell.setCellStyle(cellStyle);

        cell = row.createCell(4);
        cell.setCellValue(restaurantInfo.timePaybackMounth(restaurantInfo.getCostRoom(), restaurantInfo.getCostRenovation(), restaurantInfo.getCostEquipment(), restaurantInfo.getLicense(), restaurantInfo.getAbvertising(), restaurantInfo.getCostWorkers(), restaurantInfo.getTaxes(), restaurantInfo.getOther(), restaurantInfo.getFutureProceed(), restaurantInfo.getOperating()));
        cell.setCellStyle(cellStyle);
        cell = row.createCell(5);
        cell.setCellValue(restaurantInfo.timePaybackYear(restaurantInfo.getCostRoom(), restaurantInfo.getCostRenovation(), restaurantInfo.getCostEquipment(), restaurantInfo.getLicense(), restaurantInfo.getAbvertising(), restaurantInfo.getCostWorkers(), restaurantInfo.getTaxes(), restaurantInfo.getOther(), restaurantInfo.getFutureProceed(), restaurantInfo.getOperating()));
        cell.setCellStyle(cellStyle);

        cell = row.createCell(6);
        cell.setCellValue(restaurantInfo.showTypeProperty(restaurantInfo.getCostRent(), restaurantInfo.getCostBuy()));
        cell.setCellStyle(cellStyle);

        cell = row.createCell(7);
        cell.setCellValue(restaurantInfo.getCostRoom());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(8);
        cell.setCellValue(restaurantInfo.getCostRenovation());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(9);
        cell.setCellValue(restaurantInfo.getCostEquipment());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(10);
        cell.setCellValue(restaurantInfo.getLicense());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(11);
        cell.setCellValue(restaurantInfo.getAbvertising());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(12);
        cell.setCellValue(restaurantInfo.getCostWorkers());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(13);
        cell.setCellValue(restaurantInfo.getTaxes());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(14);
        cell.setCellValue(restaurantInfo.getOther());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(15);
        cell.setCellValue(restaurantInfo.getAverageBill());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(16);
        cell.setCellValue(restaurantInfo.getAverageAttendance());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(17);
        cell.setCellValue(restaurantInfo.getCostsPersonnel());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(18);
        cell.setCellValue(restaurantInfo.getCostsProducts());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(19);
        cell.setCellValue(restaurantInfo.getOtherCosts());
        cell.setCellStyle(cellStyle);
    }



    public void exportAllExcelFile(List<RestaurantInfo> restaurantInfo, String[] headers, String fileName) {
        // create a new Workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a new Sheet named "Contacts"
        Sheet sheet = workbook.createSheet("report");

        // Create header row
        createHeaderRow(workbook, sheet, headers);


        int rowIndex = 1;

        for (RestaurantInfo info : restaurantInfo) {

            createNewRow(workbook, sheet, rowIndex, info);


            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.autoSizeColumn(9);
            sheet.autoSizeColumn(10);
            sheet.autoSizeColumn(11);
            sheet.autoSizeColumn(12);
            sheet.autoSizeColumn(13);
            sheet.autoSizeColumn(14);
            sheet.autoSizeColumn(15);
            sheet.autoSizeColumn(16);
            sheet.autoSizeColumn(17);
            sheet.autoSizeColumn(18);
            sheet.autoSizeColumn(19);


            rowIndex++;


            // Write to file
            try (OutputStream outputStream = new FileOutputStream(fileName)) {
                workbook.write(outputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}

