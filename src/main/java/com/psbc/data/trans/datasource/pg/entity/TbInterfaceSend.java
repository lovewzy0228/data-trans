package com.psbc.data.trans.datasource.pg.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_interface_send
 */
@TableName(value ="tb_interface_send")
@Data
public class TbInterfaceSend implements Serializable {
    /**
     * 表的英文名称
     */
    @TableId
    private String tableName;

    /**
     * 数据库类型：0：PG, 1：MongoDB; 2：Hive; 3: ES
     */
    private String databaseType;

    /**
     * 数据库登录URL
     */
    private String databaseUrl;

    /**
     * 数据库名称
     */
    private String databaseName;

    /**
     * 表的主键（多个字段逗号隔开）
     */
    private String tablePk;

    /**
     * 需要抽取下发的字段集合，字段间逗号隔开
     */
    private String tableFields;

    /**
     * 表的类型：S:状态表; L:流水表
     */
    private String tableType;

    /**
     * 接口抽取方式：A: 增量; I : 全量
     */
    private String interfaceType;

    /**
     * 该接口下发下游系统周期：D:日，M:月，Q:季，Y:年
     */
    private String sendCycle;

    /**
     * 接口数据的开始日期，例如：2018-07-30
     */
    private Date startDate;

    /**
     * 接口数据的结束日期：例如：2018-07-30
     */
    private Date endDate;

    /**
     * 定义表的日切时刻：例如 23:30
     */
    private String dailyCutTime;

    /**
     * 下发文件的文件头信息
     */
    private String fileHeader;

    /**
     * 页面行数（万行）
     */
    private Integer pageRowNum;

    /**
     * 压缩标志（0-无压缩；1-压缩）
     */
    private String compressFlag;

    /**
     * 是否生成verf文件（0-否；1-是）
     */
    private String verfFlag;

    /**
     * 是否生成check文件（0-否；1-是）
     */
    private String checkFlag;

    /**
     * 生成ckeck文件的sql语句
     */
    private String checkExpression;

    /**
     * 查询条件，生成数据文件的sql查询条件
     */
    private String queryCondition;

    /**
     * 通过统计表达式取得的结果值的信息
     */
    private BigDecimal statsValue;

    /**
     * 本系统11位系统平台号
     */
    private String localSysCode;

    /**
     * 下游接数系统11位系统平台号
     */
    private String remoteSysCode;

    /**
     * 有效标识（0-无效 1-有效）
     */
    private String validFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据库用户名
     */
    private String databaseUser;

    /**
     * 数据库密码
     */
    private String databasePwd;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}