package com.dongdong.config;

import lombok.Getter;

/**
 * @author zhaodexu
 */

@Getter
public enum DynamicDateSourceEnum {
    /**
     * 主库
     */
    MASTER("masterDb"),
    /**
     * 从库
     */
    SLAVE("slaveDb");

    private String dateSourceName;

    DynamicDateSourceEnum(String dateSourceName) {
        this.dateSourceName = dateSourceName;
    }

}
