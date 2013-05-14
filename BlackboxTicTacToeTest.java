import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.*;
import com.example.android.tictactoe.*;
import com.example.android.tictactoe.library.*;


public class BlackboxTicTacToeTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;
	
	public BlackboxTicTacToeTest() {
		super("com.example.android.tictactoe", MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@Override
	protected void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}
	
	public void testPlayerFirstButton_Works() {
		solo.clickOnButton(0);
		solo.assertCurrentActivity("Pressed player first button", GameActivity.class);
	}
	
	public void testPlayerFirst_OneMoveWorks() {
		solo.clickOnButton(0);
		solo.clickOnScreen(120, 200);
		solo.clickOnButton(0);
		assertTrue("Player prompt text not found", solo.searchText("Player 1's turn -- that's you!"));
	}
	
	public void testPlayerFirst_BackButtonWorks() {
		solo.clickOnButton(0);
		solo.goBack();
		solo.assertCurrentActivity("Clicking back after starting game", MainActivity.class);
	}
}
