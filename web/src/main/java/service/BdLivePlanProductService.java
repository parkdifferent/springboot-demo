package service;

import entity.BdLivePlanProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BdLivePlanProduct)表服务接口
 *
 * @author makejava
 * @since 2022-11-02 15:10:24
 */
public interface BdLivePlanProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BdLivePlanProduct queryById(Long id);

    /**
     * 分页查询
     *
     * @param bdLivePlanProduct 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BdLivePlanProduct> queryByPage(BdLivePlanProduct bdLivePlanProduct, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bdLivePlanProduct 实例对象
     * @return 实例对象
     */
    BdLivePlanProduct insert(BdLivePlanProduct bdLivePlanProduct);

    /**
     * 修改数据
     *
     * @param bdLivePlanProduct 实例对象
     * @return 实例对象
     */
    BdLivePlanProduct update(BdLivePlanProduct bdLivePlanProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
