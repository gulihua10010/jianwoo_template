package cn.jianwoo.common.utils.ip;

import cn.jianwoo.common.config.JianwooConfig;
import cn.jianwoo.common.constant.Constants;
import cn.jianwoo.common.utils.StringUtils;
import cn.jianwoo.common.utils.http.HttpUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * 获取地址类
 *
 * @author jianwoo
 */
public class AddressUtils {
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    // IP地址查询
    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";

    // 未知地址
    public static final String UNKNOWN = "XX XX";

    public static String getRealAddressByIP(String ip) {
        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }

        if (JianwooConfig.isAddressEnabled()) {
            try {
                String address = getRegionFromXdb(ip);
                if (!Constants.UNKNOW.equals(address)) {
                    return address;
                }

                String rspStr = HttpUtils.sendGet(IP_URL, "ip=" + ip + "&json=true", Constants.GBK);
                if (StringUtils.isEmpty(rspStr)) {
                    log.error("获取地理位置异常 {}", ip);
                    return UNKNOWN;
                }
                JSONObject obj = JSON.parseObject(rspStr);
                String region = obj.getString("pro");
                String city = obj.getString("city");
                return java.lang.String.format("%s %s", region, city);
            } catch (Exception e) {
                log.error("获取地理位置异常 {}", ip);
            }
        }
        return UNKNOWN;
    }

    public static String getRegionFromXdb(String ip) {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            org.springframework.core.io.Resource[] resources = resolver.getResources("ip/ip2region.xdb");
            InputStream inputStream = resources[0].getInputStream();
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            Searcher searcher = null;
            try {
                searcher = Searcher.newWithBuffer(result.toByteArray());
            } catch (IOException e) {
                log.error(java.lang.String.format("failed to create searcher with `ip/ip2region.xdb`: %s\n", e));
                return Constants.UNKNOW;

            }

            // 2、查询
            try {
                long sTime = System.nanoTime();
                String region = searcher.search(ip);
                long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
                log.error(
                        java.lang.String.format("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost));
                return format4Xdb(region);
            } catch (Exception e) {
                log.error(java.lang.String.format("failed to search(%s): \n", ip), e);
                return Constants.UNKNOW;
            }
        } catch (Exception e) {
            log.error("NetWorkServiceImpl.getRegionFromXdb exec failed: e\r\n", e);
            return Constants.UNKNOW;
        }
    }


    private static String format4Xdb(String region) {
        if (org.apache.commons.lang3.StringUtils.isBlank(region)) {
            return Constants.UNKNOW;
        }
        if (region.contains("内网")) {
            return "内网IP";
        }
        String[] arr = region.split("\\|");
        if (region.startsWith("中国")) {
            if (arr.length > 4) {
                return arr[2] + arr[3];
            }
            return region;
        }
        if (arr.length > 0) {
            return arr[0];
        }
        return region;
    }


}
