package com.wqhe.superphoto.superphoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.squareup.picasso.Picasso;
import com.wqhe.superphoto.superphoto.base.BaseActivity;
import com.wqhe.superphoto.superphoto.utils.GlideUtils;
import com.wqhe.superphoto.superphoto.utils.ImageLoaderUtils.ImageLoader;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.luck.picture.lib.config.PictureMimeType.ofImage;


public class MainActivity extends BaseActivity {

    public static boolean isForeground;



    @BindView(R.id.bt_toImageview)
    Button btToImageview;
//    @BindView(R.id.iv1)
//    ImageView iv1;
    @BindView(R.id.iv1)
    ImageView iv1;

    @BindView(R.id.imageview)
    ImageView imageView;


    @Override
    protected void init() {
//        showPicassoOnlyImageView();

        showGlideOnlyImageView();


        btToImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toSelectorPic();


            }
        });

    }

    private void toSelectorPic() {


        // 进入相册 以下是例子：用不到的api可以不写
        PictureSelector.create(MainActivity.this)
                .openGallery(ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                .theme(R.style.picture.white.style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(9)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
//                .previewVideo()// 是否可预览视频 true or false
//                .enablePreviewAudio() // 是否可播放音频 true or false
//                .isCamera()// 是否显示拍照按钮 true or false
//                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
//                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
//                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
//                .enableCrop()// 是否裁剪 true or false
//                .compress()// 是否压缩 true or false
//                .glideOverride()// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio()// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                .hideBottomControls()// 是否显示uCrop工具栏，默认不显示 true or false
//                .isGif()// 是否显示gif图片 true or false
//                .compressSavePath(getPath())//压缩图片保存地址
//                .freeStyleCropEnabled()// 裁剪框是否可拖拽 true or false
//                .circleDimmedLayer()// 是否圆形裁剪 true or false
//                .showCropFrame()// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
//                .showCropGrid()// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
//                .openClickSound()// 是否开启点击声音 true or false
//                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs()// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
//                .cropCompressQuality()// 裁剪压缩质量 默认90 int
//                .minimumCompressSize(100)// 小于100kb的图片不压缩
//                .synOrAsy(true)//同步true或异步false 压缩 默认同步
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled() // 裁剪是否可旋转图片 true or false
//                .scaleEnabled()// 裁剪是否可放大缩小图片 true or false
//                .videoQuality()// 视频录制质量 0 or 1 int
//                .videoMaxSecond(15)// 显示多少秒以内的视频or音频也可适用 int
//                .videoMinSecond(10)// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond()//视频秒数录制 默认60s int
                .isDragFrame(false)// 是否可拖动裁剪框(固定)
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code


    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
//                    adapter.setList(selectList);
//                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "图片选择成功,选中了" + selectList.size() + "张!", Toast.LENGTH_SHORT).show();
                    setImageViewData(selectList);
                    break;
            }
        }
    }

    private void setImageViewData(List<LocalMedia> selectList) {
        GlideUtils.GlideView(this, iv1, selectList.get(0).getPath());
    }


    public void showPicassoOnlyImageView(){

//        ImageView imageView = findViewById(R.id.imageview);
        String url = "http://ww2.sinaimg.cn/large/7a8aed7bgw1eutsd0pgiwj20go0p0djn.jpg";
        Picasso.with(MainActivity.this)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);


        ImageLoader.getInstance()
                .load(url)
                .angle(80)
                .resize(400, 600)
                .centerCrop()
                .config(Bitmap.Config.RGB_565)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .skipLocalCache(true)
                .into(imageView);


    }


    public void showGlideOnlyImageView(){
        String url = "http://ww2.sinaimg.cn/large/7a8aed7bgw1eutsd0pgiwj20go0p0djn.jpg";

        Glide.with(this)
                .load(url)
                .into(imageView);


        ImageLoader.getInstance()
                .load(url)
                .angle(80)
                .resize(400, 600)
                .centerCrop()
                .config(Bitmap.Config.RGB_565)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .skipLocalCache(true)
                .into(imageView);
    }


}
