package dao;

import util.dbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDaoIml implements loginDao{
    Connection connection = null;
    util.dbConn dbConn = new dbConn();
    String returnPassword=null;
    @Override
    public boolean login(String UserName,String Password){
        ResultSet resultSet=null;
        String sql="select password from user where account='"+UserName+"';";
        PreparedStatement preparedStatement = null;
        try {
            connection=dbConn.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                returnPassword=resultSet.getString("password");
            }
            if (dbConn != null) {
                dbConn.closeDBResource(connection, preparedStatement, resultSet);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(returnPassword==null){
            return false;
        }
        if(returnPassword.equals(Password)){
            return true;
        }else{
            return false;
        }
    }
}
