package com.wei.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wei.shortlink.admin.common.database.BaseDO;
import lombok.*;

/**
 * @author wei
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_group")
public class GroupDO extends BaseDO {

    /**
     * ID
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组的用户名
     */
    private String username;

    /**
     * 分组排序
     */
    private Integer sortOrder;

}
