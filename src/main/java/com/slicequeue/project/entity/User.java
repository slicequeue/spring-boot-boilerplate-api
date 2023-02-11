package com.slicequeue.project.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "user_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

  @Id
  @Comment("사용자 일련번호")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("사용자 이름")
  @Column(name = "name", nullable = false)
  private String name;

  @Comment("생년월일")
  @Column(name = "birth_date")
  private LocalDate birthDate;

  public static User of(String name, LocalDate birthDate) {
    return new User(null, name, birthDate);
  }

}
