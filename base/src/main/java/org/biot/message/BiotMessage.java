package org.biot.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * BIoT MQ消息格式
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiotMessage implements Serializable {
    private String msgId;
    private String timestamp;
    private BiotMessageType type;
    private BiotMessageBody body; // todo 解决序列化的问题
    //private Serializable body;

    /**
     * 创建消息，生成随机ID，时间戳取当前时间
     *
     * @param type
     * @param content
     * @return
     */
    public static BiotMessage of(BiotMessageType type, BiotMessageBody content) {
        String messageId = UUID.randomUUID().toString();
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return new BiotMessage(messageId, current, type, content);
    }
}
