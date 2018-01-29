package cn.titan.test.io;

import cn.titan.spring.reader.io.Resource;
import cn.titan.spring.reader.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoaderTest {
	@Test
	public void test() throws IOException {
		ResourceLoader loader = new ResourceLoader();
		Resource resource = loader.getResource("spring.xml");
		InputStream inputStream = resource.getInputStream();
		Assert.assertNotNull(inputStream);
	}
}
