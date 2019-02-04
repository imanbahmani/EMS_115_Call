package call.ems.developers.shirazapp.ems_115_call;

import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 9/24/16 AD.
 */
public class DataORM extends SugarRecord {

    private int idcode;
    private String mobile;
    private String date;
    private boolean isSms;
    private boolean isInternet;
    private double latitude;
    private double longitude;


    public DataORM() {
    }
    public DataORM(int idcode, String mobile, String date, boolean isSms, boolean isInternet, double latitude, double longitude) {
        this.idcode                   = idcode;
        this.mobile                   = mobile;
        this.date                     = date;
        this.isSms                    = isSms;
        this.isInternet               = isInternet;
        this.latitude                 = latitude;
        this.longitude                = longitude;
    }
    //////////////////////
    public int   getIdcode() {
        return idcode;
    }
    public void  setIdcode(int idcode) {
        this.idcode = idcode;
    }
    //////////////////////
    public String getMobile() {
        return mobile;
    }
    public void   setMobile(String mobile) {
        this.mobile = mobile;
    }
    /////////////////////
    public String getDate() {
        return date;
    }
    public void   setDate(String date) {
        this.date = date;
    }
    /////////////////////
    public boolean getIsSms() {
        return isSms;
    }
    public void   setIsSms(boolean isSms) {
        this.isSms = isSms;
    }
    ////////////////////
    public boolean getIsInternet() {
        return isInternet;
    }
    public void   setIsInternet(boolean isInternet) {
        this.isInternet = isInternet;
    }
    /////////////////////
    public double getLatitude() {
        return latitude;
    }
    public void   setLatitude(double latitude) {
        this.latitude = latitude;
    }
    /////////////////////
    public double getLongitude() {
        return longitude;
    }
    public void   setLongitude(double longitude) {
        this.longitude = longitude;
    }
}


