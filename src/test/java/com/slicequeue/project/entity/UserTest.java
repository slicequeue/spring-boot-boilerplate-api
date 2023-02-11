package com.slicequeue.project.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;


@DataJpaTest
@AutoConfigurationPackage
@ContextConfiguration(classes = {User.class})
@DisplayName("User 테스트")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class UserTest {

  @Autowired
  TestEntityManager testEntityManager;

  @Test
  @DisplayName("1. 삽입 테스트 - 케이스1")
  void test1_insertTest_case1() {
    // given
    User user = User.of("slicequeue",
        LocalDate.parse("1990-02-12", DateTimeFormatter.ISO_DATE));
    // when
    User result = testEntityManager.persistAndFlush(user);
    // then
    Assertions.assertThat(result).isNotNull();
    Assertions.assertThat(result.getId()).isNotNull();
    Assertions.assertThat(result.getName()).isEqualTo(user.getName());
    Assertions.assertThat(result.getBirthDate()).isEqualTo(user.getBirthDate());
  }

}
