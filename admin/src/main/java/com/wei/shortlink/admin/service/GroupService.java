package com.wei.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.shortlink.admin.dao.entity.GroupDO;
import com.wei.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.wei.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.wei.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * @author wei
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 保存分组
     * @param requestParam 保存分组req数据
     */
    void saveGroup(ShortLinkGroupSaveReqDTO requestParam);

    /**
     * 修改分组
     * @param requestParam 修改分组req数据
     */
    void updateGroup(ShortLinkGroupSaveReqDTO requestParam);

    /**
     * 删除分组
     * @param gid 分组gid
     */
    void deleteGroup(String gid);

    /**
     * 查询分组
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 短链接分组排序
     * @param requestParam 请求参数
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
