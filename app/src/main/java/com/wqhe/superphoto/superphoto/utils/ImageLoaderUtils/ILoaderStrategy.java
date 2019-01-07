package com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils;

/**
 * Author：Wq
 * Date：2018/6/27 15:34
 * Description：//todo
 */

public interface ILoaderStrategy {

    void loadImage(LoaderOptions options);

    /**
     * 清理内存缓存
     */
    void clearMemoryCache();

    /**
     * 清理磁盘缓存
     */
    void clearDiskCache();
}
