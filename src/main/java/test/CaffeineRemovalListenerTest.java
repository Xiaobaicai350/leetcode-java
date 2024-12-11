package test;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CaffeineRemovalListenerTest {
    @Test
    public void test() throws InterruptedException {
        LoadingCache<Integer, Integer> cache = Caffeine.newBuilder()
                .expireAfterAccess(1, TimeUnit.SECONDS)
                // 增加了淘汰监听
                .removalListener(((key, value, cause) -> {
                    System.out.println("淘汰通知，key：" + key + "，原因：" + cause);
                }))
                .build(new CacheLoader<Integer, Integer>() {
                    @Override
                    public Integer load(Integer key) throws Exception {
                        return key;
                    }
                });

        cache.put(1, 2);

        Thread.sleep(2000);
        cache.get(1);//仅仅过期是不足以触发淘汰通知的，因为Caffeine需要在后续的操作中才会去检查并处理过期的条目。
        //淘汰通知，key：1，原因：EXPIRED
    }
}