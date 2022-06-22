package org.biot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityId<T> implements Serializable {
    // todo 加入tenantId的优劣？
    private String tenantId;
    private T uuid;
}
