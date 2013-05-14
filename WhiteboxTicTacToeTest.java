import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.*;
import com.example.android.tictactoe.*;


public class WhiteboxTicTacToeTest extends ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;
	
	public WhiteboxTicTacToeTest() {
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
	
	public void testWinGameText() {
		solo.clickOnButton(0);
		solo.clickOnScreen(120, 200);
		solo.clickOnButton(0);
		solo.clickOnScreen(240, 350);
		solo.clickOnButton(0);
		solo.clickOnScreen(360, 500);
		solo.clickOnButton(0);
		assertTrue("Played full game hoping for win text", solo.searchText("Player 1"));
	}
	
	public void testLoseGameText() {
		solo.clickOnButton(0);
		solo.clickOnScreen(120, 200);
		solo.clickOnButton(0);
		solo.clickOnScreen(360, 200);
		solo.clickOnButton(0);
		solo.clickOnScreen(360, 350);
		solo.clickOnButton(0);
		solo.clickOnScreen(120, 500);
		solo.clickOnButton(0);
		assertTrue("Played full game hoping for lose text", solo.searchText("Player 2"));
	}
}
