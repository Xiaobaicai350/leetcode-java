package test;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

public class CaffeineRecordTest {

    /**
     * 模拟从数据库中读取数据
     */
    private int getInDB(int key) {
        return key;
    }

    @Test
    public void test() {
        LoadingCache<Integer, Integer> cache = Caffeine.newBuilder()
                // 开启记录(缓存命中率)
                .recordStats()
                .build(new CacheLoader<Integer, Integer>() {
                    @Override
                    public Integer load(Integer key) {
                        return getInDB(key);
                    }
                });
        cache.get(1);//未命中
        cache.get(1);//命中
        cache.get(1);//命中
        cache.get(1);//命中

        // 命中率
        System.out.println(cache.stats().hitRate());//0.75
        // 被剔除的数量
        System.out.println(cache.stats().evictionCount());
        // 加载新值所花费的平均时间[纳秒]
        System.out.println(cache.stats().averageLoadPenalty());
    }
}