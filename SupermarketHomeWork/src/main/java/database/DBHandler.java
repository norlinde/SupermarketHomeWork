package database;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {



    PropertiesConfiguration databaseProperties = new PropertiesConfiguration();

    private Connection connection;

    public DBHandler(){
        try {
            databaseProperties.load("database.properties");
        } catch (ConfigurationException e) {
            System.out.println("TODO List is unable to connect to data storage system");
            e.printStackTrace();
        }

        String password = databaseProperties.getString("database.password");
        String user = databaseProperties.getString("database.user");
        String host = databaseProperties.getString("database.host");
        String port = databaseProperties.getString("database.port");
        String dbName = databaseProperties.getString("database.name");
        String connectionUrl = host + ":" + port + "/" + dbName ;

        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
        }catch (SQLException ex){
            System.out.println("Unable to connect to database");
            ex.printStackTrace();
        }


    }
    public Connection getConnection(){
        return connection;
    }

}


