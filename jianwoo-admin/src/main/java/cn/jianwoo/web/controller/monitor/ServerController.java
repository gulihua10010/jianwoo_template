package cn.jianwoo.web.controller.monitor;

import cn.jianwoo.framework.web.domain.SystemServer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.jianwoo.common.core.domain.AjaxResult;

/**
 * 服务器监控
 * 
 * @author jianwoo
 */
@RestController("systemServerController")
@RequestMapping("/monitor/server")
public class ServerController
{
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public AjaxResult getInfo() throws Exception
    {
        SystemServer systemServer = new SystemServer();
        systemServer.copyTo();
        return AjaxResult.success(systemServer);
    }
}
