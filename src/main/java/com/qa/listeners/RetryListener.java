package com.qa.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.qa.utils.RetryAnalyzer; // Adjust this to your actual package path

public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>RetryListener applied to: " + testMethod.getName());


    	//if (annotation.getRetryAnalyzerClass() == null) {
    	


            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        //}
    }
}