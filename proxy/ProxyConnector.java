package astonTraine.proxy;

public class ProxyConnector  implements Connector{

    private SomeConnector connector;

    @Override
    public void uploadFile(String file) {
        init();
        if(validate(file)){
            connector.uploadFile(file);
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void receiveFile(String fileName) {
        init();
        if(validate(fileName)){
            connector.receiveFile(fileName);
        }else {
            throw new IllegalArgumentException();
        }
    }

    private void init() {
        if (connector == null) {
            connector = new SomeConnector(new Server());
        }
    }
    private boolean validate(String file){
        return !file.isEmpty();
    }
}
