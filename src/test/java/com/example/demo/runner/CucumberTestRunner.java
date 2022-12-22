package com.example.demo.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin ="pretty",features= {"src/test/resources/features/APITest.feature"}, glue= {"com.example.demo.stepdefinitions"})
public class CucumberTestRunner {

}