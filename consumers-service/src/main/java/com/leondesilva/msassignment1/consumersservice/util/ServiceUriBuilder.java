package com.leondesilva.msassignment1.consumersservice.util;

import com.leondesilva.msassignment1.consumersservice.exceptions.ServiceUriBuilderException;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Class to represent the URI builder to communicate with services.
 */
@Component
public class ServiceUriBuilder {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    /**
     * Method to generate the URI for a given service name and path.
     *
     * @param serviceName the service name
     * @param path        the path
     * @return the generated URI
     * @throws ServiceUriBuilderException if an error occurs
     */
    public URI generateUri(String serviceName, String path) throws ServiceUriBuilderException {
        Application orderServiceApp = eurekaClient.getApplication(serviceName);

        if (orderServiceApp == null) {
            throw new ServiceUriBuilderException("Unable to find " + serviceName + " in service registry.");
        }

        List<InstanceInfo> instances = orderServiceApp.getInstances();

        if (CollectionUtils.isEmpty(instances)) {
            throw new ServiceUriBuilderException("Unable to find " + serviceName + " instances");
        }

        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(instances.get(0).getHomePageUrl());
        } catch (URISyntaxException e) {
            throw new ServiceUriBuilderException("Error occurred when trying to build the URI", e);
        }

        if (path != null) {
            uriBuilder.setPath(path);
        }

        URI uri = null;

        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new ServiceUriBuilderException("Error occurred when trying to build the URI", e);
        }
    }
}
