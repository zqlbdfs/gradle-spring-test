package com.my.swagger.util;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {

    @Test
    public void addTest(){
        Assert.assertEquals(Double.valueOf(2),  MathUtil.add(1,1));
        Assert.assertEquals(Double.valueOf(3),  MathUtil.add(3,1));
        Assert.assertEquals(Double.valueOf(4),  MathUtil.add(3,1));
//        Assert.assertEquals(java.util.Optional.of(2),  MathUtil.add(3,1));

    }
}
