package jammazwan.xaq;

import org.apache.camel.builder.RouteBuilder;


public class XaqRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
		from("direct:xaq").to("jetty:http://www.wired.com/").to("file://.?fileName=test.html").to("mock:assert");
    }
}
