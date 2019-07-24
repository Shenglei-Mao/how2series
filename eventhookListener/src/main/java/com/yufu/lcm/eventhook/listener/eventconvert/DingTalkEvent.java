package com.yufu.lcm.eventhook.listener.eventconvert;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : Michael M
 * <p>
 * 模拟钉钉事件
 */

@Data(staticConstructor = "newInstance")
@Accessors(chain = true)
public class DingTalkEvent {

    private String userId;
    private String event;
    private String result;
}
