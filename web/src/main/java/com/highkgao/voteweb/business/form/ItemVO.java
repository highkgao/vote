package com.highkgao.voteweb.business.form;

public class ItemVO {

    private String itemName;
    private String  itemDesc;
    private String itemSuperiority;
    private String itemPic;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemSuperiority() {
        return itemSuperiority;
    }

    public void setItemSuperiority(String itemSuperiority) {
        this.itemSuperiority = itemSuperiority;
    }

    public String getItemPic() {
        return itemPic;
    }

    public void setItemPic(String itemPic) {
        this.itemPic = itemPic;
    }

    @Override
    public String toString() {
        return "ItemVO{" +
                "itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemSuperiority='" + itemSuperiority + '\'' +
                ", itemPic='" + itemPic + '\'' +
                '}';
    }
}
