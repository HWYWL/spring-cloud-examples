package cn.ac.hwy.springcloud.service;

import cn.ac.hwy.springcloud.entities.Payment;

import java.util.List;

/**
 * @author YI
 * @date 2020/3/14 14:41
 */
public interface PaymentService {
    /**
     * 新增
     */
    int insert(Payment payment);

    /**
     * 删除
     */
    int delete(int id);

    /**
     * 更新
     */
    int update(Payment payment);

    /**
     * 根据主键 id 查询
     */
    Payment load(int id);

    /**
     * 分页查询
     */
    List<Payment> pageList(int offset, int pagesize);
}