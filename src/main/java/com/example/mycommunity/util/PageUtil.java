package com.example.mycommunity.util;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 */
public class PageUtil {
    /**
     * 根据当前页和当前索引（从1开始）映射得到分页map供view使用
     *
     * @param currentPage  当前页
     * @param currentIndex 当前索引（从1开始）
     * @param <T>          实体类
     * @return 映射分页map
     */
    public static <T> Map<String, Integer> getPageMap(Page<T> currentPage, int currentIndex) {
        int totalPages = currentPage.getTotalPages();
        int startIndex = 0;
        int endIndex = 0;
        if (totalPages <= 10) {
            startIndex = 1;
            endIndex = totalPages;
        } else {
            if (currentIndex <= 6) {
                startIndex = 1;
                endIndex = 10;
            } else {
                if (totalPages - currentIndex > 4) {
                    endIndex = currentIndex + 4;
                } else {
                    endIndex = totalPages;
                }
                startIndex = endIndex - 9;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("endIndex", endIndex);
        map.put("currentIndex", currentIndex);
        return map;
    }
}
