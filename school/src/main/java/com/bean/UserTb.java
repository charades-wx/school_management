package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTb {
    private Integer userId;

    private Integer studentId;

    private Integer roleId;

    private Role role;

    private String userName;

    private String userPs;

    private String userRealname;

    private String userSex;

    private String userEmail;

    private String userPhone;

    private String userAddress;

    private String userIdcard;

    private String userContent;

    private Integer logincount;

    private Date regdate;

    private int managerid;

    private UserTb manger;

    
}