package quickstart;

public class FooServiceImpl implements FooService {
	public String hello(String name) {
		System.out.println(name + " invoked rpc service");
		return "hello " + name;
	}
}