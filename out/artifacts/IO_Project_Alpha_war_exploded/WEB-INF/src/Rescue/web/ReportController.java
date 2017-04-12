package Rescue.web;

import Rescue.model.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("/app")
public class ReportController {

    //@Autowired
    //private DataSource dataSource;
    /*
    @RequestMapping("/model")
    public String przykladModelu(Model model) {
        model.addAttribute("address", "To jest jakaś super informacja");
        return "contact";
    }*/

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String viewNewForm(Model model) {
        Report message = new Report();
        System.out.println("New user");
        model.addAttribute("user", message);
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String postThis(Report message) throws Exception {
        System.out.println("Send from user: ");
        int retCode = insertIncident(message.getMessage());
        if(retCode == 0){
           System.out.println("send incident: true");
        }else if(retCode == 1){
            System.out.println("incident already exist");
        }else if(retCode == 2){
            System.out.println("Special Characters are not allowed");
        }else if(retCode == 3){
            System.out.println("server connection: Error occured");
        }
        System.out.println(message.getMessage());
        return "index";
    }


    private int insertIncident(String message){
        System.out.println("Inside checkCredentials");
        int result = 3;
        if(!message.isEmpty()){
            try {
                if(DBConnection.insertIncident(message)){
                    System.out.println("RegisterUSer if");
                    result = 0;
                }
            } catch(SQLException sqle){
                System.out.println("RegisterUSer catch sqle");
                //When Primary key violation occurs that means user is already registered
                if(sqle.getErrorCode() == 1062){
                    result = 1;
                }
                //When special characters are used in name,username or password
                else if(sqle.getErrorCode() == 1064){
                    System.out.println(sqle.getErrorCode());
                    result = 2;
                }
            }
            catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("Inside checkCredentials catch e ");
                result = 3;
            }
        }else{
            System.out.println("Inside checkCredentials else");
            result = 3;
        }

        return result;
    }

}
