package com.kimgao.bootlauch.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;


import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"content","title"})
public class ArticleVO {
    //@JsonIgnore
    private Long id;

    //@JsonProperty("auther")
    private String author;
    private String title;
    @NotEmpty(message = "文章内容不能为空，请检查输入内容")
    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private List<Reader> reader;
}
