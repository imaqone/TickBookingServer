package dao;

import util.dbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userRegisterIml implements userRegister {
    Connection connection = null;
    util.dbConn dbConn = new dbConn();

    @Override
    public void register(userMessage userMessage) {
        ResultSet resultSet = null;
//        String sql = "INSERT INTO `db_pro`.`user` (`Userid`, `name`, `account`, `password`, `phone`, `idcard`) VALUES ('" + userMessage.UserId + "', '" + userMessage.Name + "', '" + userMessage.Account + "', '"+userMessage.Password+"', '"+userMessage.Phone+"', '"+userMessage.IdCard+"');";
        String sql="INSERT INTO `testconn`.`user` (`Userid`, `name`, `account`, `password`, `phone`, `idcard`) VALUES ('3', 'anqi', '12345678', '12345678', '12345678', '12345678');";
        PreparedStatement preparedStatement = null;
        try {
            connection=dbConn.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            /*
            insert 语句用execute而不是executeQuery
             */
            preparedStatement.execute();
            if (dbConn != null) {
                dbConn.closeDBResource(connection, preparedStatement, resultSet);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
