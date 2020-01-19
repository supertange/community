package com.supertange.community.community.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @Author: supertange
 * @Description:
 * @Date: Created in 17:13 2020/1/19
 */
@Data
public class HotTagDTO implements Comparable {
    private String name;

    private Integer priority;


    @Override
    public int compareTo(@NotNull Object o) {
        return this.getPriority()-((HotTagDTO)o).getPriority();
    }
}
