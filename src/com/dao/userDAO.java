package com.dao;

import com.Entity.userEntity;
import com.until.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {

    public static userEntity getUserByUsername(String name) {
        String sql="select * from tb_user where name='"+ name +"'";
        ResultSet rs=JdbcHelper.getResultSet(sql);

        try {
            while (rs.next()) {
                userEntity model =  new userEntity();
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                model.setPassword(rs.getString("password"));
                model.setAddress(rs.getString("address"));
                return model;
            }
        } catch (SQLException e)  {
            e.printStackTrace();
        }

        return null;
    }

}
