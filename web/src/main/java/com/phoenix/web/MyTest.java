package com.phoenix.web;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibm.icu.util.ULocale;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: tianfeng
 * @Date: 2020-06-23 11:08
 */
public class MyTest {

    public static void main(String[] args) {

        testInt(1);

        for (int k = 0; k < 50; k++) {
            System.out.println("ALTER TABLE box_" + k + " ADD (source tinyint(4) default 0, state tinyint(4) default 0, \n" +
                    "box_time datetime, operate_box_id bigint(20), operate_box_name varchar(128), \n" +
                    "out_time datetime, operate_out_id bigint(20), operate_out_name varchar(128));");
        }

        List<String> alist = new ArrayList<>();
        alist.add("a");
        alist.add("a");
        alist.add("b");
        List<String> strings = alist.stream().distinct().collect(Collectors.toList());
        System.out.println(strings.size());


        com.ibm.icu.text.Collator ZH_COMPARATOR = com.ibm.icu.text.Collator.getInstance(ULocale.SIMPLIFIED_CHINESE);
        //int compare = ZH_COMPARATOR.compare("444", "墨风供应");
        int compare = ZH_COMPARATOR.compare("1909", "1aa");

        System.out.println(compare);


        JSONObject jo = new JSONObject();
        jo.put("outerId", "9090");
        jo.put("amount", 1);

        JSONArray ja = new JSONArray();
        ja.add(jo);

        System.out.println(ja);

        String chatConfigs = "{\n" +
                "    \"openPackExpressVoiceHints\":0,\n" +
                "    \"openEstConsignTime\":1,\n" +
                "    \"openCloudSmartMatch\":0,\n" +
                "    \"mergeAfterMatchGift\":0,\n" +
                "    \"weighSupportSwitchAccount\":0,\n" +
                "    \"tbFreightRule\":\"0,1,2,3,5,6\",\n" +
                "    \"giftRuleCheckPermission\":0,\n" +
                "    \"packUploadInfo\":\"skuSysId,packDate\",\n" +
                "    \"showMainsysouterId\":0,\n" +
                "    \"reprintFilterConsigned\":1,\n" +
                "    \"tradeDisclaimerStart\":\"2020-05-18 13:52:04\",\n" +
                "    \"openExpressWeightHints\":1,\n" +
                "    \"pddFreightRule\":\"0,1,2,3,5,6\",\n" +
                "    \"changeWarehouseCheckPermission\":0,\n" +
                "    \"autoWaitAuditUndoMerge\":0,\n" +
                "    \"changeMemoRecalculationExpress\":0,\n" +
                "    \"openTradePay\":1,\n" +
                "    \"isHandMemoMessageAudit\":0,\n" +
                "    \"allowRemoveAllPlatItem\":1,\n" +
                "    \"splitInsufficientAllowGift\":1,\n" +
                "    \"ptLockClose\":0,\n" +
                "    \"ruleAutoSeparateWarehouse\":1,\n" +
                "    \"jdFreightRule\":\"0,1,2,3,5,6\",\n" +
                "    \"changeMemoRecalculationTag\":0,\n" +
                "    \"pddUseCaiNiao\":0,\n" +
                "    \"mergeRemarkContainException\":1,\n" +
                "    \"tradeChangeSignTags\":\"\",\n" +
                "    \"reserveExceptAfterCancelAudit\":0,\n" +
                "    \"splitGetNewWaybillCode\":0,\n" +
                "    \"packSupportSwitchAccount\":1,\n" +
                "    \"packSellerFlag\":\"\",\n" +
                "    \"matchTagAfterGift\":1,\n" +
                "    \"splitAutoAudit\":0,\n" +
                "    \"autoSendFinance\":1,\n" +
                "    \"autoSuitTransformSingle\":0,\n" +
                "    \"kyAuditAutoGetWaybillCode\":0,\n" +
                "    \"pictureFromPlatform\":\"all\",\n" +
                "    \"autoRemarkMergeException\":0,\n" +
                "    \"tradeDisclaimerIp\":\"183.134.110.211\",\n" +
                "    \"openPartRefund\":1,\n" +
                "    \"orderQueryFullSwitch\":0,\n" +
                "    \"openPackUploadSellerMemo\":1,\n" +
                "    \"insufficientAnalyzeAudit\":0,\n" +
                "    \"oSActivityDelayMinute\":1440,\n" +
                "    \"tradeDisclaimerEnd\":\"2020-12-20 00:00:00\",\n" +
                "    \"openCheckRepeatCod\":0,\n" +
                "    \"isCoverWeight\":1,\n" +
                "    \"openExpressFreight\":0,\n" +
                "    \"packmaIndex\":0,\n" +
                "    \"showPlatTitle\":1,\n" +
                "    \"auditAutoInsufficientCanceled\":0,\n" +
                "    \"auditIncluedInsufficientStock\":1,\n" +
                "    \"registerSupportSwitchAccount\":1,\n" +
                "    \"packForceType\":1,\n" +
                "    \"otherFreightRule\":\"0,1,2,3,5,6\",\n" +
                "    \"tradeUploadFilterClosed\":0,\n" +
                "    \"mergeRecalculationTag\":0,\n" +
                "    \"openRefundpNotApplyStock\":1,\n" +
                "    \"splitRecalculationTag\":0,\n" +
                "    \"showTradeNumIid\":1,\n" +
                "    \"matchFreightZeroWeight\":1,\n" +
                "    \"autoCancelAuditStatus\":0,\n" +
                "    \"mergeAfterMatchWarehouse\":0,\n" +
                "    \"openSendExpressCompanyVoiceHints\":0,\n" +
                "    \"expressMatchFilterExist\":1,\n" +
                "    \"mergeAfterMatchExpress\":0,\n" +
                "    \"openScalpNotApplyStock\":1,\n" +
                "    \"allowRemoveItem\":1,\n" +
                "    \"canMergeCheckSysStatus\":\"WAIT_AUDIT,FINISHED_AUDIT,SELLER_SEND_GOODS\",\n" +
                "    \"blurTrade\":0\n" +
                "}";

        JSONObject jsonObject1 = JSONObject.parseObject(chatConfigs);
        // 开启包装验货/包裹称重支持扫包材，单选包裹称重
        Integer packmaIndex = jsonObject1.getInteger("packmaIndex");
        System.out.println("packmaIndex:" + packmaIndex);


        String[] split = StringUtils.split("", ",");
        if (split != null) {
            System.out.println(true);
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
            }
        } else {
            System.out.println(false);
        }

        List<String> mylist = new ArrayList<>();
        mylist.add("佳宝童装");

        mylist.add("意法服饰");

        Set<String> queryCategories = new HashSet<String>();
        queryCategories.add("佳宝童装");
        boolean result = mylist.stream().noneMatch(str -> judge(str, queryCategories));
        System.out.println("result: " + result);

        List<String> catList = Arrays.asList("123");
        //boolean b = catList.remove("123");
        //System.out.println("b:" + b);

        List<String> strs = new ArrayList<>();
        strs.add("123");
        List<String> res = intersection(catList, strs);
        res.forEach(s -> System.out.println(s));

        List<String> updates = Lists.newArrayListWithCapacity(2);
        System.out.println(CollectionUtils.isEmpty(updates));


    }

    private static boolean judge(String  categoryNameStr, Set<String> queryCategories) {
        if (StringUtils.isNotBlank(categoryNameStr)) {
            String[] catArray = StringUtils.split(categoryNameStr, ",");
            List<String> catList = Arrays.asList(catArray);

            List<String> queryCatList = new ArrayList<>(queryCategories);
            List<String> intersection = intersection(catList, queryCatList);
            return CollectionUtils.isNotEmpty(intersection);
        } else {
            return false;
        }
    }

    public static <T> List<T> intersection(final List<? extends T> list1, final List<? extends T> list2) {
        List<? extends T> smaller = list1;
        List<? extends T> larger = list2;
        if (list1.size() > list2.size()) {
            smaller = list2;
            larger = list1;
        }

        // 克隆一个可修改的副本
        List<T> newSmaller = new ArrayList<T>(smaller);
        List<T> result = new ArrayList<T>(smaller.size());
        for (final T e : larger) {
            if (newSmaller.contains(e)) {
                result.add(e);
                newSmaller.remove(e);
            }
        }
        return result;
    }

    public static void testInt(int a) {
        System.out.println(a);
    }
}
