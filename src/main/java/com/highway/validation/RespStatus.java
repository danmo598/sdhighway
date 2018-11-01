package com.highway.validation;

import lombok.Data;

/**
 * Created by LiuChen on 2017/07/05.
 */
@Data
public class RespStatus {

    public static final String SUCCESS = "000";
    public static final String SUCCESS_NULL= "003";
    public static final String SUCCESS_MSG = "Success";
    public static final String SUCCESS_MSG_CN = "成功";
    public static final String LOGIN_SUCCESS_MSG = "login success";
    public static final String LOGIN_SUCCESS_MSG_CN = "登录失败";
    public static final String REGISTER_SUCCESS_MSG = "register success";
    public static final String REGISTER_SUCCESS_MSG_CN = "注册成功";
    public static final String SAVED_SUCCESS_MSG = "save success";
    public static final String SAVED_SUCCESS_MSG_CN = "保存成功";
    public static final String FAILED = "001";
    public static final String FAILED_MSG = "Failed";
    public static final String FAILED_MSG_CN = "请求失败";
    public static final String EXISTED = "002";
    public static final String EXISTED_MSG = "Existed";
    public static final String EXISTED_MSG_CN = "用户已存在！";
    public static final String BAD_REQUEST = "004";
    public static final String ENTITY_NOT_EXIST = "005";
    public static final String ENTITY_NOT_MSG = "entity not exist";
    public static final String ENTITY_NOT_MSG_CN = "数据不存在";
    public static final String ENTITY_EXISTED = "006";
    public static final String ENTITY_EXISTED_MSG = "entity is existed";
    public static final String ENTITY_EXISTED_MSG_CN = "数据已经存在";
    public static final String LOGIN_FAILED = "007";
    public static final String LOGIN_FAILED_MSG = "login failed";
    public static final String LOGIN_FAILED_MSG_CN = "登录失败";
    public static final String REGISTER_FAILED = "008";
    public static final String REGISTER_FAILED_MSG = "register failed";
    public static final String REGISTER_FAILED_MSG_CN = "注册失败";
    public static final String SAVED_FAILED = "009";
    public static final String SAVED_FAILED_MSG = "save failed";
    public static final String SAVED_FAILED_MSG_CN = "保存失败";

    public static final String UPDATE_FAILED = "010";
    public static final String UPDATE_FAILED_MSG = "update failed";
    public static final String UPDATE_FAILED_MSG_CN = "更新失败";

    public static final String REMOVE_FAILED = "011";
    public static final String REMOVE_FAILED_MSG = "remove failed";
    public static final String REMOVE_FAILED_MSG_CN = "删除失败";

    public static final String REGISTERED_MSG = "registered";
    public static final String REGISTERED_MSG_CN = "已认证的";

    public static final String UNREGISTERED = "012";
    public static final String UNREGISTERED_MSG = "unregister";
    public static final String UNREGISTERED_MSG_CN = "未认证";

    public static final String CHECKED_MSG = "checked";
    public static final String CHECKED_MSG_CN = "已审核";

    public static final String UNCHECKED = "013";
    public static final String UNCHECKED_MSG = "unchecked";
    public static final String UNCHECKED_MSG_CN = "未审核";

    public static final String IP_NOT_WHITE_LIST="999";
    public static final String IP_NOT_WHITE_LIST_MSG="ip地址不在白名单内";

    public static final String UNDELIVERY = "014";
    public static final String UNDELIVERY_MSG = "unDelivery";
    public static final String UNDELIVERY_MSG_CN = "待发货";

    public static final String UNTAKEDELIVERY = "015";
    public static final String UNTAKEDELIVERY_MSG = "unTakeDelivery";
    public static final String UNTAKEDELIVERY_MSG_CN = "待收货";

    public static final String UNPAYMENT = "016";
    public static final String UNPAYMENT_MSG = "unPayment";
    public static final String UNPAYMENT_MSG_CN = "待付款";

    public static final String COMPLETED = "017";
    public static final String COMPLETED_MSG = "completed";
    public static final String COMPLETED_MSG_CN = "已完成";

    public static final String CANCELED = "018";
    public static final String CANCELED_MSG = "canceled";
    public static final String CANCELED_MSG_CN = "已取消";


}
