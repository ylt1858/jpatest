package com.studuyjpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author ylt
 * @date 2021/5/20 10:37
 */
@Entity
@Data
public class People implements Serializable {
    @Id
    private Long id;

    private Integer length;

    private Integer weigh;
}
