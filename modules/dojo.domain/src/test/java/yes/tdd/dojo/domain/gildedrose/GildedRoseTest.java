package yes.tdd.dojo.domain.gildedrose;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    //需求背景
    //
    //“镶金玫瑰”！这是一家魔兽世界里的小商店。出售的商品也都是高质量的。但不妙的是，随着商品逐渐接近保质期，它们的质量也不断下滑。现邀请你开发一个IT系统，从而能够在每过去一天后，对商店中商品的信息做出对应的更新。
    //
    //首先，简单介绍一下我们的商品特性：
    //
    //所有商品都有一个SellIn值，这是商品距离过期的天数，最好在这么多天之内卖掉
    //所有商品都有一个Quality值，代表商品的价值
    //商品的SellIn值和Quality值，它们每天会发生变化，但是会有特例
    //商品的价格规则说明如下：
    //
    //商品每过一天价值会下滑1点 ，一旦过了保质期，价值就以双倍的速度下滑
    //商品的价值永远不会小于0，也永远不会超过50
    //陈年干酪（Aged Brie）是一种特殊的商品，放得越久，价值反而越高
    //萨弗拉斯（Sulfuras）是一种传奇商品，没有保质期的概念，质量也不会下滑
    //后台门票（Backstage pass）和陈年干酪（Aged Brie）有相似之处：
    //越接近演出日，商品价值Quality值反而上升
    //在演出前10天，价值每天上升2点
    //演出前5天，价值每天上升3点
    //一旦过了演出日，价值就马上变成0
    @Nested
    class UnitTest {
        @Test
        void should_be_able_to_reduce_1_quality_of_unexpired_common_item_when_pass_one_day() {
            Item commonItem = new Item("common item", 10, 10);
            commonItem.updateQuality();
            assertEquals(commonItem.toString(), "common item, 9, 9");
        }
    }

    @Nested
    class IntegrationTest {
        @Test
        @Disabled
        void should_quality_of_items_in_shop_changed_pass_one_day() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("OMGHAI!");
            Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
            GildedRose app = new GildedRose(items);
            int days = 2;
            for (int i = 0; i < days; i++) {
                printStream.println("-------- day " + i + " --------");
                printStream.println("name, sellIn, quality");
                for (Item item : items) {
                    printStream.println(item);
                }
                printStream.println();
                app.updateQuality();
            }
            assertEquals(out.toString(), "OMGHAI!\n" +
                "-------- day 0 --------\n" +
                "name, sellIn, quality\n" +
                "+5 Dexterity Vest, 10, 20\n" +
                "Aged Brie, 2, 0\n" +
                "Elixir of the Mongoose, 5, 7\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Sulfuras, Hand of Ragnaros, -1, 80\n" +
                "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
                "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
                "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
                "Conjured Mana Cake, 3, 6\n" +
                "\n" +
                "-------- day 1 --------\n" +
                "name, sellIn, quality\n" +
                "+5 Dexterity Vest, 9, 19\n" +
                "Aged Brie, 1, 1\n" +
                "Elixir of the Mongoose, 4, 6\n" +
                "Sulfuras, Hand of Ragnaros, 0, 80\n" +
                "Sulfuras, Hand of Ragnaros, -1, 80\n" +
                "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
                "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
                "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
                "Conjured Mana Cake, 2, 5\n" +
                "\n");
        }
    }
}
