// Subject
interface Document {
    void read();
    void write(String content);
}

// Real Subject
class RealDocument implements Document {
    private String content;

    public RealDocument(String content) {
        this.content = content;
    }

    @Override
    public void read() {
        System.out.println("Reading document: " + content);
    }

    @Override
    public void write(String content) {
        this.content = content;
        System.out.println("Document updated to: " + content);
    }
}

// Proxy
class DocumentProxy implements Document {
    private RealDocument realDocument;
    private String role;

    public DocumentProxy(String content, String role) {
        this.realDocument = new RealDocument(content);
        this.role = role;
    }

    @Override
    public void read() {
        realDocument.read();
    }

    @Override
    public void write(String content) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            realDocument.write(content);
        } else {
            System.out.println("Access Denied: Only admins can write.");
        }
    }
}

// Client
public class ProtectionProxyExample {
    public static void main(String[] args) {
        Document adminDoc = new DocumentProxy("Secret Data", "ADMIN");
        adminDoc.read();
        adminDoc.write("New Admin Content");

        Document userDoc = new DocumentProxy("User Data", "USER");
        userDoc.read();
        userDoc.write("User trying to write...");
    }
}
