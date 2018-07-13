package com.xlh.crm.controller;

import java.io.IOException;
import java.util.List;

import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.*;
import com.xlh.crm.dto.mysql.BranchPersonReach;
import com.xlh.crm.dto.mysql.BranchPersonReachShowResp;
import com.xlh.crm.service.DataService;
import com.xlh.crm.service.impl.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: ysl
 * @email:
 * @version: 0.1
 * @create time: 2017/05/05
 * @description:
 */
@Controller
@RequestMapping("/data")
public class DataController {

	@Autowired
	private SessionServiceImpl sessionService;
	
	@Autowired
	private DataService dataService;

	//数据大盘
	@RequestMapping(value = "/keyindex")
	public ModelAndView getKeyindex(ChartReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("data_dashboard");

		//获取数据日期：当前日期的前一天
		String lastDay = CurrentTime.getLastDay().substring(0,10); //格式：yyyy-mm-dd
		String lastDay_mm = lastDay.substring(0,7);
		String rangDate = lastDay_mm.concat("-01").concat("至").concat(lastDay).concat("");
		req.setLastDate(rangDate);

		//获取Dashboard指标
		DashboardIndexShowDTO dashboardIndex = dataService.getDashboardIndex(req);

		//获取当日入库的柱状图形ID
		ChartListRespDTO chartListRespDTO = dataService.getChartCondition(req,"'c1001','c1002','c1003','c1004','c1005','c1006','c1008'");

		//获取当日入库的堆积柱状图形ID
		ChartListRespDTO chartListRespDTO1 = dataService.getChartCondition(req,"'d1001'");

		//获取用户设置生成的json条件和数据
		String chartJsonStr = dataService.getGenChartData(chartListRespDTO);
		System.out.println("String:"+chartJsonStr);

		//获取用户设置生成的json条件和数据
		String chartJsonStr2 = dataService.getStkChartData(chartListRespDTO1);
		System.out.println("String:"+chartJsonStr2);

		modelAndView.addObject("dashboardIndex", dashboardIndex);
		modelAndView.addObject("chartJsonStr", chartJsonStr);
		modelAndView.addObject("chartJsonStr2", chartJsonStr2);
		modelAndView.addObject("rangDate", rangDate);
		modelAndView.addObject("user", sessionService.getUser());
		return modelAndView;
	}

	//报表
	@RequestMapping(value = "/report")
	public ModelAndView getReport(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("data_report");

		String memberType = null;  //用户类型
		memberType = sessionService.getUser().getMemberType();
		req.setMemberType(sessionService.getUser().getMemberType());  //赋值用户类型

		//获取报表数据A
		DataReportRespDTO reportA = dataService.getDataReportA(req);

		//获取报表数据B
		DataReportRespDTO reportB = dataService.getDataReportB(req);

		//获取报表数据C
		DataReportRespDTO reportC = dataService.getDataReportC(req);

		//获取报表数据D
		DataReportRespDTO reportD = dataService.getDataReportD(req);

		//当月拜访部位分布
		DataReportRespOrgDto reportE = dataService.getDataReportE(req);

		//个人分配及触达企业数
		List<BranchPersonReachShowResp> reportF = dataService.getDataReportF(req);



		modelAndView.addObject("reportA", reportA);
		modelAndView.addObject("reportB", reportB);
		modelAndView.addObject("reportC", reportC);
		modelAndView.addObject("reportD", reportD);
		modelAndView.addObject("reportE", reportE);
		modelAndView.addObject("reportF", reportF);
		modelAndView.addObject("user", sessionService.getUser());
		return modelAndView;
	}

	//实时直播间
	@RequestMapping(value = "/realtimedata")
	public ModelAndView getRtData(ChartReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

		ModelAndView modelAndView = new ModelAndView("realtime_data");
		//UserInfoDTO member = sessionService.getUser();
		//req.setCreateMemberId(member.getMemberId());

		//获取数据日期：当前日期的前一天
		String lastDay = CurrentTime.getLastDay().substring(0,10); //格式：yyyy-mm-dd
		String lastDay_mm = lastDay.substring(0,7);
		String rangDate = lastDay_mm.concat("-01").concat("至").concat(lastDay).concat("");
		req.setLastDate(rangDate);

		//获取当日入库的堆积柱状图形ID
		ChartListRespDTO chartListRespDTO1 = dataService.getChartCondition(req,"'d1002'");
		//获取当日入库的折线图形ID
		ChartListRespDTO chartListRespDTO2 = dataService.getChartCondition(req,"'e1001'");
		//获取当日入库的饼图形ID
		ChartListRespDTO chartListRespDTO3 = dataService.getChartCondition(req,"'f1001'");

		//获取用户设置生成的json条件和数据
		String rtJsonStr1 = dataService.getRtChartData1(chartListRespDTO1);
		System.out.println("String:"+rtJsonStr1);

		//获取用户设置生成的json条件和数据
		String rtJsonStr2 = dataService.getRtChartData2(chartListRespDTO2);
		System.out.println("String:"+rtJsonStr2);

		//获取用户设置生成的json条件和数据
		String rtJsonStr3 = dataService.getRtChartData3(chartListRespDTO3);
		System.out.println("String:"+rtJsonStr3);

		modelAndView.addObject("rtJsonStr1", rtJsonStr1);
		modelAndView.addObject("rtJsonStr2", rtJsonStr2);
		modelAndView.addObject("rtJsonStr3", rtJsonStr3);
		modelAndView.addObject("rangDate", rangDate);
		modelAndView.addObject("user", sessionService.getUser());
		return modelAndView;
	}
}
