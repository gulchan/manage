package com.gulchan.manage.utils;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

public class IpAddressUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(IpAddressUtil.class);
    public static final String X_FORWARDED_FOR_UNKNOWN = "unknown";
    /**
     * 获取Ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        if(null == request){
            return "";
        }
        String xIp = request.getHeader("X-Real-IP");
        String xFor = request.getHeader("X-Forwarded-For");
        if (StrUtil.isNotEmpty(xFor) && !X_FORWARDED_FOR_UNKNOWN.equalsIgnoreCase(xFor)) {
            //注意：多次代理会出现多个ip值，第一个ip是真实的
            int index = xFor.indexOf(",");
            if (index != -1) {
                String ip = xFor.substring(0, index);
                LOGGER.info("IpAddressUtil>>>getIpAddress>>>ip>>>{}",ip);
                return ip;
            } else {
                LOGGER.info("IpAddressUtil>>>getIpAddress>>>ip>>>{}",xFor);
                return xFor;
            }
        }
        xFor = xIp;
        if (StrUtil.isNotEmpty(xFor) && !X_FORWARDED_FOR_UNKNOWN.equalsIgnoreCase(xFor)) {
            return xFor;
        }
        if (StrUtil.isBlank(xFor) || X_FORWARDED_FOR_UNKNOWN.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("Proxy-Client-IP");
        }
        if (StrUtil.isBlank(xFor) || X_FORWARDED_FOR_UNKNOWN.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StrUtil.isBlank(xFor) || X_FORWARDED_FOR_UNKNOWN.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StrUtil.isBlank(xFor) || X_FORWARDED_FOR_UNKNOWN.equalsIgnoreCase(xFor)) {
            xFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StrUtil.isBlank(xFor) || X_FORWARDED_FOR_UNKNOWN.equalsIgnoreCase(xFor)) {
            xFor = request.getRemoteAddr();
        }
        LOGGER.info("IpAddressUtil>>>getIpAddress>>>ip>>>{}",xFor);
        return xFor;
    }
}
