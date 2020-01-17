package com.supertange.community.community.dto;

import com.supertange.community.community.model.User;
import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private String notifierName;
    private String notifier;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
