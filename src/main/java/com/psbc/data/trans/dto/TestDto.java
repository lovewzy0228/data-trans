package com.psbc.data.trans.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 17:07
 */
@Data
@Accessors(chain = true)
public class TestDto {

    private String name;

    private Integer age;
}
