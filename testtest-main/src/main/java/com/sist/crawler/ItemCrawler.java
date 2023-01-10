package com.sist.crawler;

import com.sist.util.DBConn;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 상품 갯수는 랜덤으로
public class ItemCrawler {

    private static final String DOMAIN = "https://campinglist.co.kr";

    private static final String ITEM_LIST = "https://campinglist.co.kr/product/list.html?cate_no=";

    // 시작 페이지
    private static final int START_PAGE = 1;

    // 끝 페이지
    private static final int LAST_PAGE = 1;

    private final StringBuilder sb = new StringBuilder();

    private Connection conn;

    private PreparedStatement pstmt;

    private final DBConn dbConn;

    public ItemCrawler() {
        this.dbConn = DBConn.getInstance();

    }

    public void run(int cateNo) {
        String url = ITEM_LIST + cateNo + "&page=";
        try {
            for (int page = START_PAGE; page <= LAST_PAGE; page++) {
                Document document = Jsoup.connect(url + page).get();
                Elements elements = document.select("#contents div.guide_contents ul.prdList li");
                for (Element element : elements) {
                    String itemDetailPage = element.select("div.description strong.name a").attr("href");
                    if (itemDetailPage.length() == 0) {
                        continue;
                    }
                    Item item = into(DOMAIN + itemDetailPage, cateNo);
                    System.out.println(item);
                    // insertDatabase(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Item into(String url, int cateNo) {
        Item item = new Item(cateNo);
        String itemName = "", itemImage = "", itemBrand = "", itemDescription = "", itemPrice = "";
        try {
            Document document = Jsoup.connect(url).get();
            Elements dataArea = document.select("#contents div.detaarea div.detailArea");

            // 상품 이미지
            Elements imgArea = dataArea.select("div.imgArea");
            for (Element element : imgArea) {
                // 대표 이미지
                String mainImage = "https:" + element.select("div.keyImg div.thumbnail a img").attr("src");
                sb.append(mainImage).append(",");
                Elements listImg = element.select("div.listImg ul li img.ThumbImage");
                for (Element img : listImg) {
                    String subImg = "https:" + img.attr("src");
                    sb.append(subImg).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                itemImage = sb.toString();
                sb.setLength(0);
            } // end for

            // 상품 기본 정보
            for (Element element : dataArea) {
                Elements itemInfos = element.select("div.infoArea");
                for (Element itemInfo : itemInfos) {
                    itemName = itemInfo.select("div.headingArea h2").text();
                    // itemPrice = Integer.parseInt(itemInfo.select("div.pricearea div.disnoul_right span.sale").text());
                    Elements select = itemInfo.select("div.disno ul.disnoul li.xans-record-");
                    for (Element s : select) {
                        Elements list = s.select("div.disnoul_left span");
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).text().equals("브랜드")) {
                                itemBrand = s.select("div.disnoul_right span").get(i).text();
                            }
                            if (list.get(i).text().equals("기존판매가")) {
                                itemPrice = s.select("div.disnoul_right span strike").text();
                            } else if (list.get(i).text().equals("판매가")) {
                                if (itemPrice.length() >= 1) {
                                    itemPrice = s.select("div.disnoul_right span strong").text();
                                }
                            }
                        }
                    }
                }
            } // end for

            // 상품 설명

            item.setName(itemName);
            item.setImage(itemImage);
            item.setBrand(itemBrand);
            item.setPrice(itemPrice);
            item.setDescription(itemDescription);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    private void insertDatabase(Item item) {
        String sql =
                "INSERT INTO HC_ITEM_2 (ino, name, image, brand, price, stock, cno) " +
                        "VALUES (HC_ICNO_SEQUENCE_2.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        try {
            conn = dbConn.createConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getImage());
            pstmt.setString(3, item.getBrand());
            pstmt.setString(4, item.getPrice());
            pstmt.setInt(5, item.getStock());
            pstmt.setInt(6, item.getCno());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection(pstmt, conn);
        }
    }

}
