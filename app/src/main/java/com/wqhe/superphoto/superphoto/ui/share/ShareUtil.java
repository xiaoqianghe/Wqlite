package com.wqhe.superphoto.superphoto.ui.share;



/**
 * Created by ixzus on 2018/1/9.
 * Email: iandroid@foxmail.com
 * Desc:
 */

public class ShareUtil {

//    public static ShareWebPageBean shareHome(String orgId, String userId, String other) {
////        String url = "http://yhjh5ts.ygs001.com/superbank/wx/index!index.action?orgId="+orgId+"&userId=" + userId;
//        String url = ApiService.index_orgId + orgId + "&userId=" + userId + other;
//        Log.e("shareHome", "shareHome: url " + url);
//        ShareWebPageBean mShareWebPageBean = new ShareWebPageBean();
//        mShareWebPageBean.setTitle("一站式金融产品解决方案服务平台");
//        mShareWebPageBean.setContent("小投入，大收益，人人都有机会成就梦想！");
//        mShareWebPageBean.setTransaction(AppConst.WX_SHARE_PARAMS.WEBPAGE);
//        mShareWebPageBean.setImageUrl("");
//        mShareWebPageBean.setWebpageUrl(url);
//        return mShareWebPageBean;
//    }
//
//    public static ShareWebPageBean shareCardOne(String nick, String bankName, String url) {
//        Log.e("shareCardOne", "shareCardOne: url " + url);
//        ShareWebPageBean mShareWebPageBean = new ShareWebPageBean();
//        mShareWebPageBean.setTitle("0元办卡，最高额度有50万");
//        mShareWebPageBean.setContent(nick + "力推" + bankName + "信用卡，额度高，审批快，包邮到家");
//        mShareWebPageBean.setTransaction(AppConst.WX_SHARE_PARAMS.WEBPAGE);
//        mShareWebPageBean.setImageUrl("");
//        mShareWebPageBean.setWebpageUrl(url);
//        return mShareWebPageBean;
//    }
//
//    public static ShareWebPageBean shareCard(String nick, String url) {
//        Log.e("shareCard", "shareCard: url " + url);
//        ShareWebPageBean mShareWebPageBean = new ShareWebPageBean();
//        mShareWebPageBean.setTitle("有颜值才自信，个性颜值卡，0元免费办");
//        mShareWebPageBean.setContent(nick + "邀请您申请信用卡，包邮到家！");
//        mShareWebPageBean.setTransaction(AppConst.WX_SHARE_PARAMS.WEBPAGE);
//        mShareWebPageBean.setImageUrl("");
//        mShareWebPageBean.setWebpageUrl(url);
//        return mShareWebPageBean;
//    }
//
//    public static ShareWebPageBean shareLoanOne(String url) {
//        Log.e("shareLoanOne", "shareLoanOne: url " + url);
//        ShareWebPageBean mShareWebPageBean = new ShareWebPageBean();
//        mShareWebPageBean.setTitle("送你钱花，最高给你借100万！");
//        mShareWebPageBean.setContent("最快30分钟放款，随借随还！纯信用！");
//        mShareWebPageBean.setTransaction(AppConst.WX_SHARE_PARAMS.WEBPAGE);
//        mShareWebPageBean.setImageUrl("");
//        mShareWebPageBean.setWebpageUrl(url);
//        return mShareWebPageBean;
//    }
//
//    public static ShareWebPageBean shareLoan(String url) {
//        ShareWebPageBean mShareWebPageBean = new ShareWebPageBean();
//        mShareWebPageBean.setTitle("善“贷”自己，免费申请，极速贷款！");
//        mShareWebPageBean.setContent("纯信用无抵押贷款，随借随还！");
//        mShareWebPageBean.setTransaction(AppConst.WX_SHARE_PARAMS.WEBPAGE);
//        mShareWebPageBean.setImageUrl("");
//        mShareWebPageBean.setWebpageUrl(url);
//        return mShareWebPageBean;
//    }

    public static ShareWebPageBean shareAll(String userId,String apppinyin) {
//        本地调试地址：http://djts.ygs001.com
//        H5测试地址：http://yhjh5ts.ygs001.com
//        H5生产地址：http://superbank.olvip.vip
//        String HOST_URL = "http://djts.ygs001.com/";
//        String HOST_URL = "http://yhjh5ts.ygs001.com/";
//        String HOST_URL = "http://superbank.olvip.vip/";
//        String URL = BASE_H5_URL + "/superbank/wx/member!register.action?userId=" + userId + "&orgNamepy=" + apppinyin + MD5Sign.getShareSign(userId, apppinyin);

        String URL="";
        ShareWebPageBean mShareWebPageBean = new ShareWebPageBean();
        mShareWebPageBean.setTitle("一站式金融产品解决方案服务平台");
        mShareWebPageBean.setContent("小投入，大收益，人人都有机会成就梦想！");
        mShareWebPageBean.setTransaction("");
        mShareWebPageBean.setImageUrl("");
        mShareWebPageBean.setWebpageUrl(URL);

        return mShareWebPageBean;
    }

}
