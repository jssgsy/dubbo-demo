package com.univ.service;

import javax.validation.constraints.Min;

import com.univ.dto.validation.ValidateDTO;

/**
 * @author univ
 * @date 2019/1/11 8:21 PM
 * @description
 */
public interface ValidateService {

    /**
     * 将限制加在对象类型上
     *
     * 注意，这里不用加@Valid注解(@Valid的作用是用来实际级联字段的验证的)，直接将限制加在ValidateDTO类中的字段中即可
     * @param validateDTO
     * @return
     */
    String getByValidateDTO(ValidateDTO validateDTO);

    /**
     * 可直接将限制加在基本类型上
     * @param id
     * @return
     */
    ValidateDTO getById(@Min(value = 10, message = "id值不能小于10") Long id);
}
