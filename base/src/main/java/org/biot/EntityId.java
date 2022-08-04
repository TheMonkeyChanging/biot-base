package org.biot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * 实体ID
 *
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityId<T> implements Serializable {
    private String tenantId;
    private T uuid;

    /**
     * 生成16位uuid
     *
     * @return
     */
    public static String uuid16String() {
        String[] strings = UUID.randomUUID().toString().split("-");
        return strings[0] + strings[1] + strings[2];
    }

    /**
     * 生成24位uuid
     *
     * @return
     */
    public static String uuid24String() {
        String[] strings = UUID.randomUUID().toString().split("-");
        return strings[1] + strings[2] + strings[3] + strings[4];
    }

    /**
     * 生成32位随机字符串
     *
     * @return
     */
    public static String uuid32String() {
        String[] strings = UUID.randomUUID().toString().split("-");
        return strings[0] + strings[1] + strings[2] + strings[3] + strings[4];
    }
}
