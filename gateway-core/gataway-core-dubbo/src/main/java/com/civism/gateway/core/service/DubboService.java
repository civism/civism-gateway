package com.civism.gateway.core.service;

import com.civism.gateway.core.annotation.RpcController;
import com.civism.gateway.core.annotation.UrlPatch;
import com.civism.gateway.core.entity.SystemParamDTO;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/10 14:53
 * @E-mail:695234456@qq.com
 * @return
 */
@RpcController("home")
public interface DubboService {

    /**
     * 回调
     *
     * @param systemParamDTO
     * @return
     */
    @UrlPatch(url = {"/index", "/hello"})
    Object callBack(SystemParamDTO systemParamDTO);

    /**
     * 回调
     */
    @UrlPatch(url = "/call")
    void callBack();
}
