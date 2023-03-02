# Kafka setup minikube

- minikube start --memory=4096
- minikube addons enable ingress
- https://strimzi.io/quickstarts/
- https://github.com/strimzi/strimzi-kafka-operator/issues/4042
- When executing kubectl apply -f https://strimzi.io/examples/latest/kafka/kafka-persistent-single.yaml -n kafka ---> download file and add external loadbalancer as in kafka-persistent-single.yaml OR directly apply this file
- minikube tunnel
- Use bootstrap server as localhost:9094

# Strimzi KafkaBridge for ReST access to Kafka Cluster

- Below are for HTTP access to kafka
- https://strimzi.io/blog/2019/11/05/exposing-http-bridge/
- k apply -f kafka-bridge.yaml -n kafka
- k apply -f my-bridge-ingress.yaml -n kafka
- Modify wsl and windows host


# Sample commands

- SSH into kafka broker cd /opt/kafka/bin
```sh
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4 --topic appdata
./kafka-topics.sh --topic appdata --bootstrap-server localhost:9092 --describe
./kafka-console-consumer.sh --topic appdata --bootstrap-server localhost:9092 --from-beginning --property print.key=true --property print.partition=true [--partition 1]
./kafka-topics.sh --delete --bootstrap-server localhost:9092 --topic appdata
```
```sh
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4 --topic appdata.DLT
./kafka-topics.sh --topic appdata.DLT --bootstrap-server localhost:9092 --describe
./kafka-console-consumer.sh --topic appdata.DLT --bootstrap-server localhost:9092 --from-beginning --property print.key=true --property print.partition=true [--partition 1]
./kafka-topics.sh --delete --bootstrap-server localhost:9092 --topic appdata.DLT
```
```sh
./kafka-consumer-groups.sh  --list --bootstrap-server localhost:9092
./kafka-consumer-groups.sh --describe --group fooGroup --bootstrap-server localhost:9092
```