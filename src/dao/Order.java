package dao;

public class Order {
    public Order(String name,String DepartDate,String DepartTime,String ArriveTime,String DepartStation,String ArriveStation,String trainNum){
        this.name=name;
        this.DepartDate=DepartDate;
        this.DepartTime=DepartTime;
        this.ArriveTime=ArriveTime;
        this.DepartStation=DepartStation;
        this.ArriveStation=ArriveStation;
        this.trainNum=trainNum;

    }
    public String name;
    public String DepartDate;
    public String DepartTime;
    public String ArriveTime;
    public String DepartStation;
    public String ArriveStation;
    public String trainNum;
}
