package com.wanma.controller.amap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wanma.model.ElectricMap;
import com.wanma.model.TblPowerstation;
import com.wanma.service.ChargePowerstainService;
import com.wanma.support.common.AccessSuccessResult;
import com.wanma.support.common.FailedResponse;
import com.wanma.support.common.ResultResponse;

@Controller
@RequestMapping("/amap")
public class AmapChargePointController {
	@Autowired
	private ChargePowerstainService amapService;

	/**
	 * 根据充电站id查询电站以及电桩详情
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getChargePointById")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getChargePowerstationById(HttpServletRequest request) {
		String pkPowerstation = request.getParameter("pkPowerstation");
		if (StringUtils.isBlank(pkPowerstation)) {
			return new FailedResponse(1001, "params error").toString();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pkPowerstation", pkPowerstation);
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, String> chargeList;
		Map<String, Object> amapMap;
		chargeList = amapService.getChargePowerstationList(params);
		amapMap = amapService.getAmapChargePowerstation(params);
		data.put("base", chargeList);
		data.put("deep", amapMap);
		return new ResultResponse(data).toString();

	}

	/**
	 * 查询全国范围内的充电点
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/search")
	@ResponseBody
	public String Search(HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isBlank(pageSize) || StringUtils.isBlank(pageNo)) {
			return new FailedResponse(1001, "params error").toString();
		}
		params.put("pageNo", Integer.parseInt(pageNo));
		params.put("pageSize", Integer.parseInt(pageSize));
		List<ElectricMap> mapList;
		mapList = amapService.getPowerstationMapBysearch(params);
		return new AccessSuccessResult(mapList).toString();

	}

}