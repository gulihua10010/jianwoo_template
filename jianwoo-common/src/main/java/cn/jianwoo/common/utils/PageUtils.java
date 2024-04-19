package cn.jianwoo.common.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.jianwoo.common.core.page.PageDomain;
import cn.jianwoo.common.core.page.TableSupport;
import cn.jianwoo.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 * 
 * @author jianwoo
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static Page startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        return PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }


    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
