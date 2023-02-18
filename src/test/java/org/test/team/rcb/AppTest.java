package org.test.team.rcb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	AppUtil appUtil = new AppUtil();

	@Test
	public void verifyForeignPlayerCount() throws Exception {
		assertTrue("Foreign playes", appUtil.getForeignPlayerCount() <= 4);
	}

	@Test
	public void verifyWicketKeeperCount() throws Exception {
		assertTrue("Wicket Keepers", appUtil.getWicketKeeperCount() >= 1);
	}
}
