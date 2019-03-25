
# [Webflux Restful](https://github.com/wgaalves/webflux-poc/)

## What you'll build
- A simple reactive api with webflux running on docker

## What you'll need
- Docker CE

## Stack
- Docker
- Java
- Spring Boot
- Cassandra
- WebFlux
- NGINX
- Maven

## Run
- Run command `docker-compose up`

## Endpoints

- [GET] http://localhost/api/planet ( Get All Planets from database )
- [POST] http://localhost/api/planet ( Create Planet Payload
- Payload 
{
	"name":"Alderaan",
	"climate":"testeclima",
	"terrain":"arido"
}
- [DELETE] http://localhost/api/planet/id ( Delete by id )
- [GET] http://localhost/api/planet/id ( Get Planet on database from id )
- [GET] http://localhost/api/planet/search?name= ( Get planet by name on database)
- [GET] http://localhost/api/planet (Get all planets on database)
- [GET] http://localhost/api/swapi/planet/search?name (search on swapi api from name)

