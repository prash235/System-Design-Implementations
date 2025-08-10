// Subject
interface Service {
    void request();
}

// Real Subject (remote object)
class RemoteService implements Service {
    @Override
    public void request() {
        System.out.println("Performing operation on remote server...");
    }
}

// Proxy
class RemoteServiceProxy implements Service {
    private Service remoteService;

    public RemoteServiceProxy(Service remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public void request() {
        System.out.println("Connecting to remote server...");
        remoteService.request();
        System.out.println("Closing connection.");
    }
}

// Client
public class RemoteProxyExample {
    public static void main(String[] args) {
        Service remoteService = new RemoteService();
        Service proxy = new RemoteServiceProxy(remoteService);

        proxy.request();
    }
}
