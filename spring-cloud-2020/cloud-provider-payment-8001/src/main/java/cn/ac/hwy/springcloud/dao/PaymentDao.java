package cn.ac.hwy.springcloud.dao;

import cn.ac.hwy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YI
 * @date 2020/3/14 14:32
 */
@Mapper
@Repository
public interface PaymentDao {
    /**
     * [新增]
     * @author YI
     * @date 2020/03/14
     **/
    int insert(Payment payment);

    /**
     * [刪除]
     * @author YI
     * @date 2020/03/14
     **/
    int delete(int id);

    /**
     * [更新]
     * @author YI
     * @date 2020/03/14
     **/
    int update(Payment payment);

    /**
     * [查询] 根据主键 id 查询
     * @author YI
     * @date 2020/03/14
     **/
    Payment load(int id);

    /**
     * [查询] 分页查询
     * @author YI
     * @date 2020/03/14
     **/
    List<Payment> pageList(int offset, int pagesize);

    /**
     * [查询] 分页查询 count
     * @author YI
     * @date 2020/03/14
     **/
    int pageListCount(int offset,int pagesize);
}