package jammazwan.xaq;

import java.io.File;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XaqTest extends CamelSpringTestSupport {

    @Override
    protected AbstractXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }

    @Test
    public void testXaq() throws Exception {
		File file = new File("test.html");
		if(file.exists()){
			file.delete();
		}
		MockEndpoint mock = getMockEndpoint("mock:assert");
		mock.expectedFileExists("test.html");
		template.sendBody("direct:xaq", "Hello wired.com");
		mock.assertIsSatisfied();
	
    }

}
