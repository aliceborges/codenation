//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package challenge;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
	public MainTest() {
	}

	@Test
	public void q1() throws Exception {
		System.out.println(new Main().q1());
		Assert.assertNotEquals(0L, (long)(new Main()).q1());
	}

	@Test
	public void q2() throws Exception {
		Assert.assertNotEquals(0L, (long)(new Main()).q2());
	}

	@Test
	public void q3() throws Exception {
		List<String> result = (new Main()).q3();
		Assert.assertNotNull(result);
		Assert.assertEquals(20L, (long)result.size());
	}

	@Test
	public void q4() throws Exception {
		List<String> result = (new Main()).q4();
		Assert.assertNotNull(result);
		Assert.assertEquals(10L, (long)result.size());
	}

	@Test
	public void q5() throws Exception {
		List<String> result = (new Main()).q5();
		Assert.assertNotNull(result);
		Assert.assertEquals(10L, (long)result.size());
	}

	@Test
	public void q6() throws Exception {
		Map<Integer, Integer> result = (new Main()).q6();
		Assert.assertNotNull(result);
		Assert.assertNotEquals(0L, (long)result.size());
	}
}
