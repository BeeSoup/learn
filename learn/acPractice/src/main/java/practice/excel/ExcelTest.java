/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/19  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能说明: https://www.yuque.com/easyexcel/doc/write
 *
 * @author zhangyu30939
 * @since 2021-10-19
 */
@Slf4j
public class ExcelTest {
    public static void main2(String[] args) {
        String fileName = "F:\\excel\\" + "write" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可

        List<ExcelEntity> list = Arrays.asList(
                ExcelEntity.builder()
                        .name("张三").age("15")
                        .build(),
                ExcelEntity.builder()
                        .name("张三").age("李四")
                        .build());

//        EasyExcel.write(fileName, ExcelEntity.class).sheet("模板").doWrite(list);


        ExcelWriter excelWriter = null;
        try {
            // 这里 指定文件
            excelWriter = EasyExcel.write(fileName).build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            for (int i = 0; i < 5; i++) {
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
                WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).head(head()).build();
                Map<Integer, Integer> columnWidthMap = writeSheet.getColumnWidthMap();
                log.info(columnWidthMap.toString());
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                excelWriter.write(list, writeSheet);
            }
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "F:\\excel\\" + "write" + System.currentTimeMillis() + ".xlsx";


        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();


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

        //设置 自动换行
        contentWriteCellStyle.setWrapped(true);
        //设置 垂直居中
//        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        //设置 水平居中
//        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // 字体大小
        contentWriteFont.setFontHeightInPoints((short) 10);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        List<ExcelEntity> list = Arrays.asList(
                ExcelEntity.builder()
                        .name("张三1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111").age("15")
                        .build(),
                ExcelEntity.builder()
                        .name("李四").age("20")
                        .build());
        EasyExcel.write(fileName).registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(new AbstractColumnWidthStyleStrategy() {
                    @Override
                    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<CellData> cellDataList,
                                                  Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
                        // 简单设置
                        Sheet sheet = writeSheetHolder.getSheet();
                        sheet.setColumnWidth(cell.getColumnIndex(), 5000);
                    }
                })
                // 这里放入动态头
                .head(head()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(dataList());
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

    private static List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("姓名");
        List<String> head1 = new ArrayList<String>();
        head1.add("年龄");
        List<String> head2 = new ArrayList<String>();
        head2.add("日期");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }

    private static Map<Integer, Integer> colMap() {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 100);
        map.put(2, 500);
        map.put(3, 5500);
        return map;
    }


    @Data
    @Builder
    public static class ExcelEntity implements Serializable {
        // @ExcelProperty({"主标题", "字符串标题"})
        @ExcelProperty("名称")
        private String name;
        private String age;
        /**
         * 忽略这个字段
         */
//        @ExcelIgnore
        /**
         * 我想写到excel 用年月日的格式
         */
//        @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")

        /**
         * 我想写到excel 用百分比表示
         */
//        @NumberFormat("#.##%")

        /**
         * 宽度为50
         */
//        @ColumnWidth(50)
//@Data
//@ContentRowHeight(10)
//@HeadRowHeight(20)
//@ColumnWidth(25)
        // 这一列 每隔2行 合并单元格
//        @ContentLoopMerge(eachRow = 2)
    }


    @Data
    @Builder
    public static class ExcelEntity2 implements Serializable {
        // @ExcelProperty({"主标题", "字符串标题"})
        @ExcelProperty("名称")
        private String name;
        private String age;
        /**
         * 忽略这个字段
         */
//        @ExcelIgnore
    }
}
