package com.epam.race.entity;

public enum UserType {
    ADMIN(3),
    CLIENT(1),
    BOOKMAKER(2);

    private int userTypeId;

    UserType(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }
}
