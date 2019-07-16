package com.feifan.controller;


import com.feifan.entity.News;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin//避免跨域问题
@RestController
@RequestMapping("/news")
public class NewsController {

    @GetMapping("/{typeid}/{newsid}")
    public News getNews(@PathVariable("typeid") Integer typeId,
                        @PathVariable("newsid") Integer newsid) {
        News news = new News(1001,1,"最美少年", LocalDateTime.now(),"张飞","" +
                "<p style=\"color:red;\">最美少年\n" +
                "    <ul>\n" +
                "        <li>张飞1</li>\n" +
                "        <li style=\"color:red;\">张飞2</li>\n" +
                "        <li>张飞3</li>\n" +
                "        <li>张飞4</li>\n" +
                "    </ul>\n" +
                "    <img src=\"http://localhost:9091/image1.jpg\" width=\"200\"/>" +
                "</p>");
        return news;
    }

    /**
     * 接收发布的新闻，提交什么新闻，回复什么新闻，并且在控制台打印
     * @param text
     * @return
     */
    @PostMapping("/addNews")
    public String save(String text){
        System.out.println(text);
        return text;
    }

    @GetMapping("/getMdContent")
    public String getMdContent(){
        return "<h1 id=\"h1--del-del-\"><a name=\"你在<del>干什么</del>？\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>你在<del>干什么</del>？</h1><p>你发反了你</p>\n" +
                "<p>nfldffnldnlsn<br>建档立卡发你代理商<br>可能都<strong><em>流口水</em></strong>拿过来 </p>";
    }

}
