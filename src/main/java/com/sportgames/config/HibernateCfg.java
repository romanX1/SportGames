package com.sportgames.config;

import com.sportgames.model.Playground;
import com.sportgames.model.SportEvent;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//@org.springframework.context.annotation.Configuration
public class HibernateCfg {
    public final SessionFactory sessionFactory;

    private HibernateCfg(){
        Configuration cfg=postgresCfg();
        sessionFactory=createSessionFactory(cfg);
    }

    private Configuration postgresCfg(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Playground.class);
        configuration.addAnnotatedClass(SportEvent.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/SportGames"); //5432
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return configuration;

    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
