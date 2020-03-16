package cn.ac.hwy.springcloud.service.impl;

import cn.ac.hwy.springcloud.dao.PaymentDao;
import cn.ac.hwy.springcloud.entities.Payment;
import cn.ac.hwy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YI
 * @date 2020/3/14 14:43
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentMapper;

    @Override
    public int insert(Payment payment) {
        // valid
        if (payment == null) {
            return 0;
        }

        return paymentMapper.insert(payment);
    }

    @Override
    public int delete(int id) {
        return paymentMapper.delete(id);
    }

    @Override
    public int update(Payment payment) {
        return paymentMapper.update(payment);
    }

    @Override
    public Payment load(int id) {
        return paymentMapper.load(id);
    }

    @Override
    public List<Payment> pageList(int offset, int pagesize) {
        return paymentMapper.pageList(offset, pagesize);
    }
}