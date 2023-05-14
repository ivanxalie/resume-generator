package com.ivan.xalie.resume.generator.service.model;

import com.ivan.xalie.resume.generator.dto.CssSelector;

import java.util.List;

public interface StyleService {
    String transform(List<CssSelector> styles);
}
