package com.wei.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 分组保存入参
 * @author wei
 */
@Data
public class ShortLinkGroupSortReqDTO {

    /**
     * 分组ID
     */
    private String gid;

    /**
     * 排序
     */
    private Integer sortOrder;

}
