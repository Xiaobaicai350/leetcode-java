package test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineCapacityTest {

    public static void main(String[] args) {
        // 创建初始容量为100的缓存，使用同步驱逐
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .build();

        // 添加一些数据
        for (int i = 0; i < 150; i++) {
            cache.put("key" + i, "value" + i);
        }
        System.out.println("1初始缓存大小: " + cache.estimatedSize());

        cache.cleanUp(); // 手动清理

        System.out.println("2初始缓存大小: " + cache.estimatedSize());

        // 修改缓存容量为200
        cache.policy().eviction().ifPresent(eviction -> {
            eviction.setMaximum(200);
        });

        // 再次添加一些数据
        for (int i = 150; i < 300; i++) {
            cache.put("key" + i, "value" + i);
        }
        System.out.println("1修改后缓存大小: " + cache.estimatedSize());

        cache.cleanUp(); // 手动清理

        System.out.println("2修改后缓存大小: " + cache.estimatedSize());
    }
}

