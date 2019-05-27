package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.*;

@WebServlet("/HelloForm")
public class servletTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public servletTest() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        trainDaoIml t = new trainDaoIml();
        PrintWriter out = response.getWriter();
        String title = "测试";
        String docType = "<!DOCTYPE html> \n";
        StringBuffer json = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        String city = json.toString();
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                city + "\n" +
                "</body></html>");
    }

    // 处理 POST 方法请求的方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        StringBuffer json = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        Gson gson = new Gson();
        System.out.println(json.toString());
//        JsonObj jsonObj = gson.fromJson(json.toString(), JsonObj.class);
//        System.out.println(jsonObj.city);
//        requestTicket requestTicket=gson.fromJson(json.toString(), requestTicket.class);
        request requestM=gson.fromJson(json.toString(),request.class);
//        System.out.println(requestM.messageType);
//        System.out.println(requestM.message);
        if(requestM.messageType.equals("ticket")){

            String departCity=requestM.message[0];
            String arriveCity=requestM.message[1];
            String date=requestM.message[2];

            trainDaoIml t = new trainDaoIml();
            ArrayList<Ticket> tickets;
            tickets = t.getTicket(departCity,arriveCity,date);
            String ResponseData = gson.toJson(tickets);
            PrintWriter out=response.getWriter();
            out.write(ResponseData);
            out.flush();
            out.close();
        }else if(requestM.messageType.equals("register")){
            String UserId=requestM.message[0];
            String Name=requestM.message[1];
            String Account=requestM.message[2];
            String Password=requestM.message[3];
            String Phone=requestM.message[4];
            String IdCard=requestM.message[5];
            userMessage um=new userMessage(UserId,Name,Account,Password,Phone,IdCard);
            userRegisterIml userRegisterIml=new userRegisterIml();
            userRegisterIml.register(um);
            PrintWriter out=response.getWriter();
            out.write("success");
            out.flush();
            out.close();
//            ["3","anqi","123","123","123","123"]
        }else if(requestM.messageType.equals("login")){
            String UserName=requestM.message[0];
            String Password=requestM.message[1];
            loginDaoIml loginDaoIml=new loginDaoIml();
            boolean successOrNot=loginDaoIml.login(UserName,Password);
            String ResponseData;
            if(successOrNot){
                ResponseData ="success";
            }else{
                ResponseData="fail";
            }
            PrintWriter out=response.getWriter();
            out.write(ResponseData);
            out.flush();
            out.close();
        }
//        String departCity=requestTicket.ticket[0];
//        String arriveCity=requestTicket.ticket[1];
//        String date=requestTicket.ticket[2];
//        trainDaoIml t = new trainDaoIml();
//        ArrayList<Ticket> tickets;
//        tickets = t.getTicket(departCity,arriveCity,date);
//        String ResponseData = gson.toJson(tickets);
//        PrintWriter out=response.getWriter();
//        out.write(ResponseData);
//        out.flush();
//        out.close();
    }

//    class JsonObj {
//        public String city;
//    }
    class requestTicket{
        public String[]ticket;
    }
    class request{
        public String messageType;
        public String[]message;
    }
}