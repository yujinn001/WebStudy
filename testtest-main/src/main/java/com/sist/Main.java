package com.sist;

import com.sist.crawler.ItemCrawler;

public class Main {

    public static void main(String[] args) {
        ItemCrawler itemCrawler = new ItemCrawler();

        int cateNo = 202; // 소분류 카테고리로 추가 
        itemCrawler.run(cateNo);
    }

}
