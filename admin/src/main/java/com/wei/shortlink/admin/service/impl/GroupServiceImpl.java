package com.wei.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.shortlink.admin.common.biz.UserContext;
import com.wei.shortlink.admin.dao.entity.GroupDO;
import com.wei.shortlink.admin.dao.mapper.GroupMapper;
import com.wei.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.wei.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.wei.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.wei.shortlink.admin.service.GroupService;
import com.wei.shortlink.admin.toolkit.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wei
 */
@Service
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    @Override
    public void saveGroup(ShortLinkGroupSaveReqDTO requestParam) {
        String gid;
        do {
            gid = RandomUtils.generateRandom();
        } while (hasGid(gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(requestParam.getName())
                .username(UserContext.getUsername())
                .sortOrder(0).build();
        baseMapper.insert(groupDO);
    }

    @Override
    public void updateGroup(ShortLinkGroupSaveReqDTO requestParam) {
        LambdaUpdateWrapper<GroupDO> wrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getGid, requestParam.getGid())
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        baseMapper.update(BeanUtil.toBean(requestParam, GroupDO.class), wrapper);
    }

    @Override
    public void deleteGroup(String gid) {
        LambdaUpdateWrapper<GroupDO> wrapper = Wrappers.lambdaUpdate(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        GroupDO groupDO = new GroupDO();
        groupDO.setDelFlag(1);
        baseMapper.update(groupDO, wrapper);
    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0)
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getUpdateTime);
        List<GroupDO> groupDOS = baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOS, ShortLinkGroupRespDTO.class);
    }

    @Override
    public void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam) {
        requestParam.forEach((each)->{
            LambdaUpdateWrapper<GroupDO> wrapper = Wrappers.lambdaUpdate(GroupDO.class)
                    .eq(GroupDO::getGid, each.getGid())
                    .eq(GroupDO::getUsername, UserContext.getUsername())
                    .eq(GroupDO::getDelFlag, 0);
            GroupDO groupDO = GroupDO.builder()
                    .sortOrder(each.getSortOrder())
                    .build();
            baseMapper.update(groupDO,wrapper);
        });
    }

    private boolean hasGid(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        GroupDO groupDO = baseMapper.selectOne(queryWrapper);
        return groupDO != null;
    }
}
