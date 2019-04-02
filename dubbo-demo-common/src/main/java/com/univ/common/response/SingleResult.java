package com.univ.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author univ
 * @date 2019/4/2 2:17 PM
 * @description 通用返回结构-单个元素
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class SingleResult<T> extends BaseResult {
    private T data;
}
