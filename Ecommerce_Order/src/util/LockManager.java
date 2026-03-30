package util;

import java.util.concurrent.ConcurrentHashMap;

public class LockManager {
    private static final ConcurrentHashMap<Integer, Object> locks = new ConcurrentHashMap<>();

    public static Object getLock(int id) {
        locks.putIfAbsent(id, new Object());
        return locks.get(id);
    }
}