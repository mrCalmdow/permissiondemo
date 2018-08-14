package com.flchen.permissiondemo.common.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.io.Serializable;

/**
 * @author Beldon.
 * @create 2017-11-3 下午2:26
 */
@Data
public abstract class BaseDO implements Serializable {
    @Id
    protected String id;

    private String createdBy;
    private Long createdTime;
    private String updatedBy;
    private Long updatedTime;

    @Version
    private Integer version;

}
