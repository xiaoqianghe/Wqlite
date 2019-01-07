package com.wqhe.superphoto.superphoto.ui.realm;

import io.realm.Realm;

/**
 * Author：Wq
 * Date：2018/6/1 10:15
 * Description：//todo
 */

public class RealmOperationHelper {
    private static Realm mRealm;

    private static class SingletonHolder {
        private static RealmOperationHelper INSTANCE = new RealmOperationHelper(
                mRealm);
    }

    private RealmOperationHelper(Realm realm) {
        this.mRealm = realm;

    }

    /**
     * 获取RealmOperation的单例
     *
     * @param realm 传入realm实例对象
     * @return 返回RealmOperation的单例
     */
    public static RealmOperationHelper getInstance(Realm realm) {
        if (realm != null) {
            mRealm = realm;
        }
        return SingletonHolder.INSTANCE;
    }


}
