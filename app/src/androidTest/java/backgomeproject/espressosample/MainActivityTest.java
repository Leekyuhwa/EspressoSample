package backgomeproject.espressosample;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

/**
 * Created by coupang on 2015. 9. 2..
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends TestCase {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void EditText에_Text가_원하는_입력값이_써지는지_보는_테스트() {
        onView(withId(R.id.inputField)).perform(typeText("a"), closeSoftKeyboard());
        onView(withId(R.id.inputField)).check(matches(withText("a")));
        onView(withId(R.id.changeText)).perform(click());
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }

    @Test
    public void EditText에있는_Text를_Intent로_넘기고_출력을_확인하는_테스트() {

        onView(withId(R.id.inputField)).perform(typeText("NewText"), closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText("NewText")));

        //화면에 노출된 텍스트를 찾아서 텍스트 비
        //onView((withText("NewText"))).check(matches(withText("NewText")));
    }

    @Test
    public void ListView_테스트() {
        onData(anything()).inAdapterView(withId(R.id.listview)).atPosition(70).perform(click());
    }


}