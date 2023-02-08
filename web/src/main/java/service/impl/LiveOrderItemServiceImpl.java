package service.impl;

import com.github.pagehelper.Page;
import dao.LiveOrderItemDao;
import entity.LiveOrderItem;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import service.LiveOrderItemService;

import javax.annotation.Resource;
import java.awt.print.Pageable;

/**
 * (LiveOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2022-09-02 15:37:47
 */
@Service("liveOrderItemService")
public class LiveOrderItemServiceImpl implements LiveOrderItemService {
    @Resource
    private LiveOrderItemDao liveOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LiveOrderItem queryById(Long id) {
        return this.liveOrderItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param liveOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<LiveOrderItem> queryByPage(LiveOrderItem liveOrderItem, PageRequest pageRequest) {
        long total = this.liveOrderItemDao.count(liveOrderItem);
       return null;
    }

    /**
     * 新增数据
     *
     * @param liveOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public LiveOrderItem insert(LiveOrderItem liveOrderItem) {
        this.liveOrderItemDao.insert(liveOrderItem);
        return liveOrderItem;
    }

    /**
     * 修改数据
     *
     * @param liveOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public LiveOrderItem update(LiveOrderItem liveOrderItem) {
        this.liveOrderItemDao.update(liveOrderItem);
        return this.queryById(liveOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.liveOrderItemDao.deleteById(id) > 0;
    }
}
