package com.psbc.data.trans.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 17:08
 */
@Data
@Accessors(chain = true)
public class TestVo {

    private String name;

    private Integer age;

    private Date date;

    private LocalDate localDate;

    private LocalDateTime localDateTime;
}
