package com.psbc.data.trans.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 17:08
 */
@Data
@Accessors(chain = true)
public class TestVo {

    private String name;

    private Integer age;
}
