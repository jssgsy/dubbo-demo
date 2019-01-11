package com.univ.service.impl;

import com.univ.dto.validation.ValidateDTO;
import com.univ.service.ValidateService;

/**
 * @author univ
 * @date 2019/1/11 8:23 PM
 * @description
 */
public class ValidateServiceImpl implements ValidateService{

    public String getByValidateDTO(ValidateDTO validateDTO) {
        return "验证通过";
    }

    /**
     * 注意，实现的方法上不用再加@Min(10)，ValidateService已加
     * 即使在这里加上@Min(30)限制也不会起作用，这是可理解的，因为远程消费者是通过接口(而不是这里的实现者)来调用的，何况实现者还可能不止一个，如果这里起作用的话，则当不同实现者有不同限制时，则使用哪个限制呢，所以这里不起作用
     *
     * 小结：限制必须加在接口(ValidateService)上，实现类上不用添加，即使添加也会被忽略
     * @param id
     * @return
     */
    public ValidateDTO getById(Long id) {
        ValidateDTO validateDTO = new ValidateDTO();
        validateDTO.setId(id);
        return validateDTO;
    }
}
