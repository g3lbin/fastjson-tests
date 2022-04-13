package com.cristiano.isw2.fastjson_tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

@RunWith (value=Parameterized.class)
public class OrderedFieldTest {

	private int expectedId;
	private String text;
	private Feature feature;
	private Model model;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			// expectedId, text, feature
			{1001, "{\"id\":1001}", Feature.OrderedField},
		});
	}

	public OrderedFieldTest(int expectedId, String text, Feature feature) {
		this.expectedId = expectedId;
		this.text = text;
		this.feature = feature;
	}

	@Before
	public void configure() {
		model = JSON.parseObject(text, Model.class, feature);
	}

	@Test
    public void test_ordered_field() throws Exception {
        Assert.assertEquals(expectedId, model.getId());
        Assert.assertEquals(text, JSON.toJSONString(model));
    }
    
    public static interface Model {
        public int getId();
        public void setId(int value);
    }
}
