package com.zhangyu.server.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.*;

@Slf4j
public class JDKJsonRedisSerializer implements RedisSerializer {

    private static final byte[] EMPTY_BYTE = new byte[0];

    @Override
    public byte[] serialize(Object inputObject) throws SerializationException {

        if (inputObject == null) {
            return EMPTY_BYTE;
        }
        ObjectOutputStream input = null;
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            input = new ObjectOutputStream(outputStream);
            input.writeObject(inputObject);
            byte[] bytes = outputStream.toByteArray();
            return bytes;
        } catch (IOException ioException) {
            log.error(ioException.getMessage(), ioException);
        }
        //如果转换报错了
        return null;
    }

    //JDK IO方法
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        Object result = null;
        if (bytes != null && bytes.length > 1) {
            ObjectInputStream output = null;
            ByteArrayInputStream input = null;
            input = new ByteArrayInputStream(bytes);
            try {
                output = new ObjectInputStream(input);
                result = output.readObject();
            } catch (IOException | ClassNotFoundException ioException) {
                log.error(ioException.getMessage(), ioException);
            }
        }
        return result;
    }
}
