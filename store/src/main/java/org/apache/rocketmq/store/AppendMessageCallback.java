/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.store;

import java.nio.ByteBuffer;
import org.apache.rocketmq.common.message.MessageExtBatch;
import org.apache.rocketmq.store.CommitLog.PutMessageContext;

/**
 * Write messages callback interface
 */
public interface AppendMessageCallback {

    /**
     * After message serialization, write MapedByteBuffer
     * @param fileFromOffset 文件起始偏移量（不管该处是否写入数据）
     * @param byteBuffer 要写入的ByteBuffer对象
     * @param maxBlank 文件剩余空间
     * @param msg 要写入的消息对象
     * @param putMessageContext 写入消息对象的上下文
     * @return How many bytes to write
     */
    AppendMessageResult doAppend(final long fileFromOffset, final ByteBuffer byteBuffer,
        final int maxBlank, final MessageExtBrokerInner msg, PutMessageContext putMessageContext);

    /**
     * After batched message serialization, write MapedByteBuffer
     *
     * @param messageExtBatch, backed up by a byte array
     * @return How many bytes to write
     */
    AppendMessageResult doAppend(final long fileFromOffset, final ByteBuffer byteBuffer,
        final int maxBlank, final MessageExtBatch messageExtBatch, PutMessageContext putMessageContext);
}
