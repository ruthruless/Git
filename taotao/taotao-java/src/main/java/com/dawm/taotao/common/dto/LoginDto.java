package com.dawm.taotao.common.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginDto implements Serializable {
    /**
     * 添加用户验证如若账号或者密码为空则会抛出异常
     */
    @NotBlank(message = "昵称不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private  String password;

}
