package com.ludagrineva.restaurantproject.entity;



import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name="restaurant_info")
public class RestaurantInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "RESTAURANT_ID")
        private int restaurantId;
        @Column(name = "RESTAURANT_NAME")
        private String restaurantName;
    @CreationTimestamp
        @Column(name = "DATE_CALCULATION")
        private Timestamp dateCalculation;
    @Column(name = "ROOM_AREA")
    private int roomArea;
    @Column(name="COST_BUY")
    private int costBuy;
    @Column(name="COST_RENT")
    private double costRent;
    @Column(name="PERIOD_RENTA")
    private int periodRenta;
        @Column(name = "COST_ROOM")
        private double costRoom;
        @Column(name = "COST_RENOVATION")
        private double costRenovation;
        @Column(name = "COST_EQUIPMENT")
        private double costEquipment;
        @Column(name = "LICENSE")
        private double license;
    @Column(name = "ADVERTISING")
    private double abvertising;
    @Column(name = "COST_WORKERS")
    private double costWorkers;
    @Column(name = "TAXES")
    private double taxes;
    @Column(name = "OTHER")
    private double other;
    @Column(name = "AVERAGE_BILL")
    private double averageBill;
    @Column(name = "AVERAGE_ATTENDANCE")
    private double averageAttendance;
    @Column(name = "FUTURE_PROCEED")
    private double futureProceed;
    @Column(name = "COSTS_PERSONNEL")
    private double costsPersonnel;
    @Column(name = "COSTS_PRODUCTS")
    private double costsProducts;
    @Column(name = "OTHER_COSTS")
    private double otherCosts;
    @Column(name = "COST_OPENING")
    private double costOpening;
    @Column(name = "PROFIT")
    private double profit;
    @Column(name = "OPERATING")
    private double operating;

    public RestaurantInfo() {
    }

    public RestaurantInfo(int restaurantId, String restaurantName, Timestamp dateCalculation, int roomArea, int costBuy, double costRent, int periodRenta, double costRoom, double costRenovation, double costEquipment, double license, double abvertising, double costWorkers, double taxes, double other, double averageBill, double averageAttendance, double futureProceed, double costsPersonnel, double costsProducts, double otherCosts, double costOpening, double profit, double operating) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.dateCalculation = dateCalculation;
        this.roomArea = roomArea;
        this.costBuy = costBuy;
        this.costRent = costRent;
        this.periodRenta = periodRenta;
        this.costRoom = costRoom;
        this.costRenovation = costRenovation;
        this.costEquipment = costEquipment;
        this.license = license;
        this.abvertising = abvertising;
        this.costWorkers = costWorkers;
        this.taxes = taxes;
        this.other = other;
        this.averageBill = averageBill;
        this.averageAttendance = averageAttendance;
        this.futureProceed = futureProceed;
        this.costsPersonnel = costsPersonnel;
        this.costsProducts = costsProducts;
        this.otherCosts = otherCosts;
        this.costOpening = costOpening;
        this.profit = profit;
        this.operating = operating;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Timestamp getDateCalculation() {
        return dateCalculation;
    }

    public void setDateCalculation(Timestamp dateCalculation) {
        this.dateCalculation = dateCalculation;
    }

    public int getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(int roomArea) {
        this.roomArea = roomArea;
    }

    public int getCostBuy() {
        return costBuy;
    }

    public void setCostBuy(int costBuy) {
        this.costBuy = costBuy;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public int getPeriodRenta() {
        return periodRenta;
    }

    public void setPeriodRenta(int periodRenta) {
        this.periodRenta = periodRenta;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getCostRoom() {
        return costRoom;
    }

    public void setCostRoom(double costRoom) {
        this.costRoom = costRoom;
    }

    public double getCostRenovation() {
        return costRenovation;
    }

    public void setCostRenovation(double costRenovation) {
        this.costRenovation = costRenovation;
    }

    public double getCostEquipment() {
        return costEquipment;
    }

    public void setCostEquipment(double costEquipment) {
        this.costEquipment = costEquipment;
    }

    public double getLicense() {
        return license;
    }

    public void setLicense(double license) {
        this.license = license;
    }

    public double getAbvertising() {
        return abvertising;
    }

    public void setAbvertising(double abvertising) {
        this.abvertising = abvertising;
    }

    public double getCostWorkers() {
        return costWorkers;
    }

    public void setCostWorkers(double costWorkers) {
        this.costWorkers = costWorkers;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public double getAverageBill() {
        return averageBill;
    }

    public void setAverageBill(double averageBill) {
        this.averageBill = averageBill;
    }

    public double getAverageAttendance() {
        return averageAttendance;
    }

    public void setAverageAttendance(double averageAttendance) {
        this.averageAttendance = averageAttendance;
    }

    public double getFutureProceed() {
        return futureProceed;
    }

    public void setFutureProceed(double futureProceed) {
        this.futureProceed = futureProceed;
    }

    public double getCostsPersonnel() {
        return costsPersonnel;
    }

    public void setCostsPersonnel(double costsPersonnel) {
        this.costsPersonnel = costsPersonnel;
    }

    public double getCostsProducts() {
        return costsProducts;
    }

    public void setCostsProducts(double costsProducts) {
        this.costsProducts = costsProducts;
    }

    public double getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(double otherCosts) {
        this.otherCosts = otherCosts;
    }

    public double getCostOpening() {
        return costOpening;
    }

    public void setCostOpening(double costOpening) {
        this.costOpening = costOpening;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getOperating() {
        return operating;
    }

    public void setOperating(double operating) {
        this.operating = operating;
    }

    @Override
    public String toString() {
        return "RestaurantInfo{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", dateCalculation=" + dateCalculation +
                ", roomArea=" + roomArea +
                ", costBuy=" + costBuy +
                ", costRent=" + costRent +
                ", periodRenta=" + periodRenta +
                ", costRoom=" + costRoom +
                ", costRenovation=" + costRenovation +
                ", costEquipment=" + costEquipment +
                ", license=" + license +
                ", abvertising=" + abvertising +
                ", costWorkers=" + costWorkers +
                ", taxes=" + taxes +
                ", other=" + other +
                ", averageBill=" + averageBill +
                ", averageAttendance=" + averageAttendance +
                ", futureProceed=" + futureProceed +
                ", costsPersonnel=" + costsPersonnel +
                ", costsProducts=" + costsProducts +
                ", otherCosts=" + otherCosts +
                ", costOpening=" + costOpening +
                ", profit=" + profit +
                ", operating=" + operating +
                '}';
    }

//метод для расчета затрат при открытии ресторана
    public  long costsOpening(double costRoom, double costRenovation, double costEquipment, double license, double abvertising, double costWorkers, double taxes, double other){
        double result=costRoom+costRenovation+ costEquipment+license+abvertising+costWorkers+taxes+other;
        return Math.round(result);
    }
    //метод для расчета потенциальной прибыльности
    public  long profit(double futureProceed, double costsPersonnel, double costsProducts, double otherCosts, double costRent){
        double result=futureProceed-costsPersonnel- costsProducts-otherCosts-costRent;
        return Math.round(result);
    }
    //метод для расчета времени окупаемости в месяцах
    public  String timePaybackMounth(double costRoom, double costRenovation, double costEquipment, double license, double abvertising, double costWorkers, double taxes, double other, double futureProceed, double operating){
        double costsOpening=costRoom+costRenovation+ costEquipment+license+abvertising+costWorkers+taxes+other;
        double result=costsOpening/(futureProceed-operating);
        if (result > 0.01) {
            return Double.toString(Math.round(result*100.0)/100.0);
        } else if(result<=0){
            return "Ресторан не окупится";
        }else {
            return Double.toString(Math.round(result*1000000.0)/1000000.0);
        }
//метод для расчета времени окупаемости в годах
    }
    public  String timePaybackYear(double costRoom, double costRenovation, double costEquipment, double license, double abvertising, double costWorkers, double taxes, double other, double futureProceed, double operating) {
        double costsOpening = costRoom + costRenovation + costEquipment + license + abvertising + costWorkers + taxes + other;
        double result = costsOpening / (futureProceed - operating)/12;
        if (result > 0.01) {
            return Double.toString(Math.round(result*100.0)/100.0);
        } else if(result<=0){
            return "Ресторан не окупится";
        }else {
            return Double.toString(Math.round(result*1000000.0)/1000000.0);
        }

    }

//метод, который возвращает тип выбранного типа недвижимости
    public String showTypeProperty(double costRent, double costBuy){
        if(costRent>0){
            return "Аренда";
        }
        else if (costBuy>0){
            return "Покупка";
        }
          else return "Собственное помещение";
    }

    //метод для форматирования даты в необходимый формат
    public static String formatDate(Timestamp timestamp){
        String pattern="dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(timestamp);

    }


}
