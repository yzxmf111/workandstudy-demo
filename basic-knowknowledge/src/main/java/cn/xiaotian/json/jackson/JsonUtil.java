package cn.xiaotian.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class JsonUtil {
    private static final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
        .modules(new JavaTimeModule()).build();

    public static String serialize(Object obj) {
        String result = StringUtils.EMPTY;
        if (Objects.isNull(obj)) {
            return result;
        }
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("数据序列化错误" + e.getMessage());
        }
        return result;
    }

    public static <T> T deserialize(String content, Class<T> clazz) {
        T result = null;

        try {
            result = objectMapper.readValue(content, clazz);
        } catch (IOException e) {
            log.error("数据反序列化错误" + e.getMessage());
        }

        return result;
    }

    public static <T> List<T> deserializeList(String content, Class<T> clazz) {
        List<T> resultList = new ArrayList<>();
        if (StringUtils.isBlank(content)) {
            return resultList;
        }
        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            resultList = objectMapper.readValue(content, type);
        } catch (IOException e) {
            log.error("数据反序列化错误: " + e.getMessage());
        }
        return resultList;
    }


    public static <T> T fromJsonWithEx(String json, Class<T> classOfT) throws IOException {
        return objectMapper.readValue(json, classOfT);
    }
}
