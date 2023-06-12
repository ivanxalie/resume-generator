package com.ivan.xalie.resume.generator.service.impl;

import com.ivan.xalie.resume.generator.dto.CssSelector;
import com.ivan.xalie.resume.generator.service.model.StyleService;

import java.util.List;

public class StyleServiceImpl implements StyleService {
    public static final String DEFAULT = """
            html {
                font-size: 15px;
            }
                                    
            body {
                background-color: rgba(240, 255, 255, 0.5);
                border: 1px solid rgba(0, 0, 255, 0.3);
                border-radius: 10px;
                margin: 2px;
            }
                                    
            div {
                margin: 2px;
            }
                                    
            h1 {
                font-size: 24px;
                margin: 2px;
            }
                                    
            h2 {
                font-size: 20px;
                margin: 5px;
            }
                                    
            p {
                display: inline-block;
                text-indent: 20px;
            }
                                    
            .center {
                text-align: center;
            }
                                    
            .contacts div {
                display: inline-block;
                margin-right: 50px;
            }
                                    
            .icon {
                width: 64px;
                height: 64px;
                margin: 4px;
            }
                                    
            .company {
                font-size: 0;
                letter-spacing: -0.31em;
            }
                                    
            .company h2 {
                display: inline-block;
                vertical-align: top;
                width: 15%;
                box-sizing: border-box;
                padding-left: 5px;
                padding-right: 5px;
                letter-spacing: normal;
            }
                                    
            .accomplishments-duties {
                font-size: 0;
                letter-spacing: -0.31em;
            }
                                    
            .accomplishments-duties div {
                display: inline-block;
                vertical-align: top;
                width: 45%;
                box-sizing: border-box;
                padding: 5px;
                font-size: 13px;
                letter-spacing: normal;
            }
                                    
            .education .university-name {
                font-size: 0;
                letter-spacing: -0.31em;
            }
                                    
            .education .university-name div {
                display: inline-block;
                vertical-align: top;
                width: 25%;
                box-sizing: border-box;
                font-size: 13px;
                letter-spacing: normal;
                margin-left: 5px;
            }
                                    
            .education .university-name .icon {
                align: center;
            }
                                    
            div.skills {
                margin-left: -5px;
            }
                                    
            .skills li {
                display: inline;
                list-style-type: none;
                margin-right: 5px;
                padding-right: 5px;
            }
                                    
            .skills li::before {
                content: "\\2022";
                display: inline-block;
                width: 1em;
                margin-left: -0.5em;
            }
                                    
            .summary {
                line-height: 1.5;
                text-indent: 1em;
            }
                        
            .language {
              position: absolute;
              top: 0;
              right: 0;
            }
            """;


    public String transform(List<CssSelector> styles) {
        if (styles == null || styles.isEmpty()) return DEFAULT;
        StringBuilder result = new StringBuilder();
        styles.forEach(cssSelector -> addSelector(result, cssSelector));
        return result.toString();
    }

    private void addSelector(StringBuilder result, CssSelector cssSelector) {
        result.append(String.format("%s {%s}%n", cssSelector.getSelector(), cssSelector.getBody()));
    }
}
