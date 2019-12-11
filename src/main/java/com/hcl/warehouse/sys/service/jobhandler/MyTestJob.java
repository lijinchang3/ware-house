package com.hcl.warehouse.sys.service.jobhandler;

import cn.hutool.core.date.DateUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @Author :liangHuang.
 * @Date :2019/12/11 15:45
 * @Description :
 */
@JobHandler(value = "ware-house-test")
@Component
public class MyTestJob extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        System.out.println("仓库管理系统----执行了我配置的任务！！！！！！！！！！" + DateUtil.now());
        System.out.println("这是传递过来的参数:" + s);
        return ReturnT.SUCCESS;
    }

    @Override
    public void init() {
        System.out.println("项目启动了执行了init方法↑↑↑→→←");
    }
}
