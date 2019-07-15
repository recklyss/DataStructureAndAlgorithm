package Alogrithm.others;

import java.util.LinkedHashMap;
import java.util.Map;

/** @Author zhangjiaheng @Description 基于LinkedHashMap的LRU算法 移除最少使用的那个key */
public class LruWithLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

  private static final int DEFAULT_SIZE = 100;

  private int cache_size;

  public LruWithLinkedHashMap() {
    this(DEFAULT_SIZE);
  }

  public LruWithLinkedHashMap(int size) {
    super((int) (Math.ceil(size / 0.75) + 1), 0.75f, true);
    cache_size = size;
  }

  /**
   * 直接返回：当前大小是否大于初始化时设置的大小 删除最老的未访问过的数据
   * @param eldest
   * @return
   */
  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > cache_size;
  }

  public static void main(String[] args) {

  }
}
