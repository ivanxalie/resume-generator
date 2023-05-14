package com.ivan.xalie.resume.generator.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.ivan.xalie.resume.generator.config.Icons;
import com.ivan.xalie.resume.generator.dto.Icon;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class IconDeserializer extends JsonDeserializer<Icon> {

    private final Icons icons;

    public IconDeserializer(Icons icons) {
        this.icons = icons;
    }

    @Override
    public Icon deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        Icon icon = new Icon();
        TreeNode node = jsonParser.getCodec().readTree(jsonParser);
        icon.setLink(getText(node, "link"));
        icon.setIconSrc(getText(node, "iconSrc"));
        if (icon.getIconSrc().contains("$icons:")) {
            String[] iconParts = icon.getIconSrc().split(":");
            Icons.Icon iconConfig = icons.get(iconParts[1]);
            icon.setIconSrc(iconConfig.getLink());
        }
        return icon;
    }

    private String getText(TreeNode node, String key) {
        TreeNode treeNode = node.get(key);
        if (!(treeNode instanceof TextNode))
            return null;
        return ((TextNode) treeNode).asText();
    }
}
