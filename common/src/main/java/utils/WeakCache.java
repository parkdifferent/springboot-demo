package utils;


import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author foolish-bird
 * @date 2023/1/6
 */
public class WeakCache<K, V> {

    private Map<K, V> cache;

    private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();

    private ReadLock readLock = reentrantLock.readLock();

    private WriteLock writeLock = reentrantLock.writeLock();

    public WeakCache() {
        cache = new WeakHashMap<>(16);
    }

    public WeakCache(int capacity) {
        cache = new WeakHashMap<>(capacity);
    }

    public V get(K key) {
        readLock.lock();
        try {
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void put(K key, V value) {
        writeLock.lock();
        try {
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        writeLock.lock();
        try {
            map.forEach((k, v) -> cache.put(k, v));
        } finally {
            writeLock.unlock();
        }
    }

    public void remove(K key) {
        writeLock.lock();
        try {
            cache.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

}
