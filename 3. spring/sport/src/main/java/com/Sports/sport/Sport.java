package com.Sports.sport;

public class Sport {
    private String sportName;
    private String level;

    public Sport(String sportName, String level) {
        this.sportName = sportName;
        this.level = level;
    }

    public String getSportName() {
        return sportName;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportName='" + sportName + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
