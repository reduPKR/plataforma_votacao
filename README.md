##  
Plataforma de votação  
projeto para praticar   
- Java  
- REST  
- Docker  
- Kafka  
- Microserviços  
  
  
### Docker  
#### rede  
docker network create urna-mysql  
docker network ls  
  

#### Criar imagem
docker image build -t urna-jdbc .  
docker image build -t candidato-jdbc .  
docker image build -t eleitor-jdbc .

#### Executar docker-compose
docker-compose up  
