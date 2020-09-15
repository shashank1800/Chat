package com.shashankbhat.chat;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by SHASHANK BHAT on 15-Sep-20.
 */

@SmallTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void addMessageToBothSide(){

        onView(withId(R.id.message_et)).perform(typeText("Hey!!"));
        onView(withId(R.id.send1)).perform(click());

        onView(withId(R.id.message_et)).perform(typeText("Hii Pai"));
        onView(withId(R.id.send2)).perform(click());

        onView(withId(R.id.message_et)).perform(typeText("Computer generated message"));
        onView(withId(R.id.send2)).perform(click());
    }
}