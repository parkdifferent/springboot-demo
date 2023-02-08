package service;

import com.github.pagehelper.Page;
import entity.LiveOrderItem;
import org.springframework.data.domain.PageRequest;

/**
 * (LiveOrderItem)表服务接口
 *
 * @author makejava
 * @since 2022-09-02 15:37:47
 */
public interface LiveOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LiveOrderItem queryById(Long id);

    /**
     * 分页查询
     *
     * @param liveOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<LiveOrderItem> queryByPage(LiveOrderItem liveOrderItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param liveOrderItem 实例对象
     * @return 实例对象
     */
    LiveOrderItem insert(LiveOrderItem liveOrderItem);

    /**
     * 修改数据
     *
     * @param liveOrderItem 实例对象
     * @return 实例对象
     */
    LiveOrderItem update(LiveOrderItem liveOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
