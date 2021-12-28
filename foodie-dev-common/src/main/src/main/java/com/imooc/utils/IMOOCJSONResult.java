package com.imooc.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Title: IMOOCJSONResult.java
 * @Package com.imooc.utils
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 * 
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * 				556: 用户qq校验异常
 * @Copyright: Copyright (c) 2020
 * @Company: www.imooc.com
 * @author
 * @version V1.0
 */
public class IMOOCJSONResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static String trceid;

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;





    @JsonIgnore
    private String ok;	// 不使用

    StringRandom test = new StringRandom();

    public static IMOOCJSONResult build(Integer status, String msg, Object data ,String trceid) {
        return new IMOOCJSONResult(status, msg, data,trceid);
    }

    public static IMOOCJSONResult build(Integer status, String msg, Object data, String ok,String trceid) {
        return new IMOOCJSONResult(status, msg, data, ok,trceid);
    }
    
    public static IMOOCJSONResult ok(Object data,String trceid) {
        return new IMOOCJSONResult(data, "T"+trceid);
    }

    public static IMOOCJSONResult ok() {
        return new IMOOCJSONResult(null, trceid);
    }
    
    public static IMOOCJSONResult errorMsg(String msg, String trceid) {
        return new IMOOCJSONResult(500, msg, null, "T"+trceid);
    }
    
    public static IMOOCJSONResult errorMap(Object data,String trceid) {
        return new IMOOCJSONResult(501, "error", data, "T"+trceid);
    }
    
    public static IMOOCJSONResult errorTokenMsg(String msg,String trceid) {
        return new IMOOCJSONResult(502, msg, null, "T"+trceid);
    }
    
    public static IMOOCJSONResult errorException(String msg,String trceid) {
        return new IMOOCJSONResult(555, msg, null, "T"+trceid);
    }
    
    public static IMOOCJSONResult errorUserQQ(String msg,String trceid) {
        return new IMOOCJSONResult(556, msg, null, "T"+trceid);
    }

    public IMOOCJSONResult() {

    }

    public IMOOCJSONResult(Integer status, String msg, Object data,String trceid) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.trceid = trceid;
    }
    
    public IMOOCJSONResult(Integer status, String msg, Object data, String ok,String trceid) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
        this.trceid = trceid;
    }

    public IMOOCJSONResult(Object data ,String trceid) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
        this.trceid = trceid;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}
    public String getTrceid() {
        return trceid;
    }

    public String setTrceid(String trceid) {
        this.trceid = trceid;
        return trceid;
    }
}
