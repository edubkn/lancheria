O projeto pode ser rodado num container Docker rodando os seguintes comandos:

// para gerar a imagem Docker local:
```
./gradlew distDocker
```

// para rodar a imagem:
```
docker run -p 8080:8080 br.com.lancheria/lancheria:0.0.1-SNAPSHOT
```

Ou, caso não tenha ou não queira rodar com Docker, pode usar o seguinte comando, sendo necessário ter apenas uma JRE instalada:
```
gradlew bootRun
```