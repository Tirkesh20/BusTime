package com.tirkesh.service.services;

import com.tirkesh.service.timeConverter.TimeConverter;

import java.util.Objects;

public class Service {
    private String CompanyName;
    private long departureTime;
    private long arriveTime;

    public Service() {

    }

    public Service(String companyName, long departureTime, long arriveTime) {
        CompanyName = companyName;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public long getArriveTime() {
        return arriveTime;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public void setArriveTime(long arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return departureTime == service.departureTime && arriveTime == service.arriveTime && Objects.equals(CompanyName, service.CompanyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CompanyName, departureTime, arriveTime);
    }


    public String toXml(){
        return "<" + CompanyName.toLowerCase() + "_Service>" +
                CompanyName + " " +
                TimeConverter.milliToLocal(departureTime).toString() + " " +
                TimeConverter.milliToLocal(arriveTime).toString() +
                "<" + CompanyName.toLowerCase() + "_Service>\n";
    }

    @Override
    public String toString() {
        return "Service{" +
                "CompanyName='" + CompanyName + '\'' +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                "}\n";
    }
}
