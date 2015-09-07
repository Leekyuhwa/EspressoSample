package backgomeproject.espressosample;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Checks.checkNotNull;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;

@RunWith(AndroidJUnit4.class)
public class ListActivityTest extends TestCase {

	@Rule
	public ActivityTestRule<ListActivity> mainActivityTestRule = new ActivityTestRule<>(ListActivity.class);

	@Test
	public void ListView_테스트() {
		onData(anything()).inAdapterView(withId(R.id.listview)).atPosition(70).perform(click());
	}

	public static Matcher<Object> withItemContent(String expectedText) {
		checkNotNull(expectedText);
		return withItemContent(equalTo(expectedText));
	}

	public static Matcher<Object> withItemContent(final Matcher<String> itemTextMatcher) {
		checkNotNull(itemTextMatcher);
		return new BoundedMatcher<Object, Map>(Map.class) {
			@Override
			public boolean matchesSafely(Map map) {
				return hasEntry(equalTo("STR"), itemTextMatcher).matches(map);
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("with item content: ");
				itemTextMatcher.describeTo(description);
			}
		};
	}
}
