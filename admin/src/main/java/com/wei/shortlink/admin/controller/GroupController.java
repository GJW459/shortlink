package com.wei.shortlink.admin.controller;

import com.wei.shortlink.admin.common.convention.result.Result;
import com.wei.shortlink.admin.common.convention.result.Results;
import com.wei.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.wei.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.wei.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.wei.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分组管理控制层
 * @author wei
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 保存分组
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.saveGroup(requestParam);
        return Results.success();
    }

    /**
     * 修改分组
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.updateGroup(requestParam);
        return Results.success();
    }

    /**
     * 删除分组
     */
    @DeleteMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestParam("gid") String gid){
        groupService.deleteGroup(gid);
        return Results.success();
    }

    /**
     * 查询分组集合（短链接分组最多10个）
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup(){
        return Results.success(groupService.listGroup());
    }

    /**
     * 短链接分组排序
     */
    @PostMapping("/api/short-link/admin/v1/group/sort")
    public Result<Void> sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam){
        groupService.sortGroup(requestParam);
        return Results.success();
    }
}
