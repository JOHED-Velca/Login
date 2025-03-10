package db;

import constants.CommonConstants;

import java.sql.*;

public class MyJDBC {
    //register new user to the DB
    //true = success
    //false = failure
    public static boolean register(String username, String password) {
        //check if username already exists
        try {
            if (!checkUser(username)) {
                //connect to the database
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL, CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

                //create insert query
                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO " + CommonConstants.DB_USERS_TABLE_NAME
                                + "(username, password)" + "VALUES(?, ?)");

                //insert parameters in the insert query
                insertUser.setString(1, username);
                insertUser.setString(2, password);

                //update DB with new user
                insertUser.executeUpdate();
                return true;

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //if username already exists
    //false = user doesn't exists
    //true = user exists
    public static boolean checkUser(String username) {
        try {
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME +
                            " WHERE USERNAME = ?"
            );
            checkUserExists.setString(1, username);

            ResultSet resultSet = checkUserExists.executeQuery();

            //check to see if the result set is empty
            //if it is, then there wasn't data row that contains the username
            //(i.e. user doesn't exist)
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    //validate login credentials by checking to see if username/password pair exists in the DB
    public static boolean validateLogin(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

            //create select query
            PreparedStatement validateUser = connection.prepareStatement("SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME +
                    " WHERE USERNAME = ? AND PASSWORD = ?");
            validateUser.setString(1, username);
            validateUser.setString(2, password);

            ResultSet resultSet = validateUser.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                return false;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
