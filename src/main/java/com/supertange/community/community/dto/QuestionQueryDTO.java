package com.supertange.community.community.dto;

import lombok.Data;

/**
 * @Author: supertange
 * @Description:
 * @Date: Created in 13:59 2020/1/18
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
