package dao;

import java.util.ArrayList;

public interface orderDao {
    ArrayList<Order> getOrder(String account);
    void setOrder(String[]mess);
}
