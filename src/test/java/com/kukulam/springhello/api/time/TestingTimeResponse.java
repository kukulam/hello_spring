package com.kukulam.springhello.api.time;

import java.util.Objects;

class TestingTimeResponse {
    private String time;
    private String zone;

    public TestingTimeResponse(String time, String zone) {
        this.time = time;
        this.zone = zone;
    }

    public TestingTimeResponse() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestingTimeResponse that = (TestingTimeResponse) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(zone, that.zone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, zone);
    }

    @Override
    public String toString() {
        return "TestingTimeResponse{" +
                "time='" + time + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}
