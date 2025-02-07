package com.workintech.zoo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Exception durumunda return edeceğimiz response objesi
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZooErrorResponse {

    private Integer status;
    private String message;
    private long timestamp;

}
