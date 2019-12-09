package com.hcl.warehouse.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.hcl.warehouse.sys.entity.SysDept;
import com.hcl.warehouse.sys.mapper.SysDeptMapper;
import com.hcl.warehouse.sys.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liangHuang
 * @since 2019-12-09
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
    @Override
    public SysDept getOne(Wrapper<SysDept> queryWrapper, boolean throwEx) {
        return super.getOne(queryWrapper, throwEx);
    }


    @Override
    public boolean update(SysDept entity, Wrapper<SysDept> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
