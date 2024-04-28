package com.ivoronline.springboot_database_jdbctemplate_delete_closure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.PreparedStatement;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // HELLO
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/hello")
  public int  hello() {
    int deleteRecords = delete("John", 10);
    return deleteRecords;
  }

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
