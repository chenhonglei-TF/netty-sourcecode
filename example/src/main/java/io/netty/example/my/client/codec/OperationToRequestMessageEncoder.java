package io.netty.example.my.client.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.example.my.common.Operation;
import io.netty.example.my.common.RequestMessage;
import io.netty.example.my.util.IdUtil;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class OperationToRequestMessageEncoder extends MessageToMessageEncoder <Operation> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Operation operation, List<Object> out) throws Exception {
          RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), operation);

          out.add(requestMessage);
     }
}
