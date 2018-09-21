package com.phoenix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.phoenix.service.hystrix.CommandHelloWorld;
import com.phoenix.service.hystrix.RemoteServiceTestCommand;
import com.phoenix.service.hystrix.RemoteServiceTestSimulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testExampleHystrix(){
		//assertThat(new CommandHelloWorld("Bob").execute(), equalTo("Hello Bob!"));

		System.out.println(new CommandHelloWorld("Bob").execute());
	}

	@Test
	public void testExampleHystrix2()
			throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand
				.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroup2"));

		String res = new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(100)).execute();
		System.out.println(res);


	}

	@Test
	public void testExampleHystrix3()
			throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand
				.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupTest4"));

		HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
		commandProperties.withExecutionTimeoutInMilliseconds(10000);
		config.andCommandPropertiesDefaults(commandProperties);

		String res = new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute();
		System.out.println(res);
	}

	// problem
	@Test(expected = HystrixRuntimeException.class)
	public void testExampleHystrix4()
			throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand
				.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupTest5"));

		HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
		commandProperties.withExecutionTimeoutInMilliseconds(5000);
		config.andCommandPropertiesDefaults(commandProperties);

		new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(15000)).execute();
	}


	@Test
	public void testExampleHystrix5() throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand
				.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupThreadPool"));

		HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
		commandProperties.withExecutionTimeoutInMilliseconds(10000);
		config.andCommandPropertiesDefaults(commandProperties);

		config.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
				.withMaxQueueSize(10)
				.withCoreSize(3)
				.withQueueSizeRejectionThreshold(10));

		String res = new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute();
		System.out.println(res);
	}




	// Short Circuit Breaker Pattern 短路断路器
	@Test
	public void givenCircuitBreakerSetup_whenRemoteSvcCmdExecuted_thenReturnSuccess()
			throws InterruptedException {

		HystrixCommand.Setter config = HystrixCommand
				.Setter
				.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupCircuitBreaker"));

		HystrixCommandProperties.Setter properties = HystrixCommandProperties.Setter();
		properties.withExecutionTimeoutInMilliseconds(1000);
		properties.withCircuitBreakerSleepWindowInMilliseconds(4000);
		properties.withExecutionIsolationStrategy
				(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
		properties.withCircuitBreakerEnabled(true);
		properties.withCircuitBreakerRequestVolumeThreshold(1);

		config.andCommandPropertiesDefaults(properties);
		config.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
				.withMaxQueueSize(1)
				.withCoreSize(1)
				.withQueueSizeRejectionThreshold(1));

		this.invokeRemoteService(config, 10000);
		this.invokeRemoteService(config, 10000);
		this.invokeRemoteService(config, 10000);

		// >4000
		Thread.sleep(5000);

		String res = new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute();

		String res1 = new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute();

		String res2 = new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500)).execute();
	}

	public String invokeRemoteService(HystrixCommand.Setter config, int timeout)
			throws InterruptedException {

		String response = null;

		try {
			response = new RemoteServiceTestCommand(config,
					new RemoteServiceTestSimulator(timeout)).execute();
		} catch (HystrixRuntimeException ex) {
			System.out.println("ex = " + ex);
		}

		return response;
	}



}
