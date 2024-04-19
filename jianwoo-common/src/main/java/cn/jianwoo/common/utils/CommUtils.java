package cn.jianwoo.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import cn.hutool.extra.template.engine.velocity.VelocityEngine;
import com.alibaba.fastjson2.JSONObject;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author gulihua
 * @Description
 * @date 2023-08-23 15:13
 */
@Slf4j
public class CommUtils
{

    /**
     * 计算字符串字节大小为long类型<br>
     * eg:1024MB==>1073741824
     *
     * @param maxSize
     * @return
     * @author gulihua
     */
    public static Long processMaxSizeStr(String maxSize)
    {
        if (null == maxSize) return null;
        if (StringUtils.isBlank(maxSize)) return 0L;
        int i = 0;
        long baseBit = 1;
        long size = 0;
        boolean bitFlag = false;

        while (i < maxSize.length())
        {
            char d = maxSize.charAt(i);

            if (d >= '0' && d <= '9')
            {
                size = size * 10 + Integer.parseInt(String.valueOf(d));
            }
            else
            {
                switch (d)
                {
                case 'b':
                    bitFlag = true;
                    break;
                case 'B':
                    bitFlag = false;
                    break;
                case 'k':
                case 'K':
                    baseBit = 1024;
                    break;
                case 'm':
                case 'M':
                    baseBit = 1024 * 1024;
                    break;
                case 'g':
                case 'G':
                    baseBit = 1024 * 1024 * 1024;
                    break;
                case 't':
                case 'T':
                    baseBit = 1024L * 1024 * 1024 * 1024;
                    break;
                case 'p':
                case 'P':
                    baseBit = 1024L * 1024 * 1024 * 1024 * 1024;
                    break;
                default:
                    baseBit = 1;
                }
            }
            i++;

        }
        return bitFlag ? baseBit * size / 8 : baseBit * size;
    }


    /**
     * 解析long字节为字符串<br>
     * eg:1073741824==>1.00GB
     *
     * @param %param name% %param description%
     * @return
     * @author gulihua
     */
    public static String parseSize(Long size)
    {
        if (size == null)
        {
            return null;
        }
        double sizeDb = size;
        String[] unit = { "B", "KB", "MB", "GB", "TB", "PB" };
        double s;
        int i = 0;
        while ((s = sizeDb / 1024.0) >= 1 && i < 6)
        {
            sizeDb = s;
            i++;
        }
        BigDecimal sizeStr = new BigDecimal(String.valueOf(sizeDb));
        BigDecimal sizeNum = sizeStr.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(sizeNum).concat(unit[i]);
    }


    /**
     * 解析long字节为字符串<br>
     * eg:1073741824==>1.00, GB
     *
     * @param %param name% %param description%
     * @return
     * @author gulihua
     */
    public static String[] parseSizeSplit(Long size)
    {
        if (size == null)
        {
            return null;
        }
        String[] unit = { "B", "KB", "MB", "GB", "TB", "PB" };
        long s;
        int i = 0;
        while ((s = size / 1024) >= 1 && i < 6)
        {
            size = s;
            i++;
        }
        BigDecimal sizeStr = new BigDecimal(String.valueOf(size));
        BigDecimal sizeNum = sizeStr.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat df = new DecimalFormat("0.##");
        String u = unit[i];
        if (sizeNum.compareTo(BigDecimal.ZERO) == 0)
        {
            u = "MB";
        }
        return new String[] { df.format(sizeNum), u };
    }


    /**
     * 解析内存值为分隔数组，数值和单位分开<br>
     * eg:12GB==>12, GB
     *
     * @param %param name% %param description%
     * @return
     * @author gulihua
     */
    public static String[] parseSizeStrSplit(String size)
    {
        if (StrUtil.isBlank(size))
        {
            return null;
        }
        String v = ReUtil.get("\\d+", size, 0);
        String u = ReUtil.get("[a-zA-Z]+", size, 0);
        if ("0".equals(v))
        {
            u = "MB";
        }
        return new String[] { v, u };
    }


    /**
     * 校验数组是否包含指定值
     *
     * @param targetValue 值
     * @return 是否包含
     */
    public static boolean arraysContains(String targetValue, String... elements)
    {
        return Arrays.asList(elements).contains(targetValue);
    }


    /**
     * 处理 cpu 时间, eg: 01:30:10
     * 
     * @param time 时间
     * @return
     */
    public static Long parseCpuTime(String time)
    {
        String t = time.split("\\.")[0];
        String[] arr = t.split(":");
        long s = 0;
        for (int i = arr.length - 1; i >= 0; i--)
        {
            s = s + Integer.parseInt(arr[i]) * Double.valueOf(Math.pow(60, arr.length - 1 - i)).longValue();
        }
        return s;
    }


    public static String doRenderTpl(String content, JSONObject param)
    {
        if (StrUtil.isBlank(content))
        {
            return null;
        }
        try
        {
            // 自动根据用户引入的模板引擎库的jar来自动选择使用的引擎
            // TemplateConfig为模板引擎的选项，可选内容有字符编码、模板路径、模板加载方式等，默认通过模板字符串渲染
            TemplateEngine engine = TemplateUtil
                    .createEngine(new TemplateConfig().setCustomEngine(VelocityEngine.class));

            // 假设我们引入的是Beetl引擎，则：
            Template template = engine.getTemplate(content);
            return template.render(param);
        }
        catch (Exception e)
        {
            log.error(">>Render Email Template Failed, e:\r\n", e);
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("render.failed"));
        }
    }


    /**
     * 生成任务号前缀
     *
     * @return
     * @author gulihua
     */
    public static String generatePreTaskId()
    {
        return DateUtil.format(new Date(), "yyMMddHHmmssSSS");
    }


    public static String calculatePrometheusTime(long time)
    {
        int[] unitNumberArr = new int[] { 60, 60, 24 };
        long[] timeArr = new long[] { time, 0, 0, 0 };
        String[] unitArr = new String[] { "s", "m", "h", "d" };
        long t = time / unitNumberArr[0];
        long n = time % unitNumberArr[0];
        long prevTime = time;

        int i = 0;
        while (t >= 1 && i < 2)
        {
            timeArr[i] = n;
            i++;
            prevTime = t;
            n = t % unitNumberArr[i];
            t = t / unitNumberArr[i];
        }
        timeArr[i] = prevTime;
        if (i == 2)
        {
            timeArr[i] = n;
            timeArr[i + 1] = t;

        }
        StringBuilder sb = new StringBuilder();
        for (int j = 3; j >= 0; j--)
        {

            if (timeArr[j] > 0)
            {
                sb.append(timeArr[j]);
                sb.append(unitArr[j]);
            }

        }

        return sb.toString();
    }


    public static void printLogStackTrace()
    {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : elements)
        {
            log.info(">>>>Class:[{}], method:[{}], line {}", element.getClassName(), element.getMethodName(),
                    element.getLineNumber());
        }
    }
}
