package DAO;

import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DataSourceSingleton {

    private static DataSourceSingleton instance;
    private static DataSource dataSource;

    private DataSourceSingleton() {
        if (dataSource == null) {
            try(InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties")) {
                Properties prop = new Properties();
                prop.load(input);
                JdbcDataSource ds = new JdbcDataSource();
                ds.setURL(prop.getProperty("url"));
                ds.setUser(prop.getProperty("username"));
                ds.setPassword(prop.getProperty("password"));
                dataSource = ds;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static DataSourceSingleton getInstance() {
        if (instance == null) {
            instance = new DataSourceSingleton();
        }
        return instance;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }



}
