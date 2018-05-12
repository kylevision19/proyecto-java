package Model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
    
    public DriverManagerDataSource conectar(){
        
        DriverManagerDataSource datasource=new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost/superman");
        datasource.setUsername("root");
        datasource.setPassword("");
        return datasource;
    }
    
}
