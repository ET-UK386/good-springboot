package com.zb.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 1541
 * 统一返回结果集对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result {

    /** 消息*/
    private String message;

    /** 数据*/
    private Object data;

    /** 返回前端 代码
     * 200 成功
     * 500 代码报错
     * 404 找不到索要数据
     * */
    private Integer code;

    public Result(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
