import GUIS.LoginFormGUI;
import GUIS.RegisterFormGUI;
import db.MyJDBC;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //instantiate a LoginFormGUI obj and make it visible
//                new LoginFormGUI().setVisible(true);

                //check user test
//                System.out.println(MyJDBC.checkUser("username1"));

                //check register test
//                System.out.println(MyJDBC.register("username1", "123"));

                //check validate Login
                System.out.println(MyJDBC.validateLogin("username1", "123"));
            }
        });
    }
}
