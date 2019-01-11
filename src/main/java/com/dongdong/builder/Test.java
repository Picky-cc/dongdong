package com.dongdong.builder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
//        String test = "REJECT,879,身份证归属地位于高风险较为集中地区 身份证命中法院失信名单 身份证命中犯罪通缉名单 身份证命中法院执行名单 身份证对应人存在助学贷款欠费历史 身份证命中信贷逾期名单 身份证命中高风险关注名单 身份证命中车辆租赁违约名单 身份证命中法院结案名单 身份证命中欠款公司法人代表名单 身份证命中故意违章乘车名单 身份证命中欠税名单 身份证命中欠税公司法人代表名单 身份证命中信贷逾期后还款名单 3个月内身份证关联多个申请信息 3个月内申请信息关联多个身份证 3个月内申请人身份证作为联系人身份证出现的次数大于等于2 7天内设备或身份证或手机号申请次数过多 7天内申请人在多个平台申请借款 1个月内申请人在多个平台申请借款 3个月内申请人在多个平台申请借款";
//        test = new String(test.getBytes("ISO-8859-1"), "UTF-8");
//        System.out.println(test);


        List<String> list = new ArrayList<String>(){
            {
                add("1");
                add("2");
            }
        };

        String json = JSON.toJSONString(list);
        System.out.println(json);
    }
}
