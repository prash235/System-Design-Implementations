import java.util.*;

// Component
interface FileSystemNode {
    String getName();
    void open();
}

// Leaf
class FileNode implements FileSystemNode {
    private String name;
    private String content;

    public FileNode(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void open() {
        System.out.println("📄 Opening file: " + name);
        System.out.println("----- Content -----");
        System.out.println(content);
        System.out.println("-------------------");
    }
}

// Composite
class FolderNode implements FileSystemNode {
    private String name;
    private Map<String, FileSystemNode> children = new HashMap<>();

    public FolderNode(String name) {
        this.name = name;
    }

    public void add(FileSystemNode node) {
        children.put(node.getName(), node);
    }

    public FileSystemNode getChild(String name) {
        return children.get(name);
    }

    public Collection<FileSystemNode> getChildren() {
        return children.values();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void open() {
        System.out.println("📁 Folder: " + name);
        ls();
    }

    public void ls() {
        for (FileSystemNode node : children.values()) {
            if (node instanceof FolderNode) {
                System.out.println("📂 " + node.getName());
            } else {
                System.out.println("📄 " + node.getName());
            }
        }
    }
}

// FileSystem Controller
class FileSystem {
    private FolderNode root;
    private FolderNode currentFolder;

    public FileSystem(FolderNode root) {
        this.root = root;
        this.currentFolder = root;
    }

    public void ls() {
        currentFolder.ls();
    }

    public void cd(String folderName) {
        if (folderName.equals("..")) {
            if (currentFolder == root) {
                System.out.println("Already at root directory.");
                return;
            }
            // Simple simulation — no parent reference kept in this version
            System.out.println("Parent navigation not supported in this demo.");
        } else {
            FileSystemNode node = currentFolder.getChild(folderName);
            if (node instanceof FolderNode) {
                currentFolder = (FolderNode) node;
                System.out.println("Changed directory to: " + folderName);
            } else {
                System.out.println(folderName + " is not a folder.");
            }
        }
    }

    public void open(String name) {
        FileSystemNode node = currentFolder.getChild(name);
        if (node != null) {
            node.open();
        } else {
            System.out.println("No such file or folder: " + name);
        }
    }
}

// Client
public class FileSystemSimulation {
    public static void main(String[] args) {
        // Build file system
        FolderNode root = new FolderNode("root");
        FolderNode docs = new FolderNode("Documents");
        FolderNode pics = new FolderNode("Pictures");

        FileNode file1 = new FileNode("resume.pdf", "This is my resume content.");
        FileNode file2 = new FileNode("notes.txt", "Java Composite Pattern Notes.");
        FileNode img = new FileNode("photo.jpg", "[binary image data]");

        docs.add(file1);
        docs.add(file2);
        pics.add(img);

        root.add(docs);
        root.add(pics);

        FileSystem fs = new FileSystem(root);

        // Simulated commands
        System.out.println("\n> ls");
        fs.ls();

        System.out.println("\n> cd Documents");
        fs.cd("Documents");

        System.out.println("\n> ls");
        fs.ls();

        System.out.println("\n> open notes.txt");
        fs.open("notes.txt");

        System.out.println("\n> open resume.pdf");
        fs.open("resume.pdf");
    }
}
