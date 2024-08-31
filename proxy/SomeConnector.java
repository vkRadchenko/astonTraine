package astonTraine.proxy;

public class SomeConnector implements Connector{
        private final Server server;

    public SomeConnector(Server server) {
        this.server = server;
    }

    @Override
    public void uploadFile(String file) {
        server.putFile(file);
    }

    @Override
    public void receiveFile(String fileName) {
        server.takeFile(fileName);
    }
}
