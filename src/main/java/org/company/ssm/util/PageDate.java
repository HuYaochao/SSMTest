package org.company.ssm.util;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageDate<T> {
    private long total;
    private List<T> rows;
}
