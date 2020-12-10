package de.gedoplan.seminar.docker.hello_world;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello from Java");
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("OS: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        System.out.println("OS User: " + System.getProperty("user.name"));
    }
}
