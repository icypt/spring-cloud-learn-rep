package com.icypt.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class PayStream implements Serializable {
    private Long payStreamId;
    private String payStreamNo;
    private String payStreamAmt;
    private Long orderId;
    private String payStreamStatus;
    private Date payStreamCreateTime;

}
