package dao;

public class Ticket {
    public Ticket(String DepartStation,String ArriveStation,String DepartTime,String ArriveTime,String TrainNum){
        this.DepartStation=DepartStation;
        this.ArriveStation=ArriveStation;
        this.DepartTime=DepartTime;
        this.ArriveTime=ArriveTime;
        this.TrainNum=TrainNum;
    }
    public String DepartStation;
    public String ArriveStation;
    public String DepartTime;
    public String ArriveTime;
    public String TrainNum;
//
//    public String getDepartCity() {
//        return DepartCity;
//    }
//
//    public String getArriveCity() {
//        return ArriveCity;
//    }
//
//    public void setDepartCity(String departCity) {
//        DepartCity = departCity;
//    }
//
//    public void setArriveCity(String arriveCity) {
//        ArriveCity = arriveCity;
//    }
//
//    public String getDepartDate() {
//        return DepartDate;
//    }
//
//    public void setDepartDate(String departDate) {
//        DepartDate = departDate;
//    }
}
