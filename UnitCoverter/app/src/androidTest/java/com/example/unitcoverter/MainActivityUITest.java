package com.example.unitcoverter;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }

    @Test
    public void canEnterFahrenheit(){
        onView(withId(R.id.conversion_input)).perform(typeText("32"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converted_text)).check(matches(withText("0.00 ºC")));
    }

    @Test
    public void can_not_enter_emptyFarhenheit(){
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converted_text)).check(matches(withText("ºC")));
    }

    @Test
    public void canChangeSpinnerFeet(){
        onView(withId(R.id.conversion_selection)).perform(click());
        onView(withText("feet to meter")).perform(click());
        onView(withId(R.id.conversion_selection)).check(matches(withSpinnerText("feet to meter")));
    }

    @Test
    public void canChangeSpinnerMiles(){
        onView(withId(R.id.conversion_selection)).perform(click());
        onView(withText("miles to kilometers")).perform(click());
        onView(withId(R.id.conversion_selection)).check(matches(withSpinnerText("miles to kilometers")));
    }

    @Test
    public void canEnterFeet(){
        onView(withId(R.id.conversion_input)).perform(typeText("100"));
        onView(withId(R.id.conversion_selection)).perform(click());
        onView(withText("feet to meter")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converted_text)).check(matches(withText("30.48 Meters")));
    }

    @Test
    public void canEnterMile(){
        onView(withId(R.id.conversion_input)).perform(typeText("100"));
        onView(withId(R.id.conversion_selection)).perform(click());
        onView(withText("miles to kilometers")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converted_text)).check(matches(withText("160.93 Kilometers")));
    }

    @Test
    public void canEnterPound(){
        onView(withId(R.id.conversion_input)).perform(typeText("165"));
        onView(withId(R.id.conversion_selection)).perform(click());
        onView(withText("lb to kg")).perform(click());
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.converted_text)).check(matches(withText("74.84 Kilograms")));
    }
}