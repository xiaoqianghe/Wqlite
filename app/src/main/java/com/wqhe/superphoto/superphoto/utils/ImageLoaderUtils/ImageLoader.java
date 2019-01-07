package com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils;

import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * Author：Wq
 * Date：2018/6/27 14:58
 * Description：//todo 图片加载的基类
 */

public class ImageLoader {

//    void loadImage(ImageView view, String path, int placeholderId, int errorId,boolean skipMemory);
//    void loadImage(ImageView view, File file, int placeholderId, int errorId, boolean skipMemory);


    private static ILoaderStrategy sLoader;
    private static volatile ImageLoader sInstance;
    private ImageLoader() {
    }
    //单例模式
    public static ImageLoader getInstance() {
        if (sInstance == null) {
            synchronized (ImageLoader.class) {
                if (sInstance == null) {
                    //若切换其它图片加载框架，可以实现一键替换
                    sInstance = new ImageLoader();
                }
            }
        }
        return sInstance;
    }
    //提供实时替换图片加载框架的接口
    public void setImageLoader(ILoaderStrategy loader) {
        if (loader != null) {
            sLoader = loader;
        }
    }
    public LoaderOptions load(String path) {
        return new LoaderOptions(path);
    }
    public LoaderOptions load(int drawable) {
        return new LoaderOptions(drawable);
    }
    public LoaderOptions load(File file) {
        return new LoaderOptions(file);
    }
    public LoaderOptions load(Uri uri) {
        return new LoaderOptions(uri);
    }
    public void loadOptions(LoaderOptions options) {
        sLoader.loadImage(options);
    }
    public void clearMemoryCache() {
        sLoader.clearMemoryCache();
    }
    public void clearDiskCache() {
        sLoader.clearDiskCache();
    }


}
