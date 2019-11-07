/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative () {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));

    }

    @Test
    public void addTwoNumbersFloats () {
        double resultAdd = mCalculator.add(1.11f, 1.11d);
        assertThat(resultAdd, is(Matchers.closeTo(2.22, 0.01)));
    }

    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(9d, 4d);
        assertThat(resultSub, is(equalTo(5d)));
    }

    @Test
    public void subWorksWithNegativeResults() {
        double resultSub = mCalculator.sub(2d, 14d);
        assertThat(resultSub, is(equalTo(-12d)));
    }

    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(3d, 5d);
        assertThat(resultMul, is(equalTo(15d)));
    }

    @Test
    public void mulTwoNumbersZero() {
        double resultMul = mCalculator.mul(3d, 0d);
        assertThat(resultMul, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers() {
        double resultPow = mCalculator.div(30d, 5d);
        assertThat(resultPow, is(equalTo(6d)));
    }

    @Test
    public void divByZeroThrows() {
        double resultPow = mCalculator.div(12d, 0d);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powOfTwoNumbers() {
        double resultPow = mCalculator.pow(3, 3);
        assertThat(resultPow, is(equalTo(27d)));
    }

    @Test
    public void powOfNegativeFirstOperand() {
        double resultPow = mCalculator.pow(-4, 3);
        assertThat(resultPow, is(equalTo(-64d)));
    }

    @Test
    public void powOfNegativeSecondOperand() {
        double resultPow = mCalculator.pow(5, -2);
        assertThat(resultPow, is(equalTo(0.04d)));
    }

    @Test
    public void powOfZeroAndPositiveOperand() {
        double resultPow = mCalculator.pow(0, 4);
        assertThat(resultPow, is(equalTo(0d)));
    }

    @Test
    public void powOfZeroSecondOperand() {
        double resultPow = mCalculator.pow(6, 0);
        assertThat(resultPow, is(equalTo(1d)));
    }

    @Test
    public void powOfZeroAndNegativeOne() {
        double resultPow = mCalculator.pow(0, -1);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powOfNegativeZeroAndAnyNumber() {
        double resultPow = mCalculator.pow(-0, 10);
        assertThat(resultPow, is(equalTo(0d)));
    }
}