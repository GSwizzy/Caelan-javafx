package sample;

import java.util.Date;

public class TripReport {

    public String tripNo;
    public String truckNo;
    public String driverNo;
    public String coDriverNo;
    public Date dateDep;
    public Date dateRet;
    public String typeMerchandise;
    public String stateCode;
    public int mileageBefore;
    public int mileageAfter;
    public int gallonsPurchased;

    public TripReport(String tripNo, String truckNo, String driverNo, String coDriverNo, Date dateDep, Date dateRet, String typeMerchandise, String stateCode, int mileageBefore, int mileageAfter, int gallonsPurchased) {
        this.tripNo = tripNo;
        this.truckNo = truckNo;
        this.driverNo = driverNo;
        this.coDriverNo = coDriverNo;
        this.dateDep = dateDep;
        this.dateRet = dateRet;
        this.typeMerchandise = typeMerchandise;
        this.stateCode = stateCode;
        this.mileageBefore = mileageBefore;
        this.mileageAfter = mileageAfter;
        this.gallonsPurchased = gallonsPurchased;
    }

    public TripReport() {
    }


    public String getTruckNo() {
        return truckNo;
    }

    public String getDriverNo() {
        return driverNo;
    }

    public String getCoDriverNo() {
        return coDriverNo;
    }

    public String getTripNo() {
        return tripNo;
    }

    public Date getDateDep() {
        return dateDep;
    }

    public Date getDateRet() {
        return dateRet;
    }

    public String getTypeMerchandise() {
        return typeMerchandise;
    }

    public String getStateCode() {
        return stateCode;
    }

    public int getMileageBefore() {
        return mileageBefore;
    }

    public int getMileageAfter() {
        return mileageAfter;
    }

    public int getGallonsPurchased() {
        return gallonsPurchased;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public void setCoDriverNo(String coDriverNo) {
        this.coDriverNo = coDriverNo;
    }

    public void setTripNo(String tripNo) {
        this.tripNo = tripNo;
    }

    public void setDateDep(Date dateDep) {
        this.dateDep = dateDep;
    }

    public void setDateRet(Date dateRet) {
        this.dateRet = dateRet;
    }

    public void setTypeMerchandise(String typeMerchandise) {
        this.typeMerchandise = typeMerchandise;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setMileageBefore(int mileageBefore) {
        this.mileageBefore = mileageBefore;
    }

    public void setMileageAfter(int mileageAfter) {
        this.mileageAfter = mileageAfter;
    }

    public void setGallonsPurchased(int gallonsPurchased) {
        this.gallonsPurchased = gallonsPurchased;
    }
}
