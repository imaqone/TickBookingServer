package dao;

public class userMessage {
    public userMessage(String UserId,String Name,String Account,String Password,String Phone,String IdCard){
        this.Account=Account;
        this.UserId=UserId;
        this.IdCard=IdCard;
        this.Name=Name;
        this.Password=Password;
        this.Phone=Phone;
    }
    public String UserId;
    public String Name;
    public String Account;
    public String Password;
    public String Phone;
    public String IdCard;
}
