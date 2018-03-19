package com.wanma.ims.common.domain;

import com.wanma.ims.common.domain.base.BasicModel;

/**
 * 电桩关系表
 */
public class CompanyChargeRelaDO extends BasicModel {

	private static final long serialVersionUID = -163829460183575058L;

	private Integer indexNum;

	private Long id;// 主键 ref表字段: pk_id

	private Long cpyId;// 合作公司ID ref表字段: cpy_id

	private Integer cpyNumber;// 公司标识

	private Long powerStationId;// 电站ID ref表字段: powerstation_id

	private Long electricPileId;// 电桩ID ref表字段: electricpile_id

	private String electricPileCode;// 桩编码 ref表字段: electricpile_code

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpyId() {
		return cpyId;
	}

	public void setCpyId(Long cpyId) {
		this.cpyId = cpyId;
	}

	public Integer getCpyNumber() {
		return cpyNumber;
	}

	public void setCpyNumber(Integer cpyNumber) {
		this.cpyNumber = cpyNumber;
	}

	public Long getPowerStationId() {
		return powerStationId;
	}

	public void setPowerStationId(Long powerStationId) {
		this.powerStationId = powerStationId;
	}

	public Long getElectricPileId() {
		return electricPileId;
	}

	public void setElectricPileId(Long electricPileId) {
		this.electricPileId = electricPileId;
	}

	public String getElectricPileCode() {
		return electricPileCode;
	}

	public void setElectricPileCode(String electricPileCode) {
		this.electricPileCode = electricPileCode;
	}

	public Integer getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(Integer indexNum) {
		this.indexNum = indexNum;
	}

}