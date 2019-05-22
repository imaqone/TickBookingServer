package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.*;
public class trainDaoIml implements trainDao{
    Connection connection=null;
    dbConn dbConn=new dbConn();
    @Override
    public ArrayList<Ticket> getTicket(String departCity,String arriveCity,String departDate){
        ResultSet resultSet=null;
        String sql="SELECT * FROM testconn.student\n" +
                "where date_format(DepartDate,'%Y%m%d')='"+departDate+"'\n" +
                "and ArriveCity='"+arriveCity+"'\n" +
                "and DepartCity='"+departCity+"'";
        PreparedStatement preparedStatement=null;
        ArrayList<Ticket>ticketList=new ArrayList<>();
        try {
            connection=dbConn.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String Arrive=resultSet.getString("ArriveCity");
                String Depart=resultSet.getString("DepartCity");
                String Date=resultSet.getString("DepartDate");
                Ticket ticket=new Ticket(Depart,Arrive,Date);
//                ticket.setArriveCity(ArriveCity);
//                ticket.setDepartCity(departCity);
//                ticket.setDepartDate(date);
//                ticket.ArriveCity=ArriveCity;
//                ticket.DepartCity=departCity;
//                ticket.DepartDate=date;
                ticketList.add(ticket);
//                System.out.println(ArriveCity);
//                System.out.println(departCity);
//                System.out.println(date);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (dbConn != null) {
                dbConn.closeDBResource(connection, preparedStatement, resultSet);
            }
        }catch(SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ticketList;
    }
}
