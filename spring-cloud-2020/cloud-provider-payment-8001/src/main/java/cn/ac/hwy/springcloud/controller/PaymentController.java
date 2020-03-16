package cn.ac.hwy.springcloud.controller;

import cn.ac.hwy.springcloud.entities.Payment;
import cn.ac.hwy.springcloud.utils.MessageResult;
import cn.ac.hwy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单表
 *
 * @author YI
 * @date 2020/03/14
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * [新增]
     *
     * @author YI
     * @date 2020/03/14
     **/
    @PostMapping("/insert")
    public MessageResult<String> insert(Payment payment) {
        int insert = paymentService.insert(payment);

        return MessageResult.ok(insert);
    }

    /**
     * [刪除]
     *
     * @author YI
     * @date 2020/03/14
     **/
    @PostMapping("/delete")
    public MessageResult<String> delete(int id) {
        int delete = paymentService.delete(id);

        return MessageResult.ok(delete);
    }

    /**
     * [更新]
     *
     * @author YI
     * @date 2020/03/14
     **/
    @PostMapping("/update")
    public MessageResult<String> update(Payment payment) {
        int update = paymentService.update(payment);

        return MessageResult.ok(update);
    }

    /**
     * [查询] 根据主键 id 查询
     *
     * @author YI
     * @date 2020/03/14
     **/
    @PostMapping("/load")
    public MessageResult<String> load(int id) {
        Payment payment = paymentService.load(id);

        return MessageResult.ok(payment);
    }

    /**
     * [查询] 分页查询
     *
     * @author YI
     * @date 2020/03/14
     **/
    @PostMapping("/pageList")
    public MessageResult pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                  @RequestParam(required = false, defaultValue = "10") int pagesize) {
        List<Payment> payments = paymentService.pageList(offset, pagesize);

        return MessageResult.ok(payments);
    }

}