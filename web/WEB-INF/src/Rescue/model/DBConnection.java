package Rescue.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnection {
    private static Connection con;
    /**
     * Method to create DB Connection
     * 
     * @return
     * @throws Exception
     */
    private static Connection createConnection() throws Exception {
        try {
            Class.forName(Constants.dbClass);
            con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser, Constants.dbPwd);
        } catch (Exception e) {
            throw e;
        }
        return con;
    }
    public static boolean insertIncident(String message) throws Exception {
        boolean insertStatus = false;
        Connection dbConn = null;
        int resultSet = 0;
        try {
            try {
                dbConn = DBConnection.createConnection();
                if (dbConn == null)
                    System.out.println("nie łaczy");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (dbConn != null) {
                Statement stmt = dbConn.createStatement();
                String query = "INSERT into incident (type) values('" + message + "')";
                System.out.println(query);
                resultSet = stmt.executeUpdate(query);
                //System.out.println(records);
                //When record is successfully inserted
                if (resultSet > 0) {
                    insertStatus = true;
                }
            }
        } catch (SQLException sqle) {
            //sqle.printStackTrace();
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Auto-generated catch block
            if (dbConn != null) {
                dbConn.close();
            }
            throw e;
        } finally {
            if (dbConn != null) {
                dbConn.close();
            }
        }
        return insertStatus;
    }

    public static boolean insertUser(String name, String uname, String pwd, String surname, String pesel) throws SQLException, Exception {
        boolean insertStatus = false;
        Connection dbConn = null;
        try {
            try {
                dbConn = DBConnection.createConnection();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (dbConn != null) {
                Statement stmt = dbConn.createStatement();
                String query = "INSERT into user(name, username, password, pesel,surname) values('" + name + "'," + "'" + uname + "','" + pwd + "','" + pesel + "','" + surname+ "')";
                //System.out.println(query);
                int records = stmt.executeUpdate(query);
                //System.out.println(records);
                //When record is successfully inserted
                if (records > 0) {
                    insertStatus = true;
                }
            }
        } catch (SQLException sqle) {
            //sqle.printStackTrace();
            throw sqle;
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Auto-generated catch block
            if (dbConn != null) {
                dbConn.close();
            }
            throw e;
        } finally {
            if (dbConn != null) {
                dbConn.close();
            }
        }
        return insertStatus;
    }
}