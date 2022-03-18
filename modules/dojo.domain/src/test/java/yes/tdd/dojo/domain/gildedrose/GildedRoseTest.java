package yes.tdd.dojo.domain.gildedrose;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    @Nested
    class IntegrationTest {
        @Test
        void should_quality_of_items_in_shop_changed_pass_one_day() {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println("OMGHAI!");
            List<Item> items = List.of(
                Item.newInstance("+5 Dexterity Vest", 10, 20), //
                Item.newInstance("Aged Brie", 2, 0), //
                Item.newInstance("Elixir of the Mongoose", 5, 7), //
                Item.newInstance("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item.newInstance("Sulfuras, Hand of Ragnaros", -1, 80),
                Item.newInstance("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item.newInstance("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item.newInstance("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                Item.newInstance("Conjured Mana Cake", 3, 6));
            GildedRose app = new GildedRose(items);
            int days = 2;
            for (int i = 0; i < days; i++) {
                printStream.println("-------- day " + i + " --------");
                printStream.println("name, sellIn, quality");
                for (Item item : app.items()) {
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

    @Nested
    class UnitTest {
        @Test
        void should_be_able_to_reduce_1_quality_of_unexpired_common_item_when_pass_one_day() {
            test("common item", 10, 10, "common item, 9, 9");
        }

        @Test
        void should_be_able_to_reduce_2_quality_of_expired_common_item_when_pass_one_day() {
            test("common item", 0, 10, "common item, -1, 8");
        }

        @Test
        void should_be_able_to_keep_quality_to_positive_if_common_item_quality_reduce_to_negative() {
            test("common item", 0, 0, "common item, -1, 0");
        }

        @Test
        void should_be_able_to_add_1_quality_if_item_is_aged_brie() {
            test("Aged Brie", 10, 0, "Aged Brie, 9, 1");
        }

        @Test
        void should_be_able_to_keep_quality_to_50_if_aged_brie_quality_increase_up_on_50() {
            test("Aged Brie", 10, 50, "Aged Brie, 9, 50");
        }

        @Test
        void should_be_able_to_keep_quality_and_sell_in_when_item_is_sulfuras() {
            test("Sulfuras, Hand of Ragnaros", 0, 80, "Sulfuras, Hand of Ragnaros, 0, 80");
        }

        @Test
        void should_be_able_to_add_1_quality_of_backstage_pass_when_pass_one_day() {
            test("Backstage passes to a TAFKAL80ETC concert", 50, 10, "Backstage passes to a TAFKAL80ETC concert, 49, 11");
        }

        @Test
        void should_be_able_to_add_2_quality_of_backstage_pass_when_sell_in_is_in_10() {
            test("Backstage passes to a TAFKAL80ETC concert", 10, 10, "Backstage passes to a TAFKAL80ETC concert, 9, 12");
        }

        @Test
        void should_be_able_to_add_3_quality_of_backstage_pass_when_sell_in_is_in_5() {
            test("Backstage passes to a TAFKAL80ETC concert", 5, 10, "Backstage passes to a TAFKAL80ETC concert, 4, 13");
        }

        @Test
        void should_be_able_to_have_none_quality_of_backstage_when_sell_in_is_0() {
            test("Backstage passes to a TAFKAL80ETC concert", 0, 10, "Backstage passes to a TAFKAL80ETC concert, -1, 0");
        }

        private void test(String item, int sellIn, int quality, String actual) {
            Item commonItem = Item.newInstance(Item.newInstance(item, sellIn, quality));
            commonItem.updateQuality();
            assertEquals(commonItem.toString(), actual);
        }
    }
}
