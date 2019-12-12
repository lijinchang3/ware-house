package com.hcl.warehouse.sys.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author :liangHuang.
 * @Date :2019/12/11 15:11
 * @Description :xxl任务调度配置
 */
/*@Configuration*/
@ConfigurationProperties(value = "xxl.job")
@EnableConfigurationProperties({XxlJobConfiguration.class})
@Setter
public class XxlJobConfiguration {

    /**
     * 调度中心部署跟地址 [选填]：如调度中心集群部署存在多个地址则用逗号分隔。
     * 执行器将会使用该地址进行"执行器心跳注册"和"任务结果回调"；为空则关闭自动注册；
     */
    private String address;
    /**
     * 执行器通讯TOKEN [选填]：非空时启用
     */
    private String accessToken;
    /**
     *执行器AppName [选填]：执行器心跳注册分组依据；为空则关闭自动注册
     */
    private String appName;
    /**
     *执行器IP [选填]：默认为空表示自动获取IP，多网卡时可手动设置指定IP，该IP不会绑定Host仅作为通讯实用；地址信息用于 "执行器注册" 和 "调度中心请求并触发任务"；
     */
    private String ip;
    /**
     *  执行器端口号 [选填],小于等于0则自动获取；默认端口为9999，单机部署多个执行器时，注意要配置不同执行器端口
     */
    private int port;
    /**
     *执行器日志文件保存天数 [选填],过期日志自动清理, 限制值大于等于3时生效; 否则, 如-1, 关闭自动清理功能；
     */
    private int logretentiondays;
    /**
     * 执行器运行日志文件存储磁盘路径 [选填],需要对该路径拥有读写权限；为空则使用默认路径
     */
    private String logPath;

    /**
     * 配置xxl执行器初始化
     * @return
     */
    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor getXxlJobSpringExecutor(){
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(address);
        xxlJobSpringExecutor.setAppName(appName);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logretentiondays);
        return xxlJobSpringExecutor;
    }
}
