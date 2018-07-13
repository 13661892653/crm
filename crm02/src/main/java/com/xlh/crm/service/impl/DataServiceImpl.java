package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.itemstyle.Normal;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.*;
import com.xlh.crm.dto.mysql.BranchPersonReach;
import com.xlh.crm.dto.mysql.BranchPersonReachShowResp;
import com.xlh.crm.mapper.DataMapper;
import com.xlh.crm.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ysl on 2017/05/10.
 */
@Service
public class DataServiceImpl implements DataService {


    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private SessionServiceImpl sessionService;

    //获取Dashboard指标
    @Override
    public DashboardIndexShowDTO getDashboardIndex(ChartReqDTO req){
        DashboardIndexShowDTO dashboardIndexShowDTO = dataMapper.getDashboardIndex(req);

        return dashboardIndexShowDTO;
    }

    //获取报表数据A
    @Override
    public DataReportRespDTO getDataReportA(PageReqDTO req){
        DataReportRespDTO respDTO = new DataReportRespDTO();
        String parDate = CurrentTime.getLastDay().substring(0,10);  //当期日期的前一天
        if(req.getTimeBegin().equals("all")){
            req.setTimeBegin(parDate);
        }
        if(req.getTimeEnd().equals("all")){
            req.setTimeEnd(parDate);
        }
        respDTO.setReqParams(req);
        List<DataReportShowDTO> dtos = dataMapper.getDataReportA(req);
        respDTO.setDataReportContents(dtos);
        return respDTO;
    }

    //获取报表数据B
    @Override
    public DataReportRespDTO getDataReportB(PageReqDTO req){
        DataReportRespDTO respDTO = new DataReportRespDTO();
        respDTO.setReqParams(req);
        List<DataReportShowDTO> dtos = dataMapper.getDataReportB(req);
        respDTO.setDataReportContents(dtos);
        return respDTO;
    }

    //获取报表数据C
    @Override
    public DataReportRespDTO getDataReportC(PageReqDTO req){
        DataReportRespDTO respDTO = new DataReportRespDTO();
        respDTO.setReqParams(req);
        List<DataReportShowDTO> dtos = dataMapper.getDataReportC(req);
        respDTO.setDataReportContents(dtos);
        return respDTO;
    }

    //获取报表数据D
    @Override
    public DataReportRespDTO getDataReportD(PageReqDTO req){
        DataReportRespDTO respDTO = new DataReportRespDTO();
        respDTO.setReqParams(req);
        List<DataReportShowDTO> dtos = dataMapper.getDataReportD(req);
        respDTO.setDataReportContents(dtos);
        return respDTO;
    }


    //获取报表数据E
    public DataReportRespOrgDto getDataReportE(PageReqDTO req){
        DataReportRespOrgDto respDTO = new DataReportRespOrgDto();
        respDTO.setReqParams(req);
        List<DataReportShowOrgDto> dtos = dataMapper.getDataReportE(req);
        DataReportShowOrgDto dataReportShowOrgDto=dataMapper.getDataReportESum(req);
        if(dataReportShowOrgDto==null){
            dataReportShowOrgDto=new DataReportShowOrgDto();
        }
        respDTO.setDataReportContents(dtos);
        respDTO.setDataReportShowOrgDto(dataReportShowOrgDto);
        return respDTO;
    }

    //个人分配及触达企业数
    public List<BranchPersonReachShowResp> getDataReportF(PageReqDTO req){
        DataReportRespOrgDto respDTO = new DataReportRespOrgDto();
        respDTO.setReqParams(req);
        List<BranchPersonReach> list = dataMapper.getDataReportF(req);
        List<BranchPersonReachShowResp> branchPersonReachShowRespList=new ArrayList<>();
        BranchPersonReachShowResp branchPersonReachShowResp=new BranchPersonReachShowResp();
        for(int i=0;i<list.size();i++){
            if(i==0){
                branchPersonReachShowResp.addBranchPersonReachList(list.get(i));
                branchPersonReachShowRespList.add(branchPersonReachShowResp);
            }else{
                if(list.get(i).getFavUserId()==list.get(i-1).getFavUserId()){
                    branchPersonReachShowResp=branchPersonReachShowRespList.get(branchPersonReachShowRespList.size()-1);
                    branchPersonReachShowResp.addBranchPersonReachList(list.get(i));
                }else{
                    branchPersonReachShowResp=new BranchPersonReachShowResp();
                    branchPersonReachShowResp.addBranchPersonReachList(list.get(i));
                    branchPersonReachShowRespList.add(branchPersonReachShowResp);
                }
            }
        }
        List<BranchPersonReach> blist=new ArrayList<>();
        for(int i=0;i<branchPersonReachShowRespList.size();i++){
            branchPersonReachShowRespList.get(i).setCompany(branchPersonReachShowRespList.get(i).getBranchPersonReachList().get(0).getCompany());
            branchPersonReachShowRespList.get(i).setFavUserList(branchPersonReachShowRespList.get(i).getBranchPersonReachList().get(0).getFavUserList());
            branchPersonReachShowRespList.get(i).setRowSpan(new Integer(branchPersonReachShowRespList.get(i).getBranchPersonReachList().size()));
            blist=branchPersonReachShowRespList.get(i).getBranchPersonReachList();
            Integer sum=0;
            for(int j=0;j<blist.size();j++){
                sum+=blist.get(j).getWeekDist();
            }
            branchPersonReachShowRespList.get(i).setDistNum(sum);
        }
        return branchPersonReachShowRespList;
    }
    //获取图形ID和设置条件
    @Override
    public ChartListRespDTO getChartCondition(ChartReqDTO req,String chartId){
        ChartListRespDTO chartListRespDTO = new ChartListRespDTO();
        chartListRespDTO.setReqParams(req);
        List<ChartShowDTO> dtos = dataMapper.getChartCondition(req,chartId);
        chartListRespDTO.setChartListContents(dtos);

        return chartListRespDTO;
    }

    //非实时：柱状图
    @Override
    public String getGenChartData(ChartListRespDTO chartListRespDTO){

        int parSize = 0;
        parSize = chartListRespDTO.getChartListContents().size();

        String chartId = null;
        JSONArray jsonArray = new JSONArray();
        String chartOptionStr = null;
        for(int i = 0;i < parSize;i++) {
            String jsonCondStr = null;
            String jsonChartData = null;
            int chartDataRecCnt = 0;
            chartId = chartListRespDTO.getChartListContents().get(i).getChartId();
            System.out.println("chartId:"+chartId);

            //图形数据
            String chartOptionJson = null;

            //条件设置字符串规则：chartId:xxxx;dataBase:xlh_crm;dataTable:dws_yrpt;title:一融产品分析;toolBox:restore,save;toolTip:Y;chartType:Bar;xyShowType:X;demEn:ds;demCn:日期;idxEn:yzqys,rzfhzts;idxCn:优质企业数,入驻孵化载体数;
            //获取图形设置条件
            jsonCondStr = chartListRespDTO.getChartListContents().get(i).getSettingConditions();
            //String jsonStr = "chartId:xxxx;dataTable:dws_yrpt;demEn:ds,area;idxEn:yzqys,rzfhzts;";

            String[] str = jsonCondStr.split(";");
            String title = str[3].substring(str[3].indexOf(":") + 1, str[3].length()); //获取title
            String[] legend = str[11].substring(str[11].indexOf(":") + 1, str[11].length()).split(","); //获取legend（转换成字符串数组）

            //获取图形数据DTO
            ChartShowDTO chartShowDTO= dataMapper.getChartData(chartId);
            chartDataRecCnt = chartShowDTO.getRecCnt();

            if (chartDataRecCnt >0) {
                jsonChartData = chartShowDTO.getChartData(); //获取图形数据Json串
                String[] datastr = jsonChartData.split(";");
                String[] demdata = datastr[0].substring(datastr[0].indexOf(":") + 1, datastr[0].length()).split(","); //获取维度数据（转换成字符串数组）
                String[] idxdata1 = datastr[1].substring(datastr[1].indexOf(":") + 1, datastr[1].length()).split(","); //获取指标数据（转换成字符串数组）
                //String[] idxdata2 = datastr[2].substring(datastr[2].indexOf(":")+1,datastr[2].length()).split(","); //获取指标数据（转换成字符串数组）

                Option option = new Option();
                //设置标题
                option.title().text(title);
                //数据标签
                option.tooltip().trigger(Trigger.axis);
                //设置图例
                option.legend(legend);
                //工具箱
                option.toolbox().show(true).feature(Tool.saveAsImage);
                option.calculable(true);
                //------------------图类型设定-------------------------//
                //X轴设置
                option.xAxis(new ValueAxis());
                //Y轴设置
                option.yAxis(new CategoryAxis().data(demdata));
                //指标值系列
                Bar bar1 = new Bar(legend[0]);

                //设置显示图上面的数据
                Normal normal = new Normal();
                normal.setShow(true);
                normal.setPosition(Position.right);
                ItemStyle itemStyle1 = new ItemStyle();
                itemStyle1.setNormal(normal);
                bar1.setLabel(itemStyle1); //label: {normal: {show: true,position: 'insideTop'}}

                List<String> list1 = Arrays.asList(idxdata1);
                bar1.setData(list1);

                /*Bar bar2 = new Bar(legend[1]);
                List<String> list2 = Arrays.asList(idxdata2);
                bar2.setData(list2);*/

                option.series(bar1);
                chartOptionJson = GsonUtil.prettyFormat(option);

                JSONObject.parseObject(chartOptionJson);
                jsonArray.add(JSONObject.parseObject(chartOptionJson));

                chartOptionStr = jsonArray.toString();
            }
        }
        return chartOptionStr;
    }

    //非实时：堆积柱状图
    @Override
    public String getStkChartData(ChartListRespDTO chartListRespDTO){

        int parSize = 0;
        parSize = chartListRespDTO.getChartListContents().size();

        String chartId = null;
        JSONArray jsonArray = new JSONArray();
        String chartOptionStr = null;
        for(int i = 0;i < parSize;i++) {
            String jsonChartData = null;
            int chartDataRecCnt = 0;
            chartId = chartListRespDTO.getChartListContents().get(i).getChartId();
            System.out.println("chartId:"+chartId);

            //图形数据
            String chartOptionJson = null;

            //获取图形数据DTO
            ChartShowDTO chartShowDTO= dataMapper.getChartData(chartId);
            chartDataRecCnt = chartShowDTO.getRecCnt();

            if (chartDataRecCnt >0) {

                String[] str = chartShowDTO.getChartData().split(";");
                String title = str[0].substring(str[0].indexOf(":") + 1, str[0].length()); //获取title
                String[] legend = str[1].substring(str[1].indexOf(":") + 1, str[1].length()).split(","); //获取legend（转换成字符串数组）
                String[] categoryData = str[2].substring(str[2].indexOf(":") + 1, str[2].length()).split(","); //获取图形category
                jsonChartData = str[3].substring(str[3].indexOf(":") + 1, str[3].length()); //获取图形series数据Json串
                System.out.println("categoryData:"+categoryData);
                String[] data = jsonChartData.split("\\|")[0].split(","); //获取图形series数据
                String[] data1 = jsonChartData.split("\\|")[1].split(","); //获取图形series数据
                String[] data2 = jsonChartData.split("\\|")[2].split(","); //获取图形series数据

                Option option = new Option();
                option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.shadow);
                //设置标题
                option.title().text(title);
                //设置图例
                option.legend(legend);
                //工具箱
                option.toolbox().show(true).feature(Tool.saveAsImage);
                option.calculable(true);
                //------------------图类型设定-------------------------//
                option.yAxis(new CategoryAxis().data(categoryData));
                option.xAxis(new ValueAxis());
                //指标值系列
                Bar bar = new Bar("企业");
                bar.stack("总量");
                bar.itemStyle().normal().label().show(true).position("inside");
                List<String> list0 = Arrays.asList(data);
                bar.setData(list0);

                Bar bar2 = new Bar("非企业");
                bar2.stack("总量");
                bar2.itemStyle().normal().label().show(true).position("inside");
                List<String> list1 = Arrays.asList(data1);
                bar2.setData(list1);

                Bar bar3 = new Bar("政府");
                bar3.stack("总量");
                bar3.itemStyle().normal().label().show(true).position("inside");
                List<String> list2 = Arrays.asList(data2);
                bar3.setData(list2);

                option.series(bar, bar2, bar3);
                chartOptionJson = GsonUtil.prettyFormat(option);
                JSONObject.parseObject(chartOptionJson);
                jsonArray.add(JSONObject.parseObject(chartOptionJson));

                chartOptionStr = jsonArray.toString();
            }
        }
        return chartOptionStr;
    }

    //实时数据：堆积柱状图
    @Override
    public String getRtChartData1(ChartListRespDTO chartListRespDTO){

        int parSize = 0;
        parSize = chartListRespDTO.getChartListContents().size();

        String chartId = null;
        JSONArray jsonArray = new JSONArray();
        String chartOptionStr = null;
        for(int i = 0;i < parSize;i++) {
            String jsonChartData = null;
            int chartDataRecCnt = 0;
            chartId = chartListRespDTO.getChartListContents().get(i).getChartId();

            //图形数据
            String chartOptionJson = null;

            //条件设置字符串规则：chartId:xxxx;dataBase:xlh_crm;dataTable:dws_yrpt;title:一融产品分析;toolBox:restore,save;toolTip:Y;chartType:Bar;xyShowType:X;demEn:ds;demCn:日期;idxEn:yzqys,rzfhzts;idxCn:优质企业数,入驻孵化载体数;
            //获取图形设置条件
            //ChartConditionDTO chartConditions = dataMapper.getChartCondition(chartId);

            //jsonCondStr = chartConditions.getSettingConditions();

            //获取图形数据DTO
            ChartShowDTO chartShowDTO= dataMapper.getChartData(chartId);
            chartDataRecCnt = chartShowDTO.getRecCnt();

            if (chartDataRecCnt >0) {

                String[] str = chartShowDTO.getChartData().split(";");
                String title = str[0].substring(str[0].indexOf(":") + 1, str[0].length()); //获取title
                String[] legend = str[1].substring(str[1].indexOf(":") + 1, str[1].length()).split(","); //获取legend（转换成字符串数组）
                String[] categoryData = str[2].substring(str[2].indexOf(":") + 1, str[2].length()).split(","); //获取图形category
                jsonChartData = str[3].substring(str[3].indexOf(":") + 1, str[3].length()); //获取图形series数据Json串
                System.out.println("categoryData:"+categoryData);
                String[] data = jsonChartData.split("\\|")[0].split(","); //获取图形series数据
                String[] data1 = jsonChartData.split("\\|")[1].split(","); //获取图形series数据
                String[] data2 = jsonChartData.split("\\|")[2].split(","); //获取图形series数据
                String[] data3 = jsonChartData.split("\\|")[3].split(","); //获取图形series数据
                String[] data4 = jsonChartData.split("\\|")[4].split(","); //获取图形series数据

                Option option = new Option();
                option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.shadow);
                //设置标题
                option.title().text(title);
                //设置图例
                option.legend(legend);
                //工具箱
                option.toolbox().show(true).feature(Tool.saveAsImage);
                option.calculable(true);
                //------------------图类型设定-------------------------//
                option.yAxis(new CategoryAxis().data(categoryData));
                option.xAxis(new ValueAxis());
                //指标值系列
                Bar bar = new Bar("购买报告");
                bar.stack("总量");
                bar.itemStyle().normal().label().show(true).position("insideRight");
                List<String> list0 = Arrays.asList(data);
                bar.setData(list0);

                Bar bar2 = new Bar("云服务");
                bar2.stack("总量");
                bar2.itemStyle().normal().label().show(true).position("insideRight");
                List<String> list1 = Arrays.asList(data1);
                bar2.setData(list1);

                Bar bar3 = new Bar("专项基金");
                bar3.stack("总量");
                bar3.itemStyle().normal().label().show(true).position("insideRight");
                List<String> list2 = Arrays.asList(data2);
                bar3.setData(list2);

                Bar bar4 = new Bar("高企认证");
                bar4.stack("总量");
                bar4.itemStyle().normal().label().show(true).position("insideRight");
                List<String> list3 = Arrays.asList(data3);
                bar4.setData(list3);

                Bar bar5 = new Bar("知识产权");
                bar5.stack("总量");
                bar5.itemStyle().normal().label().show(true).position("insideRight");
                List<String> list4 = Arrays.asList(data4);
                bar5.setData(list4);

                option.series(bar, bar2, bar3, bar4, bar5);
                chartOptionJson = GsonUtil.prettyFormat(option);
                JSONObject.parseObject(chartOptionJson);
                jsonArray.add(JSONObject.parseObject(chartOptionJson));

                chartOptionStr = jsonArray.toString();
            }
        }
        return chartOptionStr;
    }

    //实时数据：折线图
    @Override
    public String getRtChartData2(ChartListRespDTO chartListRespDTO){

        int parSize = 0;
        parSize = chartListRespDTO.getChartListContents().size();

        String chartId = null;
        JSONArray jsonArray = new JSONArray();
        String chartOptionStr = null;
        for(int i = 0;i < parSize;i++) {
            String jsonChartData = null;
            int chartDataRecCnt = 0;
            chartId = chartListRespDTO.getChartListContents().get(i).getChartId();

            //图形数据
            String chartOptionJson = null;

            //条件设置字符串规则：chartId:xxxx;dataBase:xlh_crm;dataTable:dws_yrpt;title:一融产品分析;toolBox:restore,save;toolTip:Y;chartType:Bar;xyShowType:X;demEn:ds;demCn:日期;idxEn:yzqys,rzfhzts;idxCn:优质企业数,入驻孵化载体数;
            //获取图形设置条件
            //ChartConditionDTO chartConditions = dataMapper.getChartCondition(chartId);

            //jsonCondStr = chartConditions.getSettingConditions();

            //获取图形数据DTO
            ChartShowDTO chartShowDTO= dataMapper.getChartData(chartId);
            chartDataRecCnt = chartShowDTO.getRecCnt();

            if (chartDataRecCnt >0) {

                String[] str = chartShowDTO.getChartData().split(";");
                String title = str[0].substring(str[0].indexOf(":") + 1, str[0].length()); //获取title
                String[] legend = str[1].substring(str[1].indexOf(":") + 1, str[1].length()).split(","); //获取legend（转换成字符串数组）
                String[] categoryData = str[2].substring(str[2].indexOf(":") + 1, str[2].length()).split(","); //获取图形category
                jsonChartData = str[3].substring(str[3].indexOf(":") + 1, str[3].length()); //获取图形series数据Json串
                System.out.println("categoryData:"+categoryData);
                String[] data = jsonChartData.split("\\|")[0].split(","); //获取图形series数据
                String[] data1 = jsonChartData.split("\\|")[1].split(","); //获取图形series数据

                Option option = new Option();
                option.tooltip().trigger(Trigger.axis);
                //设置标题
                option.title().text(title);
                //设置图例
                option.legend(legend);
                //工具箱
                option.toolbox().show(true).feature(Tool.saveAsImage);
                option.calculable(true);
                //------------------图类型设定-------------------------//
                option.xAxis(new CategoryAxis().boundaryGap(false).data(categoryData));
                option.yAxis(new ValueAxis().show(false));
                //指标值系列
                Line line1 = new Line("行为数");
                line1.stack("总量");
                line1.itemStyle().normal().label().show(true).position("top");
                List<String> list0 = Arrays.asList(data);
                line1.setData(list0);

                Line line2 = new Line("累计服务企业数");
                line2.stack("总量");
                line2.itemStyle().normal().label().show(true).position("top");
                List<String> list1 = Arrays.asList(data1);
                line2.setData(list1);

                option.series(line1, line2);
                chartOptionJson = GsonUtil.prettyFormat(option);
                JSONObject.parseObject(chartOptionJson);
                jsonArray.add(JSONObject.parseObject(chartOptionJson));

                chartOptionStr = jsonArray.toString();
            }
        }
        return chartOptionStr;
    }

    //实时数据：饼图
    @Override
    public String getRtChartData3(ChartListRespDTO chartListRespDTO){

        int parSize = 0;
        parSize = chartListRespDTO.getChartListContents().size();

        String chartId = null;
        JSONArray jsonArray = new JSONArray();
        String chartOptionStr = null;
        int chartDataRecCnt = 0;
        chartId = chartListRespDTO.getChartListContents().get(0).getChartId();
        System.out.println("rtdata3:"+chartId);

        //图形数据
        String chartOptionJson = null;

        //获取图形数据DTO
        ChartShowDTO chartShowDTO= dataMapper.getChartData(chartId);
        chartDataRecCnt = chartShowDTO.getRecCnt();
        if (chartDataRecCnt >0) {
            String[] str = chartShowDTO.getChartData().split("\\|");
            int cnt = 0;
            cnt = str.length;
            List<Pie> item = Arrays.asList();
            for(int i=0;i<cnt;i++) {
                String[] str_tmp = str[i].split(";");
                String title = str_tmp[0].substring(str_tmp[0].indexOf(":") + 1, str_tmp[0].length()); //获取title
                String[] legend = str_tmp[1].substring(str_tmp[1].indexOf(":") + 1, str_tmp[1].length()).split(","); //获取legend（转换成字符串数组）
                String[] categoryData = str_tmp[2].substring(str_tmp[2].indexOf(":") + 1, str_tmp[2].length()).split(","); //获取图形数据

                Option option = new Option();
                //设置标题
                option.title().text(title);
                //设置图例
                option.legend(legend);
                //工具箱
                option.toolbox().show(true).feature(Tool.saveAsImage);
                //鼠标浮动显示数字
                option.tooltip().trigger(Trigger.item).formatter("{a}<br/>{b}:{c} ({d}%)");
                //指标值系列
                Pie pie = new Pie(title);
                int cnt2 = 0;
                cnt2 = legend.length;
                for (int k = 0; k < cnt2; k++) {
                    pie.data(new PieData(legend[k], categoryData[k])).radius("40%");
                }
                pie.itemStyle().normal().label().show(true).formatter("{b}:{c} ({d}%)");
                pie.itemStyle().normal().labelLine().show(true);
                option.series(pie);
                chartOptionJson = GsonUtil.prettyFormat(option);
                JSONObject.parseObject(chartOptionJson);
                jsonArray.add(JSONObject.parseObject(chartOptionJson));
            }

            chartOptionStr = jsonArray.toString();
            System.out.println("chartOptionStr:" + chartOptionStr);
        }
        return chartOptionStr;
    }

}