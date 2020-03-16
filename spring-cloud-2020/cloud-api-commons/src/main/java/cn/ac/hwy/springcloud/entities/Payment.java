package cn.ac.hwy.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付类型
 *
 * @author huangwenyi
 * @date 2020-02-18 17:22
 */
@Data
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 编号
     */
    private String serial;

    public Payment() {
    }

}