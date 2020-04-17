package io.chainmind.commons.id;

import org.junit.Assert;
import org.junit.Test;

import io.chainmind.commons.id.ShortCardIdGenerator;

import java.util.Random;

/**
 * 单元测试用例
 * Created by liuzhaoming on 2018/07/11.
 */
public class ShortCardIdGeneratorTest {

    private ShortCardIdGenerator cardIdGenerator = new ShortCardIdGenerator();

    @Test
    public void generate() throws Exception {
        Long id = cardIdGenerator.generate();
        System.out.println(id);
        Assert.assertEquals(13, String.valueOf(id).length());
    }

    @Test
    public void validate() throws Exception {
        Long id = cardIdGenerator.generate();
        Assert.assertTrue(cardIdGenerator.validate(id));
        Assert.assertFalse(cardIdGenerator.validate(++id));
    }

    @Test
    public void parse() throws Exception {
        Long id = cardIdGenerator.generate();
        Long[] results = cardIdGenerator.parse(id);
        Assert.assertTrue(cardIdGenerator.validate(id));
        Assert.assertTrue(results[1] == 1L);
        Assert.assertTrue(results[2] < 20L);
    }

    @Test
    public void performance() throws Exception {
        long num = 100;
        for (int i = 0; i < num; i++) {
            Long id = cardIdGenerator.generate();
            System.out.println(id);
        }
    }

    @Test
    public void crash() {
        long num = 10000000;
        long passNum = 0;
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 16; j++) {
                sb.append(random.nextInt(5) / 10);
            }

            long id = Long.valueOf(sb.toString());
            if (cardIdGenerator.validate(id)) {
                passNum++;
            }
        }

        System.out.println(passNum);
    }

    @Test
    public void crash1() {
        long num = 1000000;
        long passNum = 0;
        Long id = cardIdGenerator.generate();
        for (int i = 0; i < num; i++) {
            if (cardIdGenerator.validate(++id)) {
                passNum++;
            }
        }

        System.out.println(passNum);
    }
}
