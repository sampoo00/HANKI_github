package com.hanki.hanki.NumberTicket.NetworkItem;

import java.util.ArrayList;
import java.util.Date;

public class OrderedListData {
    String ShopName;
    String menuImage;
    String MenuName;
    ArrayList<ToppingOrderListData> menuTopping;
    String sendMsg;
    int waitNum;
    int orderNum;
    Date orderDate;
}
