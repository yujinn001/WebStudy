package com.sist.crawler;

import lombok.Getter;

import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Item {

    private int ino;

    private String name;

    private String image;

    private String brand;

    private String price;

    private String description;

    private int stock;

    public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	private int cno;

    public Item(int cateNo) {
        this.stock = setRandomItemStock();
        this.cno = setItemCnoBy(cateNo);
    }

    private int setRandomItemStock() {
        // 100 ~ 1000 사이의 랜덤한 숫자
        return (int) ((Math.random() * 901) + 100);
    }

    private int setItemCnoBy(int cateNo) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getCode() == cateNo)
                .findFirst()
                .orElseThrow().getCno();
    }

    @Override
    public String toString() {
        return "Item = " + name + " " + image + " " + brand + " " + price + " " + stock + " " + cno;
    }


}
