package com.cristiano.isw2.fastjson_tests;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

public class FieldOrderTest extends TestCase {
    public void test_field_order() throws Exception {
        Person p = new Person();
        p.setName("njb");
        School s = new School();
        s.setName("llyz");
        p.setSchool(s);
        String json = JSON.toJSONString(p);
        assertEquals("{\"name\":\"njb\",\"school\":{\"name\":\"llyz\"}}", json);
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