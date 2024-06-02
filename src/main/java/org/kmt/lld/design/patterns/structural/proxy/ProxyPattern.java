package org.kmt.lld.design.patterns.structural.proxy;

/**
 * Proxy Design Pattern Example
 *
 * Problem:
 * Direct access to a complex or resource-intensive object can lead to performance issues
 * or security concerns. For example, creating a heavyweight object might be expensive
 * in terms of memory or processing time.
 *
 * Solution:
 * The Proxy design pattern provides an object that acts as a substitute for a real service
 * object used by a client. A proxy receives client requests, does some work (access control,
 * caching, etc.) and then passes the request to a service object.
 *
 * Components:
 * - Subject/Service: Interface implemented by both the RealService and the Proxy.
 * - RealService: The real object that the proxy represents.
 * - Proxy: Provides additional functionality (like access control, caching) and controls
 *          access to the RealService.
 * - Client: Uses the Proxy to interact with the RealService.
 *
 * Where to Use:
 * - Use the Proxy pattern when you need to control access to an object, for instance, when objects are resource-intensive to create,
 *   or when additional actions are required before or after accessing an object.
 * - Examples include lazy initialization, access control, logging, or caching.
 */

// Subject interface defining a common interface for both RealService and ProxyService
interface Service {
    void request();
}

// RealService class that implements the Service interface and handles the actual request
class RealService implements Service {
    @Override
    public void request() {
        // Simulate a complex and time-consuming operation
        System.out.println("RealService: Handling request.");
    }
}

/**
 * Proxy class implements the Service Interface and depends on RealService.
 * It simplifies and controls access to the RealService
 */
class ProxyService implements Service {
    private RealService realService;

    @Override
    public void request() {
        if (realService == null) {
            // Lazy initialization: create RealService only when needed
            realService = new RealService();
        }
        // Additional functionality: logging
        System.out.println("ProxyService: Logging request.");

        // Delegate the request to the RealService
        realService.request();
    }
}

// Client code that uses the ProxyService to interact with the RealService
public class ProxyPattern {
    public static void main(String[] args) {
        // Create a proxy object to interact with the RealService
        Service service = new ProxyService();

        // Client uses the service interface to make a request, abstracted away its using a proxy
        service.request(); // Proxy simplifies and controls access to the RealService
    }
}
