package com.psbc.data_trans.mapper;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.psbc.data.trans.datasource.pg.mapper.TbInterfaceSendMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

@MybatisPlusTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(DynamicDataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.psbc.data.trans.datasource"})
public class PrimaryDatasourceMapperTest {

    @Autowired
    private TbInterfaceSendMapper tbInterfaceSendMapper;

    @Test
    public void testSelectInterfaceSend() {
        System.out.println(tbInterfaceSendMapper.selectList(null));
    }

}
