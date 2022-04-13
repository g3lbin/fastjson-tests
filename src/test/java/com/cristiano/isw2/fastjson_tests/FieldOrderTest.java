package com.cristiano.isw2.fastjson_tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.alibaba.fastjson.JSON;

@RunWith (value=Parameterized.class)
public class FieldOrderTest {

	String expectedJson;
	Person p;
	String pName;
	School s;
	String sName;


	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			// expectedJson, pName, sName
			{"{\"name\":\"njb\",\"school\":{\"name\":\"llyz\"}}", "njb", "llyz"},
		});
	}

	public FieldOrderTest(String expectedJson, String pName, String sName) {
		this.expectedJson = expectedJson;
		this.pName = pName;
		this.sName = sName;
	}

	@Before
	public void configure() {
		p = new Person();
		p.setName(pName);
		s = new School();
        s.setName(sName);
        p.setSchool(s);
	}

	@Test
    public void test_field_order() throws Exception {
        assertEquals(expectedJson, JSON.toJSONString(p));
    }

    public static class Person {
        private String name;
        private School school;

        public boolean isSchool() {
            return false;
        }

        public School getSchool() {
            return school;
        }

        public void setSchool(School school) {
            this.school = school;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class School {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}