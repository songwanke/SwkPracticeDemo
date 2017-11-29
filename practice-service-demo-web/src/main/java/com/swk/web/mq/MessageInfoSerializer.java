package com.swk.web.mq;

import com.jd.ecc.commons.web.model.MessageInfo;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @author songwanke
 * @date 2017/11/28
 */
public class MessageInfoSerializer implements Serializer<MessageInfo> {

    Logger logger = LoggerFactory.getLogger(MessageInfoSerializer.class);

    /**
     * Configure this class.
     *
     * @param configs configs in key/value pairs
     * @param isKey   whether is for key or value
     */
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    /**
     * 把 messageInfo 对象序列化成 byte[]
     *
     * @param topic       主题
     * @param messageInfo 序列化messageInfo对象
     * @return byte[]
     */
    @Override
    public byte[] serialize(String topic, MessageInfo messageInfo) {
        try {
            if (messageInfo == null) {
                return null;
            } else {
                return objectToByte(messageInfo);
            }
        } catch (Exception e) {
            throw new SerializationException("Error when serializing string to byte[] due to unsupported MessageInfo ", e);
        }
    }

    /**
     * Close this serializer
     */
    @Override
    public void close() {

    }

    /**
     * messageInfo对象转换为 byte[]
     *
     * @param messageInfo
     * @return byte[]
     */
    private byte[] objectToByte(MessageInfo messageInfo) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(messageInfo);
            bytes = bo.toByteArray();
            bo.close();
            oo.close();
        } catch (Exception e) {
            logger.error("error MessageInfo conversion byte[] fail", e);
        }
        return bytes;
    }

}
