package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
   private @Getter @Setter Integer id;
   private @Getter @Setter String name;
   private @Getter @Setter String company;
   private @Getter @Setter String emailId;
}