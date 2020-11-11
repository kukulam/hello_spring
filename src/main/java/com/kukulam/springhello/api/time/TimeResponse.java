package com.kukulam.springhello.api.time;

class TimeResponse {
    private String time;
    private String zone;

    public TimeResponse(String time, String zone) {
        this.time = time;
        this.zone = zone;
    }

    public TimeResponse() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
