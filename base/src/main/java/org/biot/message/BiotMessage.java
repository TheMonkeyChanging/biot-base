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
 * 序列化方式：内部用java，转发至外部用json
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiotMessage<T extends BiotMessageBody> implements Serializable {
    private String msgId;
    private String timestamp;
    private BiotMessageType type;
    private T body;

    /**
     * 创建消息，生成随机ID，时间戳取当前时间
     *
     * @param type
     * @param content
     * @return
     */
    public static <T extends BiotMessageBody> BiotMessage of(BiotMessageType type, T content) {
        String messageId = UUID.randomUUID().toString();
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return new BiotMessage(messageId, current, type, content);
    }
}
