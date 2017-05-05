package quickstart;

import com.weibo.api.motan.rpc.ResponseFuture;

public interface FooServiceAsync extends FooService {
  ResponseFuture helloAsync(String name);
}
