/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tracking.vision.paulo;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author PAULOROBERTODEALMEID
 */
public class ConexaoMysql {
    private JdbcTemplate connection;

    public ConexaoMysql() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

//        dataSource.setUrl("jdbc:mysql://172.17.0.2:3306/track?autoReconnect=true&useSSL=false");
            dataSource.setUrl("jdbc:mysql://localhost:3306/track");

        dataSource.setUsername("root");

        dataSource.setPassword("paulo1421");

//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/track");
//        dataSource.setUsername("root");
//        dataSource.setPassword("paulo1421");

        this.connection = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
}
