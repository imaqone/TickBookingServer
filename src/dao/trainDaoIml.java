package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.*;
public class trainDaoIml implements trainDao{
    Connection connection=null;
    dbConn dbConn=new dbConn();
    @Override
    public void getDepartCity(){

    }
    @Override
    public String getArriveCity(){
        ResultSet resultSet=null;
        String sql="select ArriveCity from student";
        PreparedStatement preparedStatement=null;
        String city=null;
        try {
            connection=dbConn.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                city=resultSet.getString("ArriveCity");
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
        return city;
    }
    @Override
    public void getDepartTime(){

    }
    @Override
    public void getArriveTime(){

    }
}
