package com.example.comebackshack.ui.login;

        import android.util.Log;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class Connect {
    private static final String HOST = "jdbc:mysql://localhost:3306/comebackshackapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public Connect() {
        try {
            Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e){
            Log.d("Connect", "Connection Failed", e);
        }
    }
}
