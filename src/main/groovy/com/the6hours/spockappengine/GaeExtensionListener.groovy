package com.the6hours.spockappengine

import com.google.appengine.tools.development.ApiProxyLocal
import com.google.appengine.tools.development.ApiProxyLocalFactory
import com.google.appengine.tools.development.LocalServerEnvironment
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig
import com.google.appengine.tools.development.testing.LocalServiceTestHelper
import com.google.appengine.tools.development.testing.LocalTaskQueueTestConfig
import com.google.appengine.tools.development.testing.LocalURLFetchServiceTestConfig
import com.google.apphosting.api.ApiProxy
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

/**
 *
 * @author Igor Artamonov (http://igorartamonov.com)
 * @since 16.03.13
 */
class GaeExtensionListener extends AbstractRunListener {

    String webappPath = 'src/main/webapp'

    LocalServiceTestHelper helper

    @Override
    void beforeSpec(SpecInfo spec) {
        //log.info("Init GAE for feature '$spec.name'")
        ApiProxyLocalFactory proxyFactory = new ApiProxyLocalFactory()
        LocalServerEnvironment env = [
                getAppDir: { new File(webappPath) },
                getAddress: { "localhost" },
                getPort: { 8080 },
                waitForServerToStart: {  }
        ] as LocalServerEnvironment
        ApiProxyLocal proxy = proxyFactory.create(env)

        LocalURLFetchServiceTestConfig localURLFetchServiceTestConfig = new LocalURLFetchServiceTestConfig();
        LocalTaskQueueTestConfig taskQueueTestConfig = new LocalTaskQueueTestConfig()
        taskQueueTestConfig.setQueueXmlPath("${webappPath}/WEB-INF/queue.xml")
        taskQueueTestConfig.disableAutoTaskExecution = true

        LocalDatastoreServiceTestConfig datastoreService = new LocalDatastoreServiceTestConfig()
        datastoreService.noStorage = true

        helper = new LocalServiceTestHelper(localURLFetchServiceTestConfig, taskQueueTestConfig, datastoreService)

        ApiProxy.setEnvironmentForCurrentThread(new TestEnvironment())
        ApiProxy.setDelegate(proxy)
        //log.info("GAE for feature '$spec.name' is initialized")
    }

    @Override
    void beforeFeature(FeatureInfo feature) {
        //log.info("Init GAE for feature '$feature.name'")
        helper.setUp()
    }


    @Override
    void afterFeature(FeatureInfo feature) {
        //log.info("Cleanup GAE after feature '$feature.name'")
        helper.tearDown()
    }
}
