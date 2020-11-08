package io.netty.example.my.common.keepalive;

import io.netty.example.my.common.OperationResult;
import lombok.Data;

@Data
public class KeepaliveOperationResult extends OperationResult {

    private final long time;

}
