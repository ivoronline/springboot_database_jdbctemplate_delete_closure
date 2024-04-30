package com.ivoronline.springboot_database_jdbctemplate_delete_closure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // DELETE
  //=========================================================================================================
  public int delete(String name, Integer age) {

    return jdbcTemplate.update(connection -> {

      String            sql               = "DELETE FROM PERSON WHERE NAME = ? AND AGE = ?";

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, name);
                        preparedStatement.setLong  (2, age );

        return preparedStatement;

      }

    );

  }

}
