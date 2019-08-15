package com.yzh.poetry.pojo;

import com.yzh.common.pojo.CommonFiled;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yzh
 * @date 2019/8/15
 */
@Data
@Table(name = "blog_article")
public class Poetry  extends CommonFiled implements Serializable{
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String articleName;//文章标题

    private String picture;//封面图

    private String summary;//文章摘要

    private String content;//文章内容

    private Integer isDelete;//1、否；2、是

    private Integer noComment;//1、否；2、是

    private String author;

    private String articleUrl;  //文章URL

    private Integer category;  //文章类别 1、已发布  2、草稿

    private Date pubDate;

    private String size;
}
