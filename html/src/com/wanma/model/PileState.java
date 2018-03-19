package com.wanma.model;

import com.alibaba.fastjson.JSON;

/**
 * 发送电桩状态到e充网
 * Created by zangyaoyi on 2016/12/29.
 */
public class PileState {
    private String pile_code;//充电桩编码
    private Integer inter_no;//电桩上的接口(1 表示 A 口, 2 表示 B 口)
    private Integer inter_type;//充电电流类型(1 交流，2 直流)
    private Integer inter_conn_state;//充电枪连接状态(1:空置，2:未知，3:车连接)
    private Integer inter_work_state;//电桩接口工作状态(1:充电，2:待机，3:故障，4:充电结束,5: 被预约, 6:暂停充电)
    private Integer inter_order_state;//预约状态(1:无预约，2:有预约)
    private Float voltage;//输出电压
    private Float current;//输出电流
    private Integer soc;//当前的 SOC（汽车电量的百分比）
    private Integer fault_code;//故障码 0:急停故障, 1:电表故障，2:接触器故障，3:读卡器故障 ，4:内部过温故障，5:连接器故障，6:绝缘故障，7:其他 无故障则传 7
    private Integer err_code;//错误码(0:电流异常，1:电压异常，2:其他)无错误则传 2
    private Integer res_time;//剩余充电时间，单位分钟。未在充电状态则传 0
    private Integer time;//上报时间（秒格式 Unix 时间戳）

    public static PileState getInstance() {
        String s = "{\"pile_code\":\"1110108217001001\",\"inter_no\":0,\"inter_type\":2,\"inter_conn_state\":3,\"inter_work_state\":2,\"inter_order_state\":1,\"voltage\":5,\"current\":9,\"soc\":21,\"fault_code\":22,\"err_code\":0,\"res_time\":0,\"time\":1480417165,\"elect_address\":\"none\",\"elect_type\":2,\"elect_rate\":0,\"active_power\":16,\"reactive_power\":17,\"active_energy\":18,\"reactive_energy\":19,\"parking_state\":2}";
        return JSON.parseObject(s, PileState.class);
    }

    public static void convertPileState(PileState pileState) {
        String pile_code = pileState.pile_code + "0" + pileState.getInter_no();
        pileState.setPile_code(pile_code);
        Integer inter_type = pileState.getInter_type();
        if (5 == inter_type) {
            inter_type = 2;
        } else {
            inter_type = 1;
        }
        pileState.setInter_type(inter_type);
        Integer inter_work_state = pileState.getInter_work_state();
        Integer inter_conn_state = pileState.getInter_conn_state();
        pileState.setInter_order_state(1);
        pileState.setInter_conn_state(2);
        if (0 == inter_work_state) {
            inter_work_state = 7;
        } else {
            pileState.setInter_conn_state(1);
            if (0 == inter_conn_state) {
                inter_work_state = 2;
            } else if (3 == inter_conn_state) {
                inter_work_state = 5;
                pileState.setInter_order_state(2);
            } else if (6 == inter_conn_state || 17 == inter_conn_state) {
                inter_work_state = 1;
                pileState.setInter_conn_state(3);
            } else {
                inter_work_state = 3;
                pileState.setInter_conn_state(2);
            }
        }
        pileState.setInter_work_state(inter_work_state);
        pileState.setSoc(0);
        pileState.setFault_code(7);
        pileState.setErr_code(2);
        pileState.setRes_time(0);
        pileState.setTime((int) (System.currentTimeMillis() / 1000));

    }

    public String getPile_code() {
        return pile_code;
    }

    public void setPile_code(String pile_code) {
        this.pile_code = pile_code;
    }

    public Integer getInter_no() {
        return inter_no;
    }

    public void setInter_no(Integer inter_no) {
        this.inter_no = inter_no;
    }

    public Integer getInter_type() {
        return inter_type;
    }

    public void setInter_type(Integer inter_type) {
        this.inter_type = inter_type;
    }

    public Integer getInter_conn_state() {
        return inter_conn_state;
    }

    public void setInter_conn_state(Integer inter_conn_state) {
        this.inter_conn_state = inter_conn_state;
    }

    public Integer getInter_work_state() {
        return inter_work_state;
    }

    public void setInter_work_state(Integer inter_work_state) {
        this.inter_work_state = inter_work_state;
    }

    public Integer getInter_order_state() {
        return inter_order_state;
    }

    public void setInter_order_state(Integer inter_order_state) {
        this.inter_order_state = inter_order_state;
    }

    public Float getVoltage() {
        return voltage;
    }

    public void setVoltage(Float voltage) {
        this.voltage = voltage;
    }

    public Float getCurrent() {
        return current;
    }

    public void setCurrent(Float current) {
        this.current = current;
    }

    public Integer getSoc() {
        return soc;
    }

    public void setSoc(Integer soc) {
        this.soc = soc;
    }

    public Integer getFault_code() {
        return fault_code;
    }

    public void setFault_code(Integer fault_code) {
        this.fault_code = fault_code;
    }

    public Integer getErr_code() {
        return err_code;
    }

    public void setErr_code(Integer err_code) {
        this.err_code = err_code;
    }

    public Integer getRes_time() {
        return res_time;
    }

    public void setRes_time(Integer res_time) {
        this.res_time = res_time;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}