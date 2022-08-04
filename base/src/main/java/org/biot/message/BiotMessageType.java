package org.biot.message;

import lombok.Getter;

/**
 * Biot MQ消息类型
 */
public enum BiotMessageType {
    PRODUCT_CREATE("产品创建"),
    PRODUCT_ENABLE("产品启用"),
    PRODUCT_DISABLE("产品停用"),
    PRODUCT_DELETE("产品删除"),
    DEVICE_CREATE("设备创建"),
    DEVICE_ENABLE("设备启用"),
    DEVICE_DISABLE("设备停用"),
    DEVICE_DELETE("设备删除"),
    DEVICE_ONLINE("设备上线"),
    DEVICE_OFFLINE("设备下线"),
    DEVICE_PROPERTY("设备属性值更新"),
    DEVICE_EVENT("设备事件"),
    ;
    @Getter
    private final String desc;

    private BiotMessageType(String desc) {
        this.desc = desc;
    }
}
