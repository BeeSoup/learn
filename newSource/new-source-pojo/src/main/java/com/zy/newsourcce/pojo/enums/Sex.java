package com.zy.newsourcce.pojo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * TODO...
 *
 * @author zhang
 * @since 2021/2/21
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Sex {

    ;
    private String code;

    private String description;

    public static Sex getEnumByCode(String code) {
        for (Sex sex : Sex.values()) {
            if (code.equals(sex.getCode())) {
                return sex;
            }
        }
        return null;
    }
}
