Calling actuator endpoint
------------------------------------------------------------------
A) Affects the log level change in only one end point.
   Traffic to actuator needs to be enabled
   Zero down time
------------------------------------------------------------------
B) To update logging in all pods dynamically, you can:

    kubectl get pods -l app=dynamic-logging-app -o name | \
    while read pod; do
    POD_IP=$(kubectl get $pod -o jsonpath='{.status.podIP}')
    curl -X POST http://$POD_IP:8080/actuator/loggers/com.kailas \
    -H "Content-Type: application/json" \
    -d '{"configuredLevel":"TRACE"}'
    done

    Zero downtime, requires access kubectl and curl
------------------------------------------------------------------
Option 2: Messaging: Each pods needs to subscribe kafka topic
------------------------------------------------------------------
Option 3: spring-cloud-starter-kubernetes-client-config
------------------------------------------------------------------
