package com.ihchoco.glog.util.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RecordConvertUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convert(Object source, Class<T> targetClass) {
        if (source == null) return null;
        return objectMapper.convertValue(source, targetClass);
    }
}
