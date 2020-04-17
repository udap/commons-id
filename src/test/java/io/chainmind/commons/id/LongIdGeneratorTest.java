package io.chainmind.commons.id;

import org.junit.Assert;
import org.junit.Test;

import io.chainmind.commons.id.LongIdGenerator;

/**
 * Long 类型ID生成器
 * Created by liuzhaoming on 2017/11/23.
 */
public class LongIdGeneratorTest {

    private LongIdGenerator generator = new LongIdGenerator(1L);

    @Test
    public void generateId() throws Exception {
        Long id = generator.generate();
        System.out.println("Long ID: " + id);
        Assert.assertEquals(19, String.valueOf(id).length());
    }

}