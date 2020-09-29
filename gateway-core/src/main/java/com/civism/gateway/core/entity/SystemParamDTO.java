package com.civism.gateway.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : civism
 * @version 1.0
 * @date 2020/8/8 11:30
 */
@Data
public class SystemParamDTO implements Serializable {
    private static final long serialVersionUID = 8129705037673018553L;

    private String contentPath;

    private String url;

    private String method;


}
