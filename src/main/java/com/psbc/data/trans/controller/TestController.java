package com.psbc.data.trans.controller;

import com.psbc.data.trans.common.convert.TestConvert;
import com.psbc.data.trans.configuration.web.Result;
import com.psbc.data.trans.dto.TestDto;
import com.psbc.data.trans.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 17:05
 */
@RestController
@RequestMapping("/v1")
public class TestController {

    @Autowired
    private TestConvert testConvert;

    @GetMapping("/test")
    public Result<TestVo> testGet(TestDto testDto) {
        return Result.success(testConvert.dto2Vo(testDto));
    }
}
