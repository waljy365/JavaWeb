package com.example.domain;

import lombok.*;

/**
 * @author : 王希辰
 * @date : 2023/3/24 9:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {
    private String province;
    private String city;

}
