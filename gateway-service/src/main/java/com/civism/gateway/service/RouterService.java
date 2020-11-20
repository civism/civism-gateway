package com.civism.gateway.service;

import com.civism.gateway.common.SystemParamDTO;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/11/20 11:01
 * @E-mail:695234456@qq.com
 * @return
 */
public interface RouterService {

    Object route(SystemParamDTO systemParam);
}
