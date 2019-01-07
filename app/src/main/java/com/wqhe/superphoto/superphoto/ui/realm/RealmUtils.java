package com.wqhe.superphoto.superphoto.ui.realm;

import com.blankj.utilcode.util.ToastUtils;
import com.wqhe.superphoto.superphoto.SuperPhotoApplication;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Author：Wq
 * Date：2018/5/31 17:24
 * Description：//todo
 */

public class RealmUtils {

    public static void addRealm(){

        Realm.getDefaultInstance();

        Realm.getDefaultInstance().beginTransaction();
        TimeInfo info= Realm.getDefaultInstance().createObject(TimeInfo.class); // Create a new object
        info.setTitle("realm");
        Realm.getDefaultInstance().commitTransaction();
    }

    public static void addOtherRealm(final TimeInfo bean){
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(bean);

            }
        });
    }



    public static void queryRealm(Class clazz){
        RealmResults<? extends RealmObject> beans =Realm.getDefaultInstance().where(clazz).findAll();
    }


    public static void queryOtherRealm(String fieldName,String value){
        RealmObject bean = Realm.getDefaultInstance().where(TimeInfo.class).equalTo(fieldName, value).findFirst();
    }


    public static void deletdReleam(){

        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {


//                //删除第一个数据
//                beans.deleteFirstFromRealm();
//                //删除最后一个数据
//                beans.deleteLastFromRealm();
//                //删除某个位置的数据
//                beans.deleteFromRealm(position);
//                //删除所有数据
//                beans.deleteAllFromRealm();
            }
        });


    }

    public static  void modifyRealm(){

//        TimeInfo info= mRealm.where(TimeInfo.class).equalTo("position", position).findFirst();
//        mRealm.beginTransaction();
//        info.setPosition(newPosition);
//        mRealm.commitTransaction();


    }



    public static void asyncTaskAdd(final TimeInfo bean){

        RealmAsyncTask addTask= Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(bean);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
//                T
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
//                ToastUtil.showShortToast(mContext,"添加失败");
            }
        });


    }


    public  static void asyncDeleted(final int position){

        RealmAsyncTask  deleteTask=Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TimeInfo info =realm.where(TimeInfo.class).equalTo("position",position).findFirst();
                info .deleteFromRealm();

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
//                ToastUtil.showShortToast(mContext,"删除成功");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
//                ToastUtil.showShortToast(mContext,"删除失败");
            }
        });


    }


    public static void asyncModify(final int position){
        RealmAsyncTask  updateTask=Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TimeInfo info =realm.where(TimeInfo.class).equalTo("position",position).findFirst();
                info .setPosition(position);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
//                ToastUtil.showShortToast(mContext,"更新成功");

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
//                ToastUtil.showShortToast(mContext,"失败成功");
            }
        });


    }

    
    /**
     * @// TODO: 2018/6/1  异步查询
     * 
     * */
    public void  asyncQuery(){

        RealmResults<TimeInfo>   infos=Realm.getDefaultInstance().where(TimeInfo.class).findAllAsync();
        infos.addChangeListener(new RealmChangeListener<RealmResults<TimeInfo>>() {
            @Override
            public void onChange(RealmResults<TimeInfo> element) {
                //执行接收到查询结果数据

            }
        });

    }


    public static void  add(TimeInfo info){

//        RealmOperationHelper.getInstance(SuperPhotoApplication.REALM_INSTANCE).add(info);

//        RealmOperationHelper.getInstance(SuperPhotoApplication).add(info);

    }



}
