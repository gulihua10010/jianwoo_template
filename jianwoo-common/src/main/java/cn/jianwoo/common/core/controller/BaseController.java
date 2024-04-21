package cn.jianwoo.common.core.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.common.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.core.domain.AjaxResult;
import cn.jianwoo.common.core.domain.model.LoginUser;
import cn.jianwoo.common.core.page.PageDomain;
import cn.jianwoo.common.core.page.TableDataInfo;
import cn.jianwoo.common.core.page.TableSupport;
import cn.jianwoo.common.utils.DateUtils;
import cn.jianwoo.common.utils.PageUtils;
import cn.jianwoo.common.utils.SecurityUtils;
import cn.jianwoo.common.utils.StringUtils;
import cn.jianwoo.common.utils.sql.SqlUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * web层通用数据处理
 * 
 * @author jianwoo
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;
    @Autowired
    protected ServletContext application;

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text)
            {
                setValue(DateUtils.parseDate(text));
            }
        });
    }


    /**
     * 设置请求分页数据
     */
    protected Page startPage()
    {
        return PageUtils.startPage();
    }


    /**
     * 设置请求排序数据
     */
    protected void startOrderBy()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        if (StringUtils.isNotEmpty(pageDomain.getOrderBy()))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.orderBy(orderBy);
        }
    }


    /**
     * 清理分页的线程变量
     */
    protected void clearPage()
    {
        PageUtils.clearPage();
    }


    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected <T> TableDataInfo<T> getDataTable(List<T> list)
    {
        TableDataInfo<T> rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg(MessageUtils.message("query.success"));
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }


    protected <T> TableDataInfo<T> getDataTable(List<T> list, Page page)
    {
        TableDataInfo<T> rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg(MessageUtils.message("query.success"));
        rspData.setRows(list);
        rspData.setTotal(page.getTotal());
        return rspData;
    }


    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }


    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }


    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }


    /**
     * 返回成功消息
     */
    public AjaxResult success(Object data)
    {
        return AjaxResult.success(data);
    }


    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }


    /**
     * 返回警告消息
     */
    public AjaxResult warn(String message)
    {
        return AjaxResult.warn(message);
    }


    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }


    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected R toRes(int rows)
    {
        return rows > 0 ? ok() : fail();
    }


    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected R toRes(boolean result)
    {
        return result ? ok() : fail();
    }


    /**
     * 返回成功
     */
    public R ok()
    {
        return R.ok();
    }


    /**
     * 返回失败消息
     */
    public R fail()
    {
        return R.fail();
    }


    /**
     * 返回成功消息
     */
    public R okMsg(String message)
    {
        return R.ok(message);
    }


    /**
     * 返回成功消息
     */
    public <T> R<T> ok(T data)
    {
        return R.ok(data);
    }


    /**
     * 返回失败消息
     */
    public R fail(String message)
    {
        return R.fail(message);
    }


    /**
     * 页面跳转
     */
    public String redirect(String url)
    {
        return StringUtils.format("redirect:{}", url);
    }


    /**
     * 获取用户缓存信息
     */
    public LoginUser getLoginUser()
    {
        return SecurityUtils.getLoginUser();
    }


    /**
     * 获取登录用户id
     */
    public Long getUserId()
    {
        return getLoginUser().getUserId();
    }


    /**
     * 获取登录部门id
     */
    public Long getDeptId()
    {
        return getLoginUser().getDeptId();
    }


    /**
     * 获取登录用户名
     */
    public String getUsername()
    {
        return getLoginUser().getUsername();
    }
}
