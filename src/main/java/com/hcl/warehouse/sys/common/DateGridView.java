package com.hcl.warehouse.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :liangHuang.
 * @Date :2019/12/5 14:44
 * @Description : Json数据实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateGridView {
    /**
     * 编码
     */
    private Integer code = 0;
    /**
     * 消息
     */
    private String msg = "";
    /**
     * 计数
     */
    private Long count = 0L;
    /**
     * 数据
     */
    private Object data;

    public DateGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DateGridView(Object date) {
        this.data = date;
    }

}
