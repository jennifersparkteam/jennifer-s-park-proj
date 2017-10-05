package com.example.jennifers.jenniferspark;

/**
 * Created by Jennifer's Team on 10/4/2017.
 * Parking object to store information of a parking lot
 */

public class Parking {
    /**
     * Parking lot title
     */
    private String title;
    /**
     * Parking lot address
     */
    private String address;
    /**
     * Parking lot cost
     */
    private double cost;
    /**
     * Parking lot hour
     */
    private double hour;

    /**
     * Parking Construction
     * Create new parking lot object with preset data
     *
     * @param title   Parking title
     * @param address Parking address
     * @param cost    Parking price
     * @param hour    Parking hour limited
     */
    public Parking(String title, String address, double cost, double hour) {
        this.title = title;
        this.address = address;
        this.cost = cost;
        this.hour = hour;
    }

    /**
     * Return parking title
     *
     * @return parking title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set new title for a parking lot
     *
     * @param title new parking title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return parking address
     *
     * @return parking address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set new address for a parking lot
     *
     * @param address new parking address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Return parking cost
     *
     * @return parking cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Set new cost for a parking lot
     *
     * @param cost new parking cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Return parking hour
     *
     * @return parking hour
     */
    public double getHour() {
        return hour;
    }

    /**
     * Set new hour for a parking lot
     *
     * @param hour new parking hour
     */
    public void setHour(double hour) {
        this.hour = hour;
    }
}
