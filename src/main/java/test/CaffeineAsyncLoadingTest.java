package test;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CaffeineAsyncLoadingTest {

    public static void main(String[] args) throws Exception {
        // 创建异步加载缓存
        AsyncLoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .buildAsync(key -> simulateDataFetch(key));

        // 查询缓存中已存在的数据
        CompletableFuture<String> future1 = cache.get("key1");
        System.out.println("Value for key1: " + future1.get());

        // 查询缓存中不存在的数据，触发异步加载
        CompletableFuture<String> future2 = cache.get("key2");
        System.out.println("Value for key2: " + future2.get());

        // 再次查询key2，应该直接从缓存中获取
        CompletableFuture<String> future3 = cache.get("key2");
        System.out.println("Value for key2 (cached): " + future3.get());

        // 查询多个键，包括缓存中不存在的
        CompletableFuture<String> future4 = cache.get("key3");
        CompletableFuture<String> future5 = cache.get("key4");

        System.out.println("Value for key3: " + future4.get());
        System.out.println("Value for key4: " + future5.get());
    }

    // 模拟异步数据获取
    private static String simulateDataFetch(String key) throws InterruptedException {
        System.out.println("Fetching data for key: " + key);
        // 模拟网络延迟
        Thread.sleep(1000);
        return "Value for " + key;
    }
}