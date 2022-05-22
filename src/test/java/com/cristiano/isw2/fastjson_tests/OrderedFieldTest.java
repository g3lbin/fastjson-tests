package com.cristiano.isw2.fastjson_tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

@RunWith (value=Parameterized.class)
public class OrderedFieldTest {

	private int modelId;
	private String text;
	private Model model;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			// modelId, feature
			{1001},
			{-1},
			{0},
		});
	}

	public OrderedFieldTest(int modelId) {
		configure(modelId);
	}

	public void configure(int modelId) {
		this.modelId = modelId;

		text = "{\"id\":" + modelId + "}";
		model = JSON.parseObject(text, Model.class, Feature.OrderedField);
	}

	@Test
    public void test_ordered_field() throws Exception {
        Assert.assertEquals(modelId, model.getId());
        Assert.assertEquals(text, JSON.toJSONString(model));
    }
    
    public static interface Model {
        public int getId();
        public void setId(int value);
    }
}
