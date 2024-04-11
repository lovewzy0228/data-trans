package com.psbc.data.trans.common.convert;

import com.psbc.data.trans.dto.TestDto;
import com.psbc.data.trans.vo.TestVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author zhenyu.wu
 * @date 2024/4/11 17:11
 */
@Mapper(componentModel = SPRING)
@Component
public interface TestConvert {

    TestVo dto2Vo(TestDto dto);
}
