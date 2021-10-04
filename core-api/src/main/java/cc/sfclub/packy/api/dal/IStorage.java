package cc.sfclub.packy.api.dal;

import java.util.List;

public interface IStorage<T> {
    List<T> fetch(String sqlExp);
    boolean append(List<T> t);
}
