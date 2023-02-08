package service.impl;

import entity.BdLivePlanProduct;
import dao.BdLivePlanProductDao;
import service.BdLivePlanProductService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BdLivePlanProduct)表服务实现类
 *
 * @author makejava
 * @since 2022-11-02 15:10:24
 */
@Service("bdLivePlanProductService")
public class BdLivePlanProductServiceImpl implements BdLivePlanProductService {
    @Resource
    private BdLivePlanProductDao bdLivePlanProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BdLivePlanProduct queryById(Long id) {
        return this.bdLivePlanProductDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bdLivePlanProduct 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BdLivePlanProduct> queryByPage(BdLivePlanProduct bdLivePlanProduct, PageRequest pageRequest) {
        long total = this.bdLivePlanProductDao.count(bdLivePlanProduct);
        return new PageImpl<>(this.bdLivePlanProductDao.queryAllByLimit(bdLivePlanProduct, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bdLivePlanProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BdLivePlanProduct insert(BdLivePlanProduct bdLivePlanProduct) {
        this.bdLivePlanProductDao.insert(bdLivePlanProduct);
        return bdLivePlanProduct;
    }

    /**
     * 修改数据
     *
     * @param bdLivePlanProduct 实例对象
     * @return 实例对象
     */
    @Override
    public BdLivePlanProduct update(BdLivePlanProduct bdLivePlanProduct) {
        this.bdLivePlanProductDao.update(bdLivePlanProduct);
        return this.queryById(bdLivePlanProduct.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bdLivePlanProductDao.deleteById(id) > 0;
    }
}
