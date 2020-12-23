/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/10/28  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/10/28
 */
@Slf4j
@Component
public class TimeUtil {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2020, 12, 31);
        Period period = Period.between(now, of);
        // (LocalDate startDateInclusive, LocalDate endDateExclusive)

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        List<LocalDate> businessDateOfDay = getBusinessDateOfDay(now);
        List<LocalDate> businessDateOfWeek = getBusinessDateOfWeek(now, DayOfWeek.THURSDAY);
        List<LocalDate> businessDateOfMonth = getBusinessDateOfMonth(now, 29);
        List<LocalDate> businessDateOfQuarter = getBusinessDateOfQuarter(now, 129);
        List<LocalDate> businessDateOfHalfYear = getBusinessDateOfHalfYear(now, 429);
        List<LocalDate> businessDateOfYear = getBusinessDateOfYear(now, 1029);
        log.info(formatter.format(of));
    }

    /**
     * 按日生成业务日期：查询起始日期到当年最后一天
     *
     * @param startDateInclusive 查询起始日期
     * @return
     */
    public static List<LocalDate> getBusinessDateOfDay(LocalDate startDateInclusive) {
        LocalDate lastDayOfYear = startDateInclusive.with(TemporalAdjusters.lastDayOfYear());
        return getBusinessDateOfDay(startDateInclusive, lastDayOfYear);
    }

    /**
     * 按日生成业务日期
     *
     * @param startDateInclusive 查询起始日期
     * @param endDateExclusive   查询结束日期
     * @return
     */
    public static List<LocalDate> getBusinessDateOfDay(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        List<LocalDate> dateList = new ArrayList<>();
        for (LocalDate beginDate = startDateInclusive;
             !beginDate.isAfter(endDateExclusive);
             beginDate = beginDate.plus(1, ChronoUnit.DAYS)) {
            dateList.add(beginDate);
        }
        log.info("OK");
        return Collections.unmodifiableList(dateList);
    }

    /**
     * 按周生成业务日期 :查询起始日期到当年最后一天
     *
     * @param startDateInclusive 查询起始日期
     * @param dayOfWeek          周几
     * @return
     */
    public static List<LocalDate> getBusinessDateOfWeek(LocalDate startDateInclusive, DayOfWeek dayOfWeek) {
        LocalDate lastDayOfYear = startDateInclusive.with(TemporalAdjusters.lastDayOfYear());
        return getBusinessDateOfWeek(startDateInclusive, lastDayOfYear, dayOfWeek);
    }

    /**
     * 按周生成业务日期
     *
     * @param startDateInclusive 查询起始日期
     * @param endDateExclusive   查询结束日期
     * @param dayOfWeek          周几
     * @return
     */
    public static List<LocalDate> getBusinessDateOfWeek(LocalDate startDateInclusive, LocalDate endDateExclusive, DayOfWeek dayOfWeek) {
        List<LocalDate> dateList = new ArrayList<>();
        if (startDateInclusive.getDayOfWeek().getValue() != dayOfWeek.getValue()) {
            startDateInclusive = startDateInclusive.with(TemporalAdjusters.next(dayOfWeek));
        }
        for (LocalDate beginDate = startDateInclusive;
             !beginDate.isAfter(endDateExclusive);
             beginDate = beginDate.plus(1, ChronoUnit.WEEKS)) {
            dateList.add(beginDate);
        }
        log.info("OK");
        return Collections.unmodifiableList(dateList);
    }

    /**
     * 按月生成业务日期:查询起始日期到当年最后一天
     *
     * @param startDateInclusive 查询起始日期
     * @param regexDay           1~99
     * @return
     */
    public static List<LocalDate> getBusinessDateOfMonth(LocalDate startDateInclusive, int regexDay) {
        int regexMonth = 1;
        int CycleMonth = 1;
        LocalDate lastDayOfYear = startDateInclusive.with(TemporalAdjusters.lastDayOfYear());
        return getBusinessDateOfCycle(startDateInclusive, lastDayOfYear, regexMonth, regexDay, CycleMonth);
    }

    /**
     * 按季度生成业务日期:查询起始日期到当年最后一天
     *
     * @param startDateInclusive 查询起始日期
     * @param regex              规则比如-> 130
     * @return
     */
    public static List<LocalDate> getBusinessDateOfQuarter(LocalDate startDateInclusive, int regex) {
        // 月份必须准确
        int regexMonth = regex / 100;
        int regexDay = regex % 100;
        int CycleMonth = 3;
        LocalDate lastDayOfYear = startDateInclusive.with(TemporalAdjusters.lastDayOfYear());
        return getBusinessDateOfCycle(startDateInclusive, lastDayOfYear, regexMonth, regexDay, CycleMonth);
    }

    /**
     * 按半年生成业务日期:查询起始日期到当年最后一天
     *
     * @param startDateInclusive 查询起始日期
     * @param regex              规则比如 ->330
     * @return
     */
    public static List<LocalDate> getBusinessDateOfHalfYear(LocalDate startDateInclusive, int regex) {
        // 月份必须准确
        int regexMonth = regex / 100;
        int regexDay = regex % 100;
        int CycleMonth = 6;
        LocalDate lastDayOfYear = startDateInclusive.with(TemporalAdjusters.lastDayOfYear());
        return getBusinessDateOfCycle(startDateInclusive, lastDayOfYear, regexMonth, regexDay, CycleMonth);
    }

    /**
     * 按年生成业务日期:查询起始日期到当年最后一天
     *
     * @param startDateInclusive 查询起始日期
     * @param regex              规则-> 1230
     * @return
     */
    public static List<LocalDate> getBusinessDateOfYear(LocalDate startDateInclusive, int regex) {
        // 月份必须准确
        int regexMonth = regex / 100;
        int regexDay = regex % 100;
        int CycleMonth = 12;
        LocalDate lastDayOfYear = startDateInclusive.with(TemporalAdjusters.lastDayOfYear());
        return getBusinessDateOfCycle(startDateInclusive, lastDayOfYear, regexMonth, regexDay, CycleMonth);
    }

    /**
     * 周期性生成业务日期
     *
     * @param startDateInclusive 查询起始日期
     * @param endDateExclusive   查询结束日期
     * @param regexMonth         规则月份
     * @param regexDay           规则天数
     * @param cycleMonth         周期是按月还是按季度还是半年或者是年
     * @return
     */
    public static List<LocalDate> getBusinessDateOfCycle(LocalDate startDateInclusive, LocalDate endDateExclusive, int regexMonth, int regexDay, int cycleMonth) {

        if (regexDay < 0 || regexMonth < 0 || regexMonth > 12) {
            throw new IllegalArgumentException("日期的每月第几天不得小于0并且月份不得小于0也不得大于12");
        }

        List<LocalDate> dateList = new ArrayList<>();
        // 指定日期 localDate.getYear()-month-1开始循环
        for (LocalDate beginDate = LocalDate.of(startDateInclusive.getYear(), regexMonth, 1);
             !beginDate.isAfter(endDateExclusive); beginDate = beginDate.plus(cycleMonth, ChronoUnit.MONTHS)) {
            if (beginDate.getMonth().getValue() < startDateInclusive.getMonth().getValue()) {
                continue;
            }
            LocalDate lastDayOfMonth = beginDate.with(TemporalAdjusters.lastDayOfMonth());
            int dayOfMonth = lastDayOfMonth.getDayOfMonth();
            if (dayOfMonth >= regexDay) {
                beginDate = LocalDate.of(beginDate.getYear(), beginDate.getMonth(), regexDay);
            } else {
                beginDate = lastDayOfMonth;
            }
            if (beginDate.isAfter(startDateInclusive) || beginDate.isEqual(startDateInclusive)) {
                dateList.add(beginDate);
            }
        }
        return Collections.unmodifiableList(dateList);
    }
}
