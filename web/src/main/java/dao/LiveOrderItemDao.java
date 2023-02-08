package dao;

import entity.LiveOrderItem;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

/**
 * (LiveOrderItem)表数据库访问层
 *
 * @author makejava
 * @since 2022-09-02 14:37:41
 */
public interface LiveOrderItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LiveOrderItem queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param liveOrderItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<LiveOrderItem> queryAllByLimit(LiveOrderItem liveOrderItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param liveOrderItem 查询条件
     * @return 总行数
     */
    long count(LiveOrderItem liveOrderItem);

    /**
     * 新增数据
     *
     * @param liveOrderItem 实例对象
     * @return 影响行数
     */
    int insert(LiveOrderItem liveOrderItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<LiveOrderItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<LiveOrderItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<LiveOrderItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<LiveOrderItem> entities);

    /**
     * 修改数据
     *
     * @param liveOrderItem 实例对象
     * @return 影响行数
     */
    int update(LiveOrderItem liveOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

