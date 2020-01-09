package com.supertange.community.community.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private String avatarUrl;
    private Long gmtCreate;
    private Long gmtModified;
}
