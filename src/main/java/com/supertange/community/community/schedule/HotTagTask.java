package com.supertange.community.community.schedule;

import com.supertange.community.community.cache.HotTagCache;
import com.supertange.community.community.mapper.QuestionMapper;
import com.supertange.community.community.model.Question;
import com.supertange.community.community.model.QuestionExample;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: supertange
 * @Description:
 * @Date: Created in 15:08 2020/1/19
 */
@Slf4j
@Component
public class HotTagTask {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(fixedRate = 20000)
//    @Scheduled(cron = "0 0 1 * * *")
    public void hotTagSchedule() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.now();
        log.info("hot schedule start {}", dateTime.format(dateTimeFormatter));

        int offset = 0;
        int limit = 1;
        List<Question> list = new ArrayList<>();
        Map<String, Integer> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {
                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String tag : tags) {
                    Integer priority = priorities.get(tag);
                    if (priority != null) {
                        priorities.put(tag, priority + 5 + question.getCommentCount());
                    } else {
                        priorities.put(tag, 5 + question.getCommentCount());
                    }
                }
            }
            offset += limit;
        }
        priorities.forEach((k, v) -> {
            System.out.print(k + ":");
            System.out.print(v);
            System.out.println();
        });

        hotTagCache.updateTags(priorities);

        LocalDateTime endTime = LocalDateTime.now();
        log.info("hot schedule stop {}", endTime.format(dateTimeFormatter));

    }

}
