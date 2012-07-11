package com.leandog.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindsStepsForFeatures {

    
    @Test
    public void findsStepsForFeature() throws Exception {
        Steps steps = new StepFinder("com.leandog.test").findStepsFor(new SampleFeature("local fake"));
        String actualClassName = steps.getClass().getName();
        assertEquals("com.leandog.test.LocalFakeSteps", actualClassName);
    }

    @Test
    public void findsStepsForAFeatureInADifferentPackage() throws Exception {
        Steps steps = new StepFinder("com.leandog.test.fake").findStepsFor(new SampleFeature("fake"));
        assertEquals("com.leandog.test.fake.FakeSteps", steps.getClass().getName());
    }

    @Test(expected = NoStepsFoundException.class)
    public void itLetsMeKnowWhenItCantFindSteps() throws Exception {
        new StepFinder("com.leandog.test").findStepsFor(new SampleFeature("this is fake"));
    }
     
}

class LocalFakeSteps implements Steps {
}