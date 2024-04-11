package com.psbc.data.trans.datasource.pg.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tb_interface_send_dtl
 */
@TableName(value ="tb_interface_send_dtl")
@Data
public class TbInterfaceSendDtl implements Serializable {
    /**
     * 接口名称，同下发家口信息表中的表名
     */
    private String interfaceName;

    /**
     * 数据发送日期，格式：YYYYMMDD，一般同下发接口信息表中结束日期
     */
    private String dataDate;

    /**
     * 发送文件的所在全路径
     */
    private String filePath;

    /**
     * 发送文件的名称
     */
    private String fileName;

    /**
     * 文件个数
     */
    private Integer fileNum;

    /**
     * 文件生成后，记录开始时间
     */
    private String startTime;

    /**
     * 文件完成上传后记录结束时间
     */
    private String endTime;

    /**
     * 发送标志 0-未发送；1-正在发送；2-已发送；3-发送失败；4-无需发送
     */
    private String sendFlag;

    /**
     * 发送次数，默认0，发送一次值+1，超过3次放弃发送
     */
    private Integer sendTimes;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}