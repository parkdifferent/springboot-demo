package controller;

import com.github.pagehelper.Page;
import entity.LiveOrderItem;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.LiveOrderItemService;

import javax.annotation.Resource;

/**
 * (LiveOrderItem)表控制层
 *
 * @author makejava
 * @since 2022-09-05 10:19:16
 */
@RestController
@RequestMapping("liveOrderItem")
public class LiveOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private LiveOrderItemService liveOrderItemService;

    /**
     * 分页查询
     *
     * @param liveOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<LiveOrderItem>> queryByPage(LiveOrderItem liveOrderItem, PageRequest pageRequest) {
        return ResponseEntity.ok(this.liveOrderItemService.queryByPage(liveOrderItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<LiveOrderItem> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.liveOrderItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param liveOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<LiveOrderItem> add(LiveOrderItem liveOrderItem) {
        return ResponseEntity.ok(this.liveOrderItemService.insert(liveOrderItem));
    }

    /**
     * 编辑数据
     *
     * @param liveOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<LiveOrderItem> edit(LiveOrderItem liveOrderItem) {
        return ResponseEntity.ok(this.liveOrderItemService.update(liveOrderItem));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.liveOrderItemService.deleteById(id));
    }

}

