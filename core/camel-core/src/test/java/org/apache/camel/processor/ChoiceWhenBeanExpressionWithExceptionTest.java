/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.processor;

import org.apache.camel.Body;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ContextTestSupport;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ChoiceWhenBeanExpressionWithExceptionTest extends ContextTestSupport {
    private MockEndpoint gradeA;
    private MockEndpoint otherGrade;

    protected void verifyGradeA(String endpointUri) throws Exception {
        gradeA.reset();
        otherGrade.reset();
        gradeA.expectedMessageCount(0);
        otherGrade.expectedMessageCount(0);

        try {
            template.sendBody(endpointUri, new Student(95));
            fail();
        } catch (CamelExecutionException e) {
            // expected
        }
        assertMockEndpointsSatisfied();
    }

    public void verifyOtherGrade(String endpointUri) throws Exception {
        gradeA.reset();
        otherGrade.reset();
        gradeA.expectedMessageCount(0);
        otherGrade.expectedMessageCount(0);

        try {
            template.sendBody(endpointUri, new Student(60));
            fail();
        } catch (CamelExecutionException e) {
            // expected
        }

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testBeanExpression() throws Exception {
        verifyGradeA("direct:expression");
        verifyOtherGrade("direct:expression");
    }

    @Test
    public void testMethod() throws Exception {
        verifyGradeA("direct:method");
        verifyOtherGrade("direct:method");
    }

    @Override
    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();

        gradeA = getMockEndpoint("mock:gradeA");
        otherGrade = getMockEndpoint("mock:otherGrade");
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("direct:expression").choice().when(method(MyBean.class, "isGradeA")).to("mock:gradeA").otherwise()
                        .to("mock:otherGrade").end();

                from("direct:method").choice().when().method(MyBean.class).to("mock:gradeA").otherwise().to("mock:otherGrade")
                        .end();
            }
        };
    }

    public static class MyBean {
        public boolean isGradeA(@Body Student student) {
            throw new RuntimeException("Bean predicated threw exception!");
        }
    }

    static class Student {
        private final int grade;

        Student(int grade) {
            this.grade = grade;
        }

        public int getGrade() {
            return grade;
        }
    }

}
