package dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import util.dbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.sqlExc;
public class orderDaoIml implements orderDao{
    Connection connection=null;
    dbConn dbConn=new dbConn();
    @Override
    public ArrayList<Order> getOrder(String account) {
        ResultSet resultSet=null;
        String sql="SELECT pname,departDate,departTime,arrivetime,departStation,arrivestation,trainNum \n" +
                "FROM testconn.`order`\n" +
                "where account='"+account+"' ;";
        PreparedStatement preparedStatement=null;
        ArrayList<Order>orderList=new ArrayList<>();
        try {
            connection=dbConn.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String name=resultSet.getString("pname");
                String DepartDate=resultSet.getString("departDate");
                String DepartTime=resultSet.getString("departTime");
                String ArriveTime=resultSet.getString("arrivetime");
                String DepartStation=resultSet.getString("departStation");
                String ArriveStation=resultSet.getString("arrivestation");
                String TrainNum=resultSet.getString("trainNum");
                Order order=new Order(name,DepartDate,DepartTime,ArriveTime,DepartStation,ArriveStation,TrainNum);
                orderList.add(order);

            }
            if (dbConn != null) {
                dbConn.closeDBResource(connection, preparedStatement, resultSet);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public void setOrder(String[]mess) {
        sqlExc sqlExc=new sqlExc();
        ResultSet resultSet = null;
        String sql="INSERT INTO `testconn`.`order` (`account`, `pname`, `ppesonId`, `pphone`, `departStation`, `arrivestation`, `departTime`, `arrivetime`, `trainNum`, `departDate`) VALUES ('"+mess[0]+"', '"+mess[1]+"', '"+mess[2]+"', '"+mess[3]+"', '"+mess[4]+"', '"+mess[5]+"', '"+mess[6]+"', '"+mess[7]+"', '"+mess[8]+"', '"+mess[9]+"');";

        sqlExc.insertExc(sql);
//        ["123","anqi","12345","1234","深圳","北京","8:22","8:30","g250"]
    }
}
