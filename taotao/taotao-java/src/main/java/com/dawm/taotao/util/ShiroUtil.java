package com.dawm.taotao.util;


import com.dawm.taotao.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {
    public static AccountProfile getProfile(){
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}
