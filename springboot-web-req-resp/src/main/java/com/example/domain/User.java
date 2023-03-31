package com.example.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @author : 王希辰
 * @date : 2023/3/20 19:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements Serializable {
    private String name;
    private int age;
    private Address address;
}
