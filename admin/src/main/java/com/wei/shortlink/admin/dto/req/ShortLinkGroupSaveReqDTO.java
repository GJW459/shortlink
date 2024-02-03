package com.wei.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 分组保存入参
 * @author wei
 */
@Data
public class ShortLinkGroupSaveReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

}
