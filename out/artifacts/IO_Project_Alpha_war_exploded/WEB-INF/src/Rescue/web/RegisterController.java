package Rescue.web;

import Rescue.model.DBConnection;
import Rescue.model.Utility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created by maciej on 12.04.17.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping(value = "/doRegister", method = RequestMethod.GET)
    public String viewNewForm(Model model) {
        Register register = new Register();
        System.out.println("New user");
        model.addAttribute("register", register);
        return "register";
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String postThis(Register register) throws Exception {
        int retCode = registerUser(register.getName(),register.getUsername(),register.getPassword(),register.getSurname(),register.getPesel());
        if(retCode == 0){
            System.out.println("register,true");
        }else if(retCode == 1){
            System.out.println("register, You are already registered");
        }else if(retCode == 2){
            System.out.println("register, Special Characters are not allowed in Username and Password");
        }else if(retCode == 3){
            System.out.println("register, Error occured");
        }
        return "index";
    }

    private int registerUser(String name, String uname, String pwd, String surname, String pesel){
        System.out.println("Inside checkCredentials");
        int result = 3;
        if(Utility.isNotNull(uname) && Utility.isNotNull(pwd)){
            try {
                if(DBConnection.insertUser(name, uname, pwd, surname, pesel)){
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
