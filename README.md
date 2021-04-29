#### OSGI Logging

Although there can be multiple ways to create an OSGI Bundle. I have taken a simple approach of using bndtools to create an OSGI Bundle.
This is a simple bundle to override the logevent object.

Let me give a brief about the files avaialble in the src folder.
1. Activator class - It implements Bundle Activator to log something on console based on bundle start/stop.
2. CustomAppender class - Its basically a plugin for a custom appender. It extends AbstractStringLayout, and then, we override toSerializable method. This method intercepts each logevent object and then converts to any string which can be logged by our custom appender.
3. Main class - This was basically for debugging(Running this class as Java Application to check if the logs are generated properly).

#### Error
Basically, we have our bundle in generated folder. When i did run this bundle using apache karaf, it throws an error saying
```
Error starting bundle 80: Unable to resolve com.demo.customlogger[80](R 80.0): missing requirement [com.demo.customlogger [80](R 80.0)] osgi.wiring.package; (&(osgi.wiring.package=org.apache.logging.log4j.core)(version>=2.14.0)(!(version>=3.0.0))) Unresolved requirements: [[com.demo.customlogger [80](R 80.0)] osgi.wiring.package; (&(osgi.wiring.package=org.apache.logging.log4j.core)(version>=2.14.0)(!(version>=3.0.0)))]``
```

#### Note
This bundle runs when i use apache felix in eclipse.