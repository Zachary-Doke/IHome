package com.ihome.pojo;

public class LightState {
    private String device_id;
    private String user_id;
    private Integer state;
    private Integer type;
    private Integer brightness;
    private Integer hour;
    private Integer weekday;

    public LightState(String device_id, String user_id, Integer state, Integer type, Integer brightness, Integer hour, Integer weekday) {
        this.device_id = device_id;
        this.user_id = user_id;
        this.state = state;
        this.type = type;
        this.brightness = brightness;
        this.hour = hour;
        this.weekday = weekday;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }
}
