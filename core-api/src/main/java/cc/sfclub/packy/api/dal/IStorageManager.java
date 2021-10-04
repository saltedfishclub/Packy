package cc.sfclub.packy.api.dal;

public interface IStorageManager {
    <T> IStorage<T> byTypeAndName(Class<T> type,String name);
}
