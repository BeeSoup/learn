/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/20  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-20
 */
@Slf4j
public class TableTest {

    public static void main(String[] args) {
        Map<String, ExcelDTO> deal = getExcelMap();
        excel(deal);
//        log.info(deal.toString());
        String tempName = "测试多sheet页001";
//        String tempName1 = "测试多sheet页002.xls";
//        fill(tempName1);
        fill(tempName);

    }

    public static void fill(String tempName) {
        String filePath = "F:\\excel\\";

        String templateFileName = filePath + tempName + ".xls";

        String fillName = "fill_" + tempName;

        String fillFileName = filePath + fillName + ".xls";

        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fillFileName)
//                    .excelType(ExcelTypeEnum.XLSX)
//                    .registerWriteHandler(strategy())
                    .withTemplate(templateFileName).build();

            WriteSheet sheet1 = EasyExcel.writerSheet("测试多sheet页0012").build();
            WriteSheet sheet2 = EasyExcel.writerSheet("测试多sheet页0011").build();

            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
//            FillWrapper fillData1 = new FillWrapper("test", fillData());
            excelWriter.fill(fillData(), sheet1);
//            excelWriter.fill(fillData(), fillConfig, sheet1);
//            excelWriter.write(dataList(), sheet2);
//            excelWriter.fill(fillData(), fillConfig, sheet2);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }


    private static HorizontalCellStyleStrategy strategy() {
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();

        // 设置 自动换行
//        headWriteCellStyle.setWrapped(true);
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        // 背景设置为红色
//        headWriteCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 20);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
//        contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
//        contentWriteCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        WriteFont contentWriteFont = new WriteFont();

        // 设置 自动换行
//        contentWriteCellStyle.setWrapped(true);
        // 设置 垂直居中
//        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        // 设置 水平居中
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // 字体大小
        contentWriteFont.setFontHeightInPoints((short) 10);
//        contentWriteFont.setCharset(FontCharset.GB2312.getNativeId());
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        return horizontalCellStyleStrategy;
    }

    private static List<List<Object>> dataList() {
        List<List<Object>> list = new ArrayList<List<Object>>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<Object>();
            data.add("字符串" + i);
            data.add(new Date());
            data.add(0.56);
            list.add(data);
        }
        return list;
    }

    public static List<Map<String, Object>> fillData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
//        map.put("field12", "字符串s1");
//        map.put("field11", "字符串1");

        map.put("field22", "字符串row1_22");
        map.put("field21", "字符串row1_21");
        list.add(map);
        Map<String, Object> map2 = new HashMap<>();
//        map2.put("field11", "字符串11");
//        map2.put("field12", "字符串xxxx11");

        map2.put("field21", "字符串row2_21");
        map2.put("field22", "字符串row2_22");
        list.add(map2);
        return list;
    }


    public static void excel(Map<String, ExcelDTO> deal) {
        String fileName = "F:\\excel\\";
        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            for (Map.Entry<String, ExcelDTO> entry : deal.entrySet()) {
                ExcelDTO value = entry.getValue();
                fileName = fileName + value.getTableNameCn() + ".xls";
                excelWriter = EasyExcel.write(fileName)
//                        .excelType(ExcelTypeEnum.XLSX)
                        .registerWriteHandler(strategy())

                        .registerWriteHandler(new AbstractColumnWidthStyleStrategy() {
                            @Override
                            protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<CellData> cellDataList,
                                                          Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
                                // 简单设置
                                Sheet sheet = writeSheetHolder.getSheet();
                                sheet.setColumnWidth(cell.getColumnIndex(), 5000);
                                if (!isHead) {
                                    log.info("cell");
                                    String stringCellValue = cell.getStringCellValue();
                                    cell.setCellValue(stringCellValue);
                                }
                            }
                        })
//                        .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                        .build();
                // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
                List<SheetDTO> sheetList = value.getSheetList();
                if (CollectionUtils.isNotEmpty(sheetList)) {
                    for (int i = 0; i < sheetList.size(); i++) {
                        SheetDTO sheet = sheetList.get(i);
                        List<PcParamInterTableFieldVO> fieldList = sheet.getFieldList();
                        if (CollectionUtils.isNotEmpty(fieldList)) {
                            WriteSheet writeSheet = EasyExcel.writerSheet(i, sheet.getTableNameCn()).head(head(fieldList)).build();
                            excelWriter.write(dataList(fieldList), writeSheet);
                        }
                    }
                }
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
//                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(head()).build();
//                Map<Integer, Integer> columnWidthMap = writeSheet.getColumnWidthMap();
//                log.info(columnWidthMap.toString());
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据

                if (excelWriter != null) {
                    excelWriter.finish();
                }
                excelWriter = null;
            }

        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

    }

    private static List<List<String>> dataList(List<PcParamInterTableFieldVO> fieldList) {
        List<List<String>> list = new ArrayList<>();
        List<String> row = new ArrayList<>();
        for (PcParamInterTableFieldVO field : fieldList) {
            String fieldFill = " {." + field.getFieldName() + "} ";
            row.add(fieldFill);
        }
        list.add(row);

//        List<List<Object>> list = new ArrayList<List<Object>>();
//        for (int i = 0; i < 10; i++) {
//            List<Object> data = new ArrayList<Object>();
//            data.add("字符串" + i);
//            data.add(new Date());
//            data.add(0.56);
//            list.add(data);
//        }
        return list;
    }

    private static List<List<String>> head(List<PcParamInterTableFieldVO> fieldList) {
        List<List<String>> headList = fieldList.stream().map(
                (f) -> {
                    List<String> head = new ArrayList<>();
                    head.add(f.getFieldNameCn());
                    return head;
                }
        ).collect(Collectors.toList());
        return headList;
    }

    private static Map<String, ExcelDTO> getExcelMap() {
        Map<String, Object> param = new HashMap<>();
        List<PcParamInterTableFieldVO> fieldList = postGetField(param);

        TreeMap<String, List<PcParamInterTableFieldVO>> fieldMap = fieldList.stream().collect(Collectors.groupingBy(PcParamInterTableFieldVO::getParamInterTableId, TreeMap::new, Collectors.toList()));
        for (Map.Entry<String, List<PcParamInterTableFieldVO>> entry : fieldMap.entrySet()) {
            List<PcParamInterTableFieldVO> sortedField = entry.getValue().stream().sorted(
                    Comparator.comparing(PcParamInterTableFieldVO::getParamSort)).collect(Collectors.toList());
            entry.setValue(sortedField);
        }

        param.put("subStatus", SubStatusEnum.PC_PARAM_ZJDZT_SHEET.getCode());
        List<PcParamInterTable> excelTable = postGetTable(param);
        Map<String, ExcelDTO> deal = deal(excelTable);

        param.put("subStatus", SubStatusEnum.PC_PARAM_ZJDZT_FIELD.getCode());
        List<PcParamInterTable> sheetTable = postGetTable(param);
        TreeMap<String, List<PcParamInterTable>> sheetMap = sheetTable.stream().collect(Collectors.groupingBy(PcParamInterTable::getParentId, TreeMap::new, Collectors.toList()));
        Set<Map.Entry<String, List<PcParamInterTable>>> entrySet = sheetMap.entrySet();
        for (Map.Entry<String, List<PcParamInterTable>> entry : entrySet) {
            List<SheetDTO> sheetList = entry.getValue().stream().sorted(
                    Comparator.comparing(PcParamInterTable::getTableSort)).map(
                    x -> SheetDTO.builder()
                            .id(x.getId())
                            .tableName(x.getTableName())
                            .tableNameCn(x.getTableNameCn())
                            .build()).collect(Collectors.toList());
            for (SheetDTO sheet : sheetList) {
                sheet.setFieldList(fieldMap.get(sheet.getId()));
            }
            ExcelDTO excelDTO = deal.get(entry.getKey());
            excelDTO.setSheetList(sheetList);
        }
        return deal;
    }

    public static List<PcParamInterTable> postGetTable(Map<String, Object> param) {
        String url = "http://localhost:32103/param/getListParamTableList";

        String responseBody = HttpClientUtils.sendHttpPostJson(url, param);
        log.info(responseBody);
        TypeReference<HttpResult<JSONArray>> responseType = new TypeReference<HttpResult<JSONArray>>() {
        };

        HttpResult<JSONArray> jsonObjectHttpResult = JSON.parseObject(responseBody, responseType);

        JSONArray result = jsonObjectHttpResult.getResult();

        List<PcParamInterTable> pcParamInterTables = JSONObject.parseArray(result.toJSONString(), PcParamInterTable.class);
        return pcParamInterTables;
    }

    public static List<PcParamInterTableFieldVO> postGetField(Map<String, Object> param) {
        String url = "http://localhost:32103/param/getListParamTableField";

        String responseBody = HttpClientUtils.sendHttpPostJson(url, param);
        log.info(responseBody);
        TypeReference<HttpResult<JSONArray>> responseType = new TypeReference<HttpResult<JSONArray>>() {
        };

        HttpResult<JSONArray> jsonObjectHttpResult = JSON.parseObject(responseBody, responseType);

        JSONArray result = jsonObjectHttpResult.getResult();

        List<PcParamInterTableFieldVO> fieldVOList = JSONObject.parseArray(result.toJSONString(), PcParamInterTableFieldVO.class);
        return fieldVOList;
    }

    public static Map<String, ExcelDTO> deal(List<PcParamInterTable> tableList) {
        Map<String, ExcelDTO> map = new HashMap<>();

        if (CollectionUtils.isNotEmpty(tableList)) {
            for (PcParamInterTable pcParamInterTable : tableList) {
                ExcelDTO build = ExcelDTO.builder()
                        .tableName(pcParamInterTable.getTableName())
                        .tableNameCn(pcParamInterTable.getTableNameCn())
                        .build();
                map.put(pcParamInterTable.getId(), build);
            }
        }


        return map;
    }
}
