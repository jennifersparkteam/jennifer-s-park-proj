package com.example.jennifers.jenniferspark;

/**
 * Created by Jennifer's Team on 10/4/2017.
 * User object to store current user
 */

public class User {
    /**
     * User name
     */
    private String name;
    /**
     * User administration permission
     */
    private int isAdmin;

    /**
     * Default constructor
     * New user created with empty name and no administration permission
     */
    public User() {
        name = "";
        isAdmin = 0;
    }

    /**
     * User constructor with preset name and administration permission
     *
     * @param name    name of user
     * @param isAdmin administration permission
     */
    public User(String name, int isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
    }

    /**
     * Set new name for current user
     *
     * @param name new user's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get name value of current user
     *
     * @return name of current user
     */
    public String getName() {
        return name;
    }

    /**
     * Get administration permission of current user
     *
     * @return administration permission of current user
     */
    public int getIsAdmin() {
        return isAdmin;
    }

    /**
     * Set new administration permission for a user
     *
     * @param isAdmin new user's administration permission
     */
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
