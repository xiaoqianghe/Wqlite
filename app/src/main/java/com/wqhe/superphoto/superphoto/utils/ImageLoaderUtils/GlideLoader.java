package com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils;

import android.util.LruCache;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.wqhe.superphoto.superphoto.SuperPhotoApplication;

import java.io.File;

/**
 * Author：Wq
 * Date：2018/6/27 17:06
 * Description：//todo
 */

public class GlideLoader implements ILoaderStrategy {
    @Override
    public void loadImage(LoaderOptions options) {

    }

    @Override
    public void clearMemoryCache() {

    }

    @Override
    public void clearDiskCache() {

    }







//    private volatile static Glide sGlideSingleton;
//    private final String GLIDE_CACHE = "glide-cache";
//    private static LruCache sLruCache = new LruCache(SuperPhotoApplication.gApp);
//    private static Glide getGlide() {
//        if (sGlideSingleton == null) {
//            synchronized (GlideLoader.class) {
//                if (sGlideSingleton == null) {
////                    sGlideSingleton = new Picasso.Builder(SuperPhotoApplication.gApp).memoryCache(sLruCache).build();
//
//                    sGlideSingleton = Glide.get(SuperPhotoApplication.gApp);
//
//
//                }
//            }
//        }
//        return sGlideSingleton;
//    }
//
//    private volatile  static RequestManager requestManager;
//    private static RequestManager  getRequestManager () {
//        if (requestManager== null) {
//            synchronized (GlideLoader.class) {
//                if (requestManager == null) {
////                    sGlideSingleton = new Picasso.Builder(SuperPhotoApplication.gApp).memoryCache(sLruCache).build();
//
//                    requestManager = Glide.with(SuperPhotoApplication.gApp);
//
//
//                }
//            }
//        }
//        return requestManager;
//    }
//
//    @Override
//    public void clearMemoryCache() {
//        sLruCache.clear();
//    }
//    @Override
//    public void clearDiskCache() {
//        File diskFile = new File(SuperPhotoApplication.gApp.getCacheDir(), GLIDE_CACHE);
//        if (diskFile.exists()) {
//            //这边自行写删除代码
////          FileUtil.deleteFile(diskFile);
//        }
//    }
//
//
//
//    @Override
//    public void loadImage(LoaderOptions options) {
//
//
//        RequestBuilder mRequestBuilder=null;
//
//        if(options.url != null){
//
//
//          mRequestBuilder=getRequestManager().load(options.url);
//
//        }
//
////
////        RequestCreator requestCreator = null;
////
////        RequestBuilder mRequestBuilder=null;
////
////        if (options.url != null) {
////
////            mRequestBuilder = getGlide().load(options.url);
////
////
////        } else if (options.file != null) {
////            requestCreator = getPicasso().load(options.file);
////        }else if (options.drawableResId != 0) {
////            requestCreator = getPicasso().load(options.drawableResId);
////        } else if (options.uri != null){
////            requestCreator = getPicasso().load(options.uri);
////        }
////        if (requestCreator == null) {
////            throw new NullPointerException("requestCreator must not be null");
////        }
////        if (options.targetHeight > 0 && options.targetWidth > 0) {
////            requestCreator.resize(options.targetWidth, options.targetHeight);
////        }
////        if (options.isCenterInside) {
////            requestCreator.centerInside();
////        } else if (options.isCenterCrop) {
////            requestCreator.centerCrop();
////        }
////        if (options.config != null) {
////            requestCreator.config(options.config);
////        }
////        if (options.errorResId != 0) {
////            requestCreator.error(options.errorResId);
////        }
////        if (options.placeholderResId != 0) {
////            requestCreator.placeholder(options.placeholderResId);
////        }
////        if (options.bitmapAngle != 0) {
////            requestCreator.transform(new PicassoLoader.PicassoTransformation(options.bitmapAngle));
////        }
////        if (options.skipLocalCache) {
////            requestCreator.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE);
////        }
////        if (options.skipNetCache) {
////            requestCreator.networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE);
////        }
////        if (options.degrees != 0) {
////            requestCreator.rotate(options.degrees);
////        }
//////        if (options.targetView instanceof ImageView) {
//////            requestCreator.into(((ImageView)options.targetView));
//////        } else if (options.callBack != null){
//////            requestCreator.into(new PicassoLoader.PicassoTarget(options.callBack));
//////        }
////
////
////
////        if (options.targetView instanceof ImageView) {
////            mRequestBuilder.into(((ImageView)options.targetView));
////        } else if (options.callBack != null){
//////            requestCreator.into(new PicassoLoader.PicassoTarget(options.callBack));
////        }
//
//
//
//
//
//    }


}
