package dao;

import java.util.ArrayList;
public interface trainDao {
    ArrayList<Ticket> getTicket(String departCity,String arriveCity,String departDate);
}
