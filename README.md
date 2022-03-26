##  
Plataforma de votação  
projeto para praticar   
- Java  
- REST  
- Docker  
- Kafka  
  
### Docker  
#### rede  
docker network create urna-mysql  
docker network ls  
  

#### Criar imagem
docker image build -t urna-jdbc .  
docker image build -t candidato-jdbc . 

#### Executar docker-compose
docker-compose up  
  
#### Criar topicos no kafka  
kafka-topics --list --bootstrap-server localhost:9092  
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic VALIDAR_VOTO_CANDIDATO