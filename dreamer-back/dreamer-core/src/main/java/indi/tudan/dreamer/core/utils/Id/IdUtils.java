package indi.tudan.dreamer.core.utils.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Id 生成器
 *
 * @author wangtan
 * @date 2019-07-29 13:30:59
 * @since 1.0
 */

@Component
public class IdUtils {

    @Value("${system.workerId}")
    private static long workerId;

    @Value("${system.datacenterId}")
    private static long datacenterId;

    public static String nextId() {
        return new SnowflakeIdWorker(workerId, workerId).nextId() + "";
    }
}
