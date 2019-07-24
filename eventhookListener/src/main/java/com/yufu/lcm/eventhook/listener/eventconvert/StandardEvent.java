package com.yufu.lcm.eventhook.listener.eventconvert;

import lombok.Data;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by XPD on 2019-03-20
 */
@Data(staticConstructor = "newInstance")
@Accessors(chain = true)
public class StandardEvent {

    public static final String EVENT_LOGGER_NAME = "com.yufu.idaas.kernel.logging.impl.EventLogger";

    private String id;
    private String tenantId;
    private String eventType;
    private String objectType;
    private boolean success = true;
    private Map<String, String> keywords;
    private Object content;
    private Map<String, String> client;

    public static Logger eventLogger() {
        return LoggerFactory.getLogger(EVENT_LOGGER_NAME);
    }

    public StandardEvent addKeyword(String keyword, String value) {
        Optional.ofNullable(keywords).orElseGet(() -> keywords = new HashMap<>()).put(keyword, value);
        return this;
    }

}
