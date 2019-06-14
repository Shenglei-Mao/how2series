package com.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016092900626617";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjncUgSkvMus8j8eCKaYFaFoqd/BvWhjYEazGSMxAi28pB2Sy04Q2gvCkwNFZ39BtZQWwxFrEZ7S7OkGYau+0lCupAyuua6cSXRWEUeq5lx+irexwKiZo72LwVuC7IeJTgf16HVLuvBq83xHpUuuQnKJU4f8lCZrnY0b1mz7gCoAznvvT9/wUXYOU+NvXTQV9p8hxcooBx/tr+hOW5ocBdNK9Ba1I6GJdFotLWoEs8UKOG0s2+w0nzWRvlO5/aTeA76/tsGIcALuVhOEAM3ybDl/jVppVhgIwLoIn8Gw/zEtX5GsB81Xpc/BHYk1LTFFm772U588zcJxdwpMKCZg/oQIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
